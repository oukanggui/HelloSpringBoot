package com.okg.hello.dao.entity;

/**
 * 统一响应类
 */
public class CommonResponse {
    // 返回码
    private Integer code;
    // 返回描述
    private String msg;
    // 返回数据，根据不同的请求返回不同的数据类型
    private Object data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static CommonResponse success(Object data) {
        return success("success", data);
    }

    public static CommonResponse success(String msg, Object data) {
        return response(200, msg, data);
    }

    public static CommonResponse error(int code, String msg) {
        return response(code, msg, null);
    }

    public static CommonResponse response(Integer code, String msg) {
        return response(code, msg, null);
    }

    public static CommonResponse response(Integer code, String msg, Object data) {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setCode(code);
        commonResponse.setMsg(msg);
        commonResponse.setData(data);
        return commonResponse;
    }
}
