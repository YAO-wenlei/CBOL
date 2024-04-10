package org.cbol.order.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OrderTypeEnum {

    /**
     * 正常订单
     */
    NORMAL(0),

    /**
     * 秒杀订单
     */
    SECOND_SKILL(1),

    /**
     * 优惠订单
     */
    PREFERENTIAL(2);


    private final Integer type;
}
