package org.cbol.order.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OrderStatusEnum {

    /**
     * 待支付
     */
    PENDING_PAYMENT(0),

    /**
     * 已支付
     */
    ALREADY_PAYMENT(1),

    /**
     * 已完成
     */
    COMPLETED(2),

    /**
     * 退款中
     */
    REFUND(3),

    /**
     * 退款完成
     */
    ALREADY_REFUND(4),

    /**
     * 取消
     */
    CANCEL(5);


    private final Integer status;
}
