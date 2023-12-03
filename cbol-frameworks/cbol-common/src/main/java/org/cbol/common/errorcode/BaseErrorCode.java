package org.cbol.common.errorcode;

/**
 * @author yaowenlei
 * @date 2023年11月25日 8:15 下午
 */
public enum BaseErrorCode implements IErrorCode{
    CLIENT_ERROR("A000001","客户端错误!"),

    SERVER_ERROR("B000001","服务端错误!"),

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
