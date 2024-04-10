package org.cbol.order.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderQueryVO {
    /**
     * 订单号
     */
    private String orderSn;

    /**
     * 赛程id
     */
    private Long gameId;

    /**
     * 赛程标题
     */
    private String title;
    /**
     * 海报地址
     */
    private String playbillUrl;

    /**
     * 订单总金额
     */
    private BigDecimal totalAmount;

    /**
     * 购买数量
     */
    private Long number;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

}
