package com.mmall.common;

/**
 * 响应码 枚举
 * @author Timber
 * @date 2018/10/12
 */

public enum ResponseCode {

    /**
     * 1: SUCCESS
     * 2: ERROR
     * 10: NEED_LOGIN
     * 2: ILLEGAL_ARGUMENT
     */
    SUCCESS(0, "SUCCESS"),
    ERROR(1, "ERROR"),
    NEED_LOGIN(10, "NEED_LOGIN"),
    ILLEGAL_ARGUMENT(2, "ILLEGAL_ARGUMENT");

    private final int code;
    private final String desc;

    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc =desc;
    }

    public int getCode() {
        return code;
    }
    public String getDesc() {
        return desc;
    }
}
