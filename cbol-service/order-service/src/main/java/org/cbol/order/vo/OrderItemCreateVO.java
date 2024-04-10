package org.cbol.order.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemCreateVO {

    /**
     * 赛程id
     */
    private Long gameId;

    /**
     * 球馆id
     */
    private Long arenaId;

    /**
     * 座位号
     */
    private String seatSn;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 证件号
     */
    private String idCard;

    /**
     * 证件类型
     */
    private Integer idType;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 价格
     */
    private Integer amount;

    /**
     * 订单状态
     */
    private Integer status;
}
