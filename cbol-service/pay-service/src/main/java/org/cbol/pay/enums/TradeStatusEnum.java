package org.cbol.pay.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TradeStatusEnum {

    PENDING_PAYMENT("0","待支付"),

    TRADE_SUCCESS("1","交易成功"),

    TRADE_CANCEL("2","取消支付"),

    REFUND("3","退款中"),

    ALREADY_REFUND("4","退款完成"),

    CLOSE("5", "交易关闭");

    /**
     * 编码
     */
    private final String code;

    /**
     * 描述
     */
    private final String des;

}
