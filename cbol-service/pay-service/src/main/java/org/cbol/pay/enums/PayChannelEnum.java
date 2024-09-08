package org.cbol.pay.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 支付渠道类型
 * @author yaowenlei
 */

@Getter
@RequiredArgsConstructor
public enum PayChannelEnum {

    /**
     * 支付宝支付
     */
    ALI_PAY(0,"ALI_APY","支付宝"),

    WECHAT_PAY(1,"WECHAT_PAY","微信支付"),
    ;

    private final Integer code;

    private final String name;

    private final String value;

}
