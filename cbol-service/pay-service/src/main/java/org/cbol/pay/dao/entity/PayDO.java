package org.cbol.pay.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.cbol.database.base.BaseDO;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_pay")
public class PayDO extends BaseDO {
    /**
     * 主键
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    /**
     * 交易流水号
     */
    private String paySn;

    /**
     * 三方支付交易号
     */
    private String tradeNo;

    /**
     * 商户交易号
     */
    private String outTradeNo;

    /**
     * 订单号
     */
    private String orderSn;

    /**
     * 交易金额
     */
    private Integer totalAmount;

    /**
     * 实收金额
     */
    private Integer receiptAmount;

    /**
     * 买家账号id
     */
    private String buyerId;

    /**
     * 支付状态
     */
    private String status;

    /**
     * 订单标题
     */
    private String subject;

    /**
     * 交易时间
     */
    private Date gmtPayment;

    /**
     * 交易渠道
     */
    private String chanel;

    /**
     * 交易类型
     */
    private String tradeType;
}
