package org.cbol.order.controller;

import lombok.RequiredArgsConstructor;
import org.cbol.common.page.PageResponse;
import org.cbol.common.result.Result;
import org.cbol.common.result.Results;
import org.cbol.order.service.OrderService;
import org.cbol.order.vo.OrderCancelVO;
import org.cbol.order.vo.OrderCreateVO;
import org.cbol.order.vo.OrderPageQueryVO;
import org.cbol.order.vo.OrderQueryVO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order-service/order")
public class OrderController {

    private final OrderService orderService;
    /**
     * 创建订单
     */
    @PostMapping("/create")
    public Result<String> createOrder(@RequestBody OrderCreateVO orderCreateVO) {
        return Results.success(orderService.createOrder(orderCreateVO));
    }
    /**
     * 根据订单号查询订单信息
     */
    @GetMapping("/{orderSn}")
    public Result<OrderQueryVO> getOrder(@PathVariable("orderSn") String orderSn) {
        return Results.success(orderService.getOrder(orderSn));
    }

    /**
     * 根据用户id分页获取所有订单
     */
    @GetMapping("/page")
    public Result<PageResponse<OrderQueryVO>> pageQuery(@RequestBody OrderPageQueryVO pageQueryVO) {
        return Results.success(orderService.pageQueryOrder(pageQueryVO));
    }

    /**
     * 取消订单
     */
    @PutMapping("/cancel")
    public Result<Boolean> cancel(@RequestBody OrderCancelVO orderCancelVO) {
        return Results.success(orderService.cancel(orderCancelVO));
    }

}
