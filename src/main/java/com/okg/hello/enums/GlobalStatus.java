package com.okg.hello.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 全局通用的状态枚举类
 * 实际开发中，通过枚举类型定义状态码和状态信息对应关系,不同的业务模块通过定义不同的枚举类来定义状态码和状态信息的对应关系
 */
@Getter
@AllArgsConstructor
public enum GlobalStatus {
    REQUEST_SUCCESS(0, "success"),
    TOKEN_ERROR(10001, "token错误");

    private Integer code;
    private String msg;
}
