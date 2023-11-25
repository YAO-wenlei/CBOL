package com.cbol.common.result;

import com.cbol.common.errorcode.BaseErrorCode;
import com.cbol.common.exception.AbstractException;

import java.util.Optional;

/**
 * @author yaowenlei
 * @date 2023年11月25日 8:13 下午
 */
public class Results {

    /**
     * 构造成功响应
     */
    public static Result<Void> success() {
        return new Result<Void>()
                .setCode(Result.SUCCESS_CODE);
    }

    /**
     * 构造带参数的成功响应
     */
    public static <T> Result<T> success(T data) {
        return new Result<T>()
                .setCode(Result.SUCCESS_CODE)
                .setData(data);
    }

    /**
     * 构造失败响应
     */
    public static Result<Void> failure() {
        return new Result<Void>()
                .setCode(BaseErrorCode.SERVER_ERROR.code())
                .setMessage(BaseErrorCode.SERVER_ERROR.message());
    }

    public static Result<Void> failure(String errorCode, String errorMessage) {
        return new Result<Void>()
                .setCode(errorCode)
                .setMessage(errorMessage);
    }

    public static Result<Void> failure(AbstractException exception) {
        String errorCode = Optional.ofNullable(exception.getErrorCode())
                .orElse(BaseErrorCode.SERVER_ERROR.code());
        String errorMessage = Optional.ofNullable(exception.getErrorMessage())
                .orElse(BaseErrorCode.SERVER_ERROR.message());
        return new Result<Void>()
                .setCode(errorCode)
                .setMessage(errorMessage);
    }
}
