package org.cbol.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.cbol.common.page.PageResponse;
import org.cbol.common.util.BeanUtil;
import org.cbol.dao.entity.ArenaSeatDO;
import org.cbol.dao.entity.ClubDO;
import org.cbol.dao.entity.GameDO;
import org.cbol.dao.mapper.GameMapper;
import org.cbol.database.util.PageUtil;
import org.cbol.dto.GameInfoDTO;
import org.cbol.service.ArenaSeatService;
import org.cbol.service.ClubService;
import org.cbol.service.GameService;
import org.cbol.vo.game.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GameServiceImpl extends ServiceImpl<GameMapper, GameDO> implements GameService {

    private final ArenaSeatService arenaSeatService;
    private final ClubService clubService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public GameCreateRespVO create(GameCreateVO gameCreateVO) {
        GameDO gameDO = new GameDO();
        this.save(BeanUtil.convert(gameCreateVO, gameDO));

        ArenaSeatDO arenaSeatDO = BeanUtil.convert(gameCreateVO.getArenaSeat(), ArenaSeatDO.class);
        arenaSeatDO.setArenaId(gameDO.getArenaId());
        arenaSeatDO.setGameId(gameDO.getId());
        arenaSeatDO.setRemainingSeat(arenaSeatDO.getSeat());
        arenaSeatService.save(arenaSeatDO);
        return BeanUtil.convert(gameDO, GameCreateRespVO.class);
    }

    @Override
    public GameInfoVO getGameInfoById(Long id) {
        GameInfoDTO gameInfoDTO = this.getBaseMapper().getGameInfoDTOById(id);
        if (ObjectUtil.isEmpty(gameInfoDTO)) {
            return new GameInfoVO();
        }
        GameInfoVO gameInfoVO = BeanUtil.convert(gameInfoDTO, GameInfoVO.class);
        return populateProperty(gameInfoVO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(GameUpdateVO gameUpdateVO) {
        GameDO newGameDO = BeanUtil.convert(gameUpdateVO, GameDO.class);
        LambdaUpdateWrapper<GameDO> gameDOLambdaUpdateWrapper = Wrappers.lambdaUpdate(GameDO.class)
                .eq(GameDO::getId, gameUpdateVO.getId());
        this.baseMapper.update(newGameDO,gameDOLambdaUpdateWrapper);

        ArenaSeatDO newArnaSeatDO = BeanUtil.convert(gameUpdateVO.getArenaSeat(), ArenaSeatDO.class);
        LambdaUpdateWrapper<ArenaSeatDO> seatDOLambdaUpdateWrapper = Wrappers.lambdaUpdate(ArenaSeatDO.class)
                .eq(ArenaSeatDO::getGameId, newGameDO.getId());
        arenaSeatService.update(newArnaSeatDO,seatDOLambdaUpdateWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        this.removeById(id);
        arenaSeatService.removeById(id);
    }

    @Override
    public PageResponse<GameInfoVO> pageQuery(GamePageQueryVO gamePageQueryVO) {
        IPage<GameInfoDTO> iPage = PageUtil.convert(gamePageQueryVO);
        IPage<GameInfoDTO> pageResult = this.getBaseMapper().pageQuery(iPage, gamePageQueryVO);
        return PageUtil.convert(pageResult, each -> {
            GameInfoVO gameInfoVO = BeanUtil.convert(each, GameInfoVO.class);
            return populateProperty(gameInfoVO);
        });
    }

    private GameInfoVO populateProperty(GameInfoVO gameInfoVO) {
        //TODO 查缓存
        Map<Long, ClubDO> clubMap = clubService.list()
                .stream()
                .collect(Collectors.toMap(ClubDO::getId, club -> club));
        ClubDO homeClub = clubMap.get(gameInfoVO.getHomeTeamId());
        gameInfoVO.setHomeTeamName(homeClub.getName());
        gameInfoVO.setHomeTeamLogo(homeClub.getLogoUrl());
        ClubDO guestClub = clubMap.get(gameInfoVO.getGuestTeamId());
        gameInfoVO.setGuestTeamName(guestClub.getName());
        gameInfoVO.setGuestTeamLogo(guestClub.getLogoUrl());
        return gameInfoVO;
    }
}
