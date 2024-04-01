package org.cbol.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.cbol.common.page.PageResponse;
import org.cbol.dao.entity.PlayerDO;
import org.cbol.vo.player.PlayerInfoVO;
import org.cbol.vo.player.PlayerPageQueryVO;
import org.cbol.vo.player.PlayerRegisterRespVO;
import org.cbol.vo.player.PlayerRegisterVO;

import java.util.List;

/**
 *
 * @author yaowenlei
 */
public interface PlayerService extends IService<PlayerDO> {
	PlayerRegisterRespVO register(PlayerRegisterVO playerRegisterVO);

	PlayerInfoVO queryPlayerById(Long id);

	void update(PlayerInfoVO playerInfoVO);

	void delete(Long id);

	PageResponse<PlayerInfoVO> pageQuery(PlayerPageQueryVO pageQueryVO);

	List<PlayerInfoVO> playersByClubId(Long clubId);
}
