package com.cbol.common.exception;

import com.cbol.common.errorcode.BaseErrorCode;
import com.cbol.common.errorcode.IErrorCode;

/**
 * @author yaowenlei
 * @date 2023年11月25日 10:15 下午
 */
public class RemoteException extends AbstractException{

    public RemoteException(String message) {
        super(message, null, BaseErrorCode.CLIENT_ERROR);
    }

    public RemoteException(IErrorCode errorCode) {
        super(null,null,errorCode);
    }

    public RemoteException(String message, Throwable throwable, IErrorCode errorCode) {
        super(message, throwable, errorCode);
    }

    @Override
    public String toString() {
        return "RemoteException{" +
                "errorCode='" + errorCode + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
