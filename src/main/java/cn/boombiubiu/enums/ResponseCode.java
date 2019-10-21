package cn.boombiubiu.enums;

public enum ResponseCode {

    /**
     * 请求成功
     */
    OK (200, "请求成功"),

    /**
     * token验证不通过
     */
    TOKEN_INVALID (20001, "token验证不通过"),

    /**
     * 缺少token
     */
    TOKEN_NOT_FOUND (20002, "缺少token"),

    /**
     * token失效
     */
    TOKEN_EXPIRED (20003, "token失效"),

    /**
     * 缺少请求参数
     */
    PARAMETER_NOTFOUND (40001, "缺少请求参数"),

    /**
     * 参数验证不通过
     */
    PARAMETER_INVALID (40002, "参数验证不通过"),

    /**
     * 媒体类型不支持
     */
    MEDIATYPE_NOTSUPPORTED (40003, "媒体类型不支持"),

    /**
     * 请求路径不存在
     */
    NOT_FOUND (40004, "请求路径不存在"),

    /**
     * 请求方法不支持
     */
    METHOD_NOT_ALLOWED (40005, "请求方法不支持");


    private final int code;
    private final String message;

    ResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
