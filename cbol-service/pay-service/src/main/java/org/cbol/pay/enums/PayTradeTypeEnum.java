package org.cbol.pay.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Objects;

/**
 * 交易方式基础类 每种交易渠道下有多种交易类型 比如：
 * 微信 -> 小程序、网站、app
 * 支付宝 -> 小程序、网站、app
 * 银行卡 -> 网站、app
 * @author yaowenlei
 */

@Getter
@RequiredArgsConstructor
public enum PayTradeTypeEnum {
    /**
     * 网页支付
     * 使用场景：
     */
    NATIVE("0"),
    /**
     * 手机网站
     * 使用场景：
     */
    MOBILE_WEB("1"),
    /**
     * 手机APP支付
     * 使用场景：
     */
    APP("2"),
    /**
     * 当面付
     * 使用场景：
     */
    TO_FACE("3")
    ;
    private final String code;


    public static String findNameByCode(String code) {
        return Arrays.stream(PayTradeTypeEnum.values())
                .filter(each -> Objects.equals(each.getCode(), code))
                .findFirst()
                .map(PayTradeTypeEnum::name)
                .orElse(null);

    }

}
