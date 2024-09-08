package org.cbol.pay.convert;

import org.cbol.common.util.BeanUtil;
import org.cbol.pay.dto.AliPayReqeust;
import org.cbol.pay.dto.PayCommand;
import org.cbol.pay.dto.PayRequest;

import java.util.Objects;

import static org.cbol.pay.enums.PayChannelEnum.ALI_PAY;

public class PayRequestConvert {

    public static PayRequest convert(PayCommand payCommand) {

        PayRequest payRequest = null;
        if (Objects.equals(payRequest.getChannel(), ALI_PAY.getName())){
            payRequest = BeanUtil.convert(payCommand, AliPayReqeust.class);
        }
        return payRequest;
    }

}
