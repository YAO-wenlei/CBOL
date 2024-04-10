package org.cbol.order.remote;


import org.cbol.common.result.Result;
import org.cbol.order.remote.vo.GameInfoVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "club${unique-name:}-service",url = "${remote-url:}")
public interface GameRemoteService {

    @GetMapping("/api/arena-service/game/{gameId}")
    public Result<GameInfoVO> getGameInfoById(@PathVariable("gameId") Long id);
}
