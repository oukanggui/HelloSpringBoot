package com.okg.hello.constants.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 全局通用的状态枚举类
 * 实际开发中，通过枚举类型定义状态码和状态信息对应关系,不同的业务模块通过定义不同的枚举类来定义状态码和状态信息的对应关系
 */
@Getter
@AllArgsConstructor
public enum GlobalStatusEnum {
    SUCCESS(0, "success"),
    TOKEN_ERROR(10001, "token错误"),
    SYS_ERROR(500, "系统发生异常");

    private Integer code;
    private String msg;
}
