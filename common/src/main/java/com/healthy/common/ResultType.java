package com.healthy.common;

/**
 * @author Gugu
 * @create 2023-04-23 21:34
 * @purpose 返回信息类型
 */
public enum ResultType {
    /**
     * success
     */
    OK("20000", "success"),

    /**
     * error
     */
    ERROR("50000", "error"),

    /**
     * warning
     */
    WARNING("30000", "warning"),
    NOTHAVEAOCCUNT("30001","没有该账户"),
    PASSWARD("30002","密码错误"),
    ;
    private final String code;

    private final String msg;

    public String value() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    ResultType(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
