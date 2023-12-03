package org.cbol.common.exception;

import org.cbol.common.errorcode.IErrorCode;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

/**
 * @author yaowenlei
 * @date 2023年11月25日 3:02 下午
 */
@Getter
public abstract class AbstractException extends RuntimeException {

    public final String errorCode;

    public final String errorMessage;


    public AbstractException(String message, Throwable throwable, IErrorCode errorCode) {
        super(message,throwable);
        this.errorCode = errorCode.code();
        this.errorMessage = Optional.ofNullable(StringUtils.isNotEmpty(message) ? message : null).orElse(errorCode.message());
    }
}
