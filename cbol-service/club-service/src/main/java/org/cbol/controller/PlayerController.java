package org.cbol.controller;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.cbol.common.page.PageResponse;
import org.cbol.common.result.Result;
import org.cbol.common.result.Results;
import org.cbol.service.PlayerService;
import org.cbol.vo.PlayerInfoVO;
import org.cbol.vo.PlayerPageQueryVO;
import org.cbol.vo.PlayerRegisterRespVO;
import org.cbol.vo.PlayerRegisterVO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/club-service")
public class PlayerController {

	private final PlayerService playerService;

	/**
	 * 球员注册接口
	 * @param playerRegisterVO 球员注册信息
	 */
	@PostMapping("/player/register")
	public Result<PlayerRegisterRespVO> register(@RequestBody PlayerRegisterVO playerRegisterVO) {
		return Results.success(playerService.register(playerRegisterVO));
	}

	/**
	 * 根据球员id查询球员信息
	 */
	@GetMapping("/player/{id}")
	public Result<PlayerInfoVO> queryPlayerById(@PathVariable("id")Long id) {
		return Results.success(playerService.queryPlayerById(id));
	}

	/**
	 * 更新球员信息
	 */
	@PutMapping("/player/update")
	public Result<Void> updatePlayerInfo(@RequestBody PlayerInfoVO playerInfoVO) {
		playerService.update(playerInfoVO);
		return Results.success();
	}

	/**
	 * 删除球员信息
	 */
	@DeleteMapping("/player/del/{id}")
	public Result<Void> delPlayer(@PathVariable("id") Long id) {
		playerService.delete(id);
		return Results.success();
	}

	/**
	 * 分页查询球员信息
	 */
	@PostMapping("/player/page")
	public Result<PageResponse<PlayerInfoVO>> page(@RequestBody PlayerPageQueryVO pageQueryVO) {
		return Results.success(playerService.pageQuery(pageQueryVO));
	}

	/**
	 * 根据clucId查询厂牌下所有球员
	 */
	@GetMapping("/players")
	public Result<List<PlayerInfoVO>> getPlayers(@Param("clubId") Long clubId) {
		return Results.success(playerService.playersByClubId(clubId));
	}

}



