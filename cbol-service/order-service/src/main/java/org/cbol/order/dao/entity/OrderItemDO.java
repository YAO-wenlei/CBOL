package org.cbol.order.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.cbol.database.base.BaseDO;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("t_order_item")
public class OrderItemDO extends BaseDO {
    /**
     * 主键
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    /**
     * 订单号
     */
    private String orderSn;

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
