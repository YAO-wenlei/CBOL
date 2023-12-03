package org.cbol.common.exception;

import org.cbol.common.errorcode.BaseErrorCode;
import org.cbol.common.errorcode.IErrorCode;

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
