package org.cbol.order.enums;

import lombok.AllArgsConstructor;
import org.cbol.common.errorcode.IErrorCode;

@AllArgsConstructor
public enum OrderErrorEnum implements IErrorCode {

    ORDER_NOT_FOUNT("A000200","未找到此订单!");

    private String code;
    private String message;

    @Override
    public String code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }
}
