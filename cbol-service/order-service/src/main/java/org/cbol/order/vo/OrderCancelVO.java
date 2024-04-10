package org.cbol.order.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderCancelVO {
    /**
     * 订单号
     */
    private String orderSn;
}
