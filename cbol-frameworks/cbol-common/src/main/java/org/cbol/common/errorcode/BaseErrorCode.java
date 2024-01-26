package org.cbol.common.errorcode;

/**
 * @author yaowenlei
 * @date 2023年11月25日 8:15 下午
 */
public enum BaseErrorCode implements IErrorCode{
    CLIENT_ERROR("A000001","客户端错误!"),

    USER_REGISTER_FAIL("A000100", "用户注册失败!"),
    USER_NAME_NOTNULL("A000101","用户名不能为空!"),
    PASSWORD_NOTNULL("A000102","密码不能为空!"),
    PHONE_NOTNULL("A000103","手机号不能为空"),
    CHECK_CODE_NOTNULL("A000104","校验码不能为空!"),


    SERVER_ERROR("B000001","服务端错误!"),

    SERVER_BUSY_ERROR("B000100","服务器忙！请稍后再试"),

    REMOTE_ERROR("C000001","调用第三方服务出错!")
    ;

    /**
     * 错误码
     */
    private final String code;

    /**
     * 错误信息
     */
    private final String message;

    BaseErrorCode(String code, String message) {
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
