package org.cbol.pay.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PayCommand {
    /**
     * 交易总金额
     */
    private BigDecimal totalAmount;

    /**
     * 交易渠道
     */
    private String channel;

    /**
     * 交易类型
     */
    private Integer tradeType;

    /**
     * 订单号
     */
    private String orderSn;

    /**
     * 订单标题
     */
    private String subject;

    /**
     * 商户交易号
     */
    private String outTradeNo;

}
