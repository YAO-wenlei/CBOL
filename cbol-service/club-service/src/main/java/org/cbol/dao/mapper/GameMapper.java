package org.cbol.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;
import org.cbol.dao.entity.GameDO;
import org.cbol.dto.GameInfoDTO;
import org.cbol.vo.game.GamePageQueryVO;

public interface GameMapper extends BaseMapper<GameDO> {
    GameInfoDTO getGameInfoDTOById(Long id);

    IPage<GameInfoDTO> pageQuery(IPage<GameInfoDTO> page, @Param("gamePageQueryVO") GamePageQueryVO gamePageQueryVO);
}
