package org.cbol.order.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemQueryVO {
    /**
     * 订单号
     */
    private String orderSn;

    /**
     * 座位号
     */
    private String seatSn;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 手机号
     */
    private String phone;

}
