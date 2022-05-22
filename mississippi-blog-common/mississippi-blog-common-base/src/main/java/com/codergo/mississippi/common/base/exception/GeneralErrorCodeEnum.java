package com.codergo.mississippi.common.base.exception;


import com.codergo.mississippi.common.base.dto.ResultCode;

import java.util.stream.Stream;

/**
 * 通用业务异常码
 * @author stef
 */
public enum GeneralErrorCodeEnum implements ResultCode {

    /**
     * 通用业务异常码
     * 从1_0000开始
     */
    UNKNOWN_CODE(10000,"呀，出错了..."),
    NPE_CODE(10001,"呀，出错了..."),
    NOT_FOUND_CODE(10002,"不存在"),
    INVALID_PARAMETERS(10003,"参数异常"),

    ;

    private final Integer code;
    private final String message;

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    GeneralErrorCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static GeneralErrorCodeEnum getEnum(int code) {
        return Stream.of(GeneralErrorCodeEnum.values())
                .filter(c -> c.code == code)
                .findAny()
                .orElse(null);
    }
}
