package org.cbol.pay.controller;

import lombok.RequiredArgsConstructor;
import org.cbol.common.result.Result;
import org.cbol.common.result.Results;
import org.cbol.pay.convert.PayRequestConvert;
import org.cbol.pay.dto.PayCommand;
import org.cbol.pay.dto.PayCreateResp;
import org.cbol.pay.dto.PayRequest;
import org.cbol.pay.service.PayService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pay-service/pay")
@RequiredArgsConstructor
public class PayController {

    private final PayService payService;


    /**
     * 创建交易
     */
    @PostMapping("/creat")
    public Result<PayCreateResp> pay(PayCommand payCommand) {
        PayRequest payRequest = PayRequestConvert.convert(payCommand);
        return Results.success(payService.pay(payRequest));
    }


    /**
     * 根据交易号查询交易数据
     */

    /**
     * 根据订单号查询交易数据
     */
}
