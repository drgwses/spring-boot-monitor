package com.sh.monitor.common.constant;

import lombok.Getter;
import lombok.ToString;

/**
 * @author Cindy
 * @since 2020/02/25
 */
@Getter
@ToString
public enum ResultCodeEnum {

    SUCCESS(true, 20000,"成功"),
    UNKNOWN_REASON(false, 20001, "未知错误");


    private Boolean success;

    private Integer code;

    private String message;

    ResultCodeEnum(Boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }
}
