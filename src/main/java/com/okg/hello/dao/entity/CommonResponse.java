package com.okg.hello.dao.entity;

import com.okg.hello.constants.enums.GlobalStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 统一响应类
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse {
    // 返回码,业务响应状态，成功为0
    private Integer code;
    // 返回描述，一般需要定义枚举类，定义code和msg的对应关系
    private String msg;
    // 返回数据，根据不同的请求返回不同的数据类型
    private Object data;

    // 响应成功，返回数据为空，接口不关注返回数据
    public static CommonResponse success() {
        return success(null);
    }

    public static CommonResponse success(Object data) {
        return success(GlobalStatusEnum.SUCCESS.getMsg(), data);
    }

    public static CommonResponse success(String msg, Object data) {
        return response(GlobalStatusEnum.SUCCESS.getCode(), msg, data);
    }

    public static CommonResponse error(int code, String msg) {
        return response(code, msg, null);
    }

    public static CommonResponse response(Integer code, String msg) {
        return response(code, msg, null);
    }

    public static CommonResponse response(Integer code, String msg, Object data) {
        return new CommonResponse(code, msg, data);
    }
}
