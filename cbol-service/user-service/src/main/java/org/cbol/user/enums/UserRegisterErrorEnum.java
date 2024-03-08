package org.cbol.user.enums;

import org.cbol.common.errorcode.IErrorCode;

/**
 * @author yaowenlei
 */
public enum UserRegisterErrorEnum implements IErrorCode {

    USER_REGISTER_FAIL("A000100", "用户注册失败!"),
    USER_NAME_NOTNULL("A000101","用户名不能为空!"),
    PASSWORD_NOTNULL("A000102","密码不能为空!"),
    PHONE_NOTNULL("A000103","手机号不能为空"),
    ;

    /**
     * 错误码
     */
    private final String code;

    /**
     * 错误信息
     */
    private final String message;

    UserRegisterErrorEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }
}
