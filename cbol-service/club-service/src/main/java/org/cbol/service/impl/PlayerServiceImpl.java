package org.cbol.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.cbol.common.exception.ClientException;
import org.cbol.common.page.PageResponse;
import org.cbol.common.util.BeanUtil;
import org.cbol.dao.entity.PlayerDO;
import org.cbol.dao.mapper.PlayerMapper;
import org.cbol.database.util.PageUtil;
import org.cbol.enums.BaseErrorCode;
import org.cbol.service.PlayerService;
import org.cbol.vo.PlayerInfoVO;
import org.cbol.vo.PlayerPageQueryVO;
import org.cbol.vo.PlayerRegisterRespVO;
import org.cbol.vo.PlayerRegisterVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl extends ServiceImpl<PlayerMapper, PlayerDO> implements PlayerService {

	@Override
	public PlayerRegisterRespVO register(PlayerRegisterVO playerRegisterVO) {
		PlayerDO playerDO = new PlayerDO();
		this.baseMapper.insert(BeanUtil.convert(playerRegisterVO, playerDO));
		return BeanUtil.convert(playerDO, PlayerRegisterRespVO.class);
	}

	@Override
	public PlayerInfoVO queryPlayerById(Long id) {
		PlayerDO playerDO = this.baseMapper.selectById(id);
		if (ObjectUtil.isNull(playerDO)) {
			throw new ClientException(BaseErrorCode.PLAYER_NOT_FOUND);
		}
		return BeanUtil.convert(playerDO, PlayerInfoVO.class);
	}

	@Override
	public void update(PlayerInfoVO playerInfoVO) {
		PlayerDO playerDO = BeanUtil.convert(playerInfoVO, PlayerDO.class);
		LambdaUpdateWrapper<PlayerDO> updateWrapper = Wrappers.lambdaUpdate(PlayerDO.class)
				.eq(PlayerDO::getId, playerInfoVO.getId());
		this.baseMapper.update(playerDO, updateWrapper);
	}

	@Override
	public void delete(Long id) {
		this.baseMapper.deleteById(id);
	}

	@Override
	public PageResponse<PlayerInfoVO> pageQuery(PlayerPageQueryVO pageQueryVO) {
		LambdaQueryWrapper<PlayerDO> queryWrapper = Wrappers.lambdaQuery(PlayerDO.class)
				.eq(ObjectUtil.isNotEmpty(pageQueryVO.getId()), PlayerDO::getId, pageQueryVO.getId())
				.like(ObjectUtil.isNotEmpty(pageQueryVO.getName()), PlayerDO::getName, pageQueryVO.getName())
				.eq(ObjectUtil.isNotEmpty(pageQueryVO.getClubId()), PlayerDO::getClubId, pageQueryVO.getClubId())
				.eq(ObjectUtil.isNotEmpty(pageQueryVO.getPlayerNumber()), PlayerDO::getPlayerNumber, pageQueryVO.getPlayerNumber())
				.eq(ObjectUtil.isNotEmpty(pageQueryVO.getPosition()), PlayerDO::getPosition, pageQueryVO.getPosition())
				.like(ObjectUtil.isNotEmpty(pageQueryVO.getPhone()), PlayerDO::getPhone, pageQueryVO.getPhone());
		IPage<PlayerDO> iPage = this.baseMapper.selectPage(PageUtil.convert(pageQueryVO), queryWrapper);

		return PageUtil.convert(iPage, each -> BeanUtil.convert(each, PlayerInfoVO.class));
	}

	@Override
	public List<PlayerInfoVO> playersByClubId(Long clubId) {
		LambdaQueryWrapper<PlayerDO> queryWrapper = new LambdaQueryWrapper<PlayerDO>()
				.eq(PlayerDO::getClubId, clubId);
		List<PlayerDO> clubPlayers = this.baseMapper.selectList(queryWrapper);
		return BeanUtil.convert(clubPlayers, PlayerInfoVO.class);
	}
}
