package org.cbol.controller;

import lombok.RequiredArgsConstructor;
import org.cbol.common.page.PageResponse;
import org.cbol.common.result.Result;
import org.cbol.common.result.Results;
import org.cbol.service.ArenaService;
import org.cbol.vo.ArenaCreateRespVO;
import org.cbol.vo.ArenaCreateVO;
import org.cbol.vo.ArenaInfoVO;
import org.cbol.vo.ArenaPageQueryVO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/arena-service")
@RequiredArgsConstructor
public class ArenaController {

	private final ArenaService arenaService;

	/**
	 * 创建球馆
	 */
	@PostMapping("/arena/create")
	public Result<ArenaCreateRespVO> create(@RequestBody ArenaCreateVO arenaCreateVO) {
		return Results.success(arenaService.creat(arenaCreateVO));
	}

	/**
	 * 查询球馆信息
	 */
	@GetMapping("/arena/{id}")
	public Result<ArenaInfoVO> getArenaById(@PathVariable("id") Long id) {
		return Results.success(arenaService.getArenaById(id));
	}

	/**
	 * 修改球馆信息
	 */
	@PutMapping("/arena/update")
	public Result<Void> update(@RequestBody ArenaInfoVO arenaInfoVO) {
		arenaService.update(arenaInfoVO);
		return Results.success();
	}

	/**
	 * 删除球馆
	 */
	@DeleteMapping("/arena/del/{id}")
	public Result<Void> delete(@PathVariable("id") Long id) {
		arenaService.delete(id);
		return Results.success();
	}

	/**
	 * 分页查询球馆信息
	 */
	@PostMapping("/arena/page")
	public Result<PageResponse<ArenaInfoVO>> page(@RequestBody ArenaPageQueryVO arenaPageQueryVO) {
		return Results.success(arenaService.pageQuery(arenaPageQueryVO));
	}

}
