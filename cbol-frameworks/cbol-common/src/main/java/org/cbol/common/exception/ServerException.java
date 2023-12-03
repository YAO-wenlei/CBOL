package org.cbol.common.exception;

import org.cbol.common.errorcode.BaseErrorCode;
import org.cbol.common.errorcode.IErrorCode;

/**
 * @author yaowenlei
 * @date 2023年11月25日 10:13 下午
 */
public class ServerException extends AbstractException{

    public ServerException(String message) {
        super(message, null, BaseErrorCode.CLIENT_ERROR);
    }

    public ServerException(IErrorCode errorCode) {
        super(null,null,errorCode);
    }


    public ServerException(String message, Throwable throwable, IErrorCode errorCode) {
        super(message, throwable, errorCode);
    }

    @Override
    public String toString() {
        return "ServerException{" +
                "errorCode='" + errorCode + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
