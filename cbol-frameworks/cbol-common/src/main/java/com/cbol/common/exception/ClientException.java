package com.cbol.common.exception;

import com.cbol.common.errorcode.BaseErrorCode;
import com.cbol.common.errorcode.IErrorCode;

/**
 * @author yaowenlei
 * @date 2023年11月25日 9:56 下午
 */
public class ClientException extends AbstractException{

    public ClientException(String message) {
        super(message, null, BaseErrorCode.CLIENT_ERROR);
    }

    public ClientException(IErrorCode errorCode) {
        super(null,null,errorCode);
    }

    public ClientException(String message, Throwable throwable, IErrorCode errorCode) {
        super(message, throwable, errorCode);
    }

    @Override
    public String toString() {
        return "ClientException{" +
                "errorCode='" + errorCode + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
