package org.cbol.order.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.cbol.database.base.BaseDO;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("t_order")
public class OrderDO extends BaseDO {

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
     * 用户id
     */
    private Long userId;

    /**
     * 赛程id
     */
    private Long gameId;

    /**
     * 比赛时间
     */
    private Date competitionTime;

    /**
     * 球馆id
     */
    private Long arenaId;

    /**
     * 支付时间
     */
    private Date payTime;

    /**
     * 支付类型 微信|支付宝
     */
    private String payType;

    /**
     * 订单总金额
     */
    private Integer totalAmount;

    /**
     * 来源 大麦|官网
     */
    private String source;

    /**
     * 订单类型 0正常 1秒杀 2优惠券
     */
    private Integer type;

    /**
     * 订单状态 0待付款 1已付款 2退款 3已完成
     */
    private Integer status;


}
