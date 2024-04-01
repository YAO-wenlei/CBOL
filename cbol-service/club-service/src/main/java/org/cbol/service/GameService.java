package org.cbol.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.cbol.common.page.PageResponse;
import org.cbol.dao.entity.GameDO;
import org.cbol.vo.game.*;

public interface GameService extends IService<GameDO> {
    GameCreateRespVO create(GameCreateVO gameCreateVO);

    GameInfoVO getGameInfoById(Long id);

    void update(GameUpdateVO gameUpdateVO);

    void delete(Long id);

    PageResponse<GameInfoVO> pageQuery(GamePageQueryVO gamePageQueryVO);
}
