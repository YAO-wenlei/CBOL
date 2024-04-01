package org.cbol.controller;

import lombok.AllArgsConstructor;
import org.cbol.common.page.PageResponse;
import org.cbol.common.result.Result;
import org.cbol.common.result.Results;
import org.cbol.service.GameService;
import org.cbol.vo.game.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/arena-service/")
@AllArgsConstructor
public class GameController {

    private final GameService gameService;

    /**
     * 创建比赛信息
     */
    @PostMapping("/game/create")
    public Result<GameCreateRespVO> create(@RequestBody GameCreateVO gameCreateVO) {
        return Results.success(gameService.create(gameCreateVO));
    }

    /**
     * 查询比赛信息
     */
    @GetMapping("/game/{gameId}")
    public Result<GameInfoVO> getGameInfoById(@PathVariable("gameId") Long id) {
        return Results.success(gameService.getGameInfoById(id));
    }

    /**
     * 编辑比赛信息
     */
    @PutMapping("/game")
    public Result<Void> updateGameInfo(@RequestBody GameUpdateVO gameUpdateVO) {
        gameService.update(gameUpdateVO);
        return Results.success();
    }

    /**
     * 删除比赛信息
     */
    @DeleteMapping("/game/del/{gameId}")
    public Result<Void> deleteGame(@PathVariable("gameId") Long id) {
        gameService.delete(id);
        return Results.success();
    }

    /**
     * 分页查询比赛信息
     */
    @PostMapping("/game/page")
    public Result<PageResponse<GameInfoVO>> page(@RequestBody GamePageQueryVO gamePageQueryVO) {
        return Results.success(gameService.pageQuery(gamePageQueryVO));
    }

}
