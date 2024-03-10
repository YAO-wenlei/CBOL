package org.cbol.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.cbol.common.page.PageResponse;
import org.cbol.dao.entity.ArenaDO;
import org.cbol.vo.ArenaCreateRespVO;
import org.cbol.vo.ArenaCreateVO;
import org.cbol.vo.ArenaInfoVO;
import org.cbol.vo.ArenaPageQueryVO;

public interface ArenaService extends IService<ArenaDO> {
	/**
	 * 创建球馆
	 */
	ArenaCreateRespVO creat(ArenaCreateVO arenaCreateVO);

	/**
	 * 查询球馆
	 */
	ArenaInfoVO getArenaById(Long id);

	/**
	 * 修改球馆信息
	 */
	void update(ArenaInfoVO arenaInfoVO);

	/**
	 * 删除球馆
	 */
	void delete(Long id);

	/**
	 * 分页查询球馆信息
	 */
	PageResponse<ArenaInfoVO> pageQuery(ArenaPageQueryVO arenaPageQueryVO);
}
