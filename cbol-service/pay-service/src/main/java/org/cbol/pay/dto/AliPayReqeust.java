package org.cbol.pay.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.cbol.pay.enums.PayChannelEnum;
import org.cbol.pay.enums.PayTradeTypeEnum;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AliPayReqeust extends PayRequest {


    /**
     * 商户交易号
     */
    private String outTradeNo;


    @Override
    public String mark() {
        String mark = PayChannelEnum.ALI_PAY.name();
        if (getTradeType() != null){
            mark = PayChannelEnum.ALI_PAY.name() + "_" + PayTradeTypeEnum.findNameByCode(getTradeType());
        }
        return mark;
    }
}
