package org.cbol.order.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreateVO {

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
    //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") //接收页面入参
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss" )
    private Date competitionTime;

    /**
     * 球馆id
     */
    private Long arenaId;

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

    /**
     * 子订单
     */
    List<OrderItemCreateVO> orderItemCreateVOList;

}
