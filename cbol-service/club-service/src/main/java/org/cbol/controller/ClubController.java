package org.cbol.controller;

import lombok.RequiredArgsConstructor;
import org.cbol.common.page.PageResponse;
import org.cbol.common.result.Result;
import org.cbol.common.result.Results;
import org.cbol.service.ClubService;
import org.cbol.vo.ClubInfoVO;
import org.cbol.vo.ClubPageQueryVO;
import org.cbol.vo.ClubRegisterRespVO;
import org.cbol.vo.ClubRegisterVO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/club-service")
@RequiredArgsConstructor
public class ClubController {

	private final ClubService clubService;

	/**
	 * 注册厂牌
	 */
	@PostMapping("/club/register")
	public Result<ClubRegisterRespVO> register(@RequestBody ClubRegisterVO clubRegisterVO) {
		return Results.success(clubService.register(clubRegisterVO));
	}

	/**
	 * 查询厂牌
	 */
	@GetMapping("/club/{clubId}")
	public Result<ClubInfoVO> getClubByClubId(@PathVariable("clubId") Long clubId) {
		return Results.success(clubService.getClubByClubId(clubId));
	}

	/**
	 * 更新厂牌
	 */
	@PutMapping("/club/update")
	public Result<Void> update(@RequestBody ClubInfoVO clubInfoVO) {
		clubService.updateClubInfo(clubInfoVO);
		return Results.success();
	}

	/**
	 * 删除厂牌
	 */
	@DeleteMapping("/club/del/{clubId}")
	public Result<Void> delete(@PathVariable("clubId")Long clubId) {
		clubService.delete(clubId);
		return Results.success();
	}

	/**
	 * 分页查询厂牌信息
	 */
	@PostMapping("/club/page")
	public Result<PageResponse<ClubInfoVO>> pageQuery(@RequestBody ClubPageQueryVO clubPageQueryVO) {
		return Results.success(clubService.pageQuery(clubPageQueryVO));
	}


}
