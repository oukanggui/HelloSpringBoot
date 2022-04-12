package com.okg.hello.exception;

import lombok.Getter;

/**
 * Author:oukanggui
 * Date: 2022-03-06
 * Describe: 自定义业务异常类，统一处理异常信息
 * 以便于在拦截器拦截到Token相关异常时，抛出该异常，由统一的异常处理器处理返回Json对象给前端
 * 便于解耦，可以在拦截器，控制层和业务层去使用，统一在异常拦截器中拦截返回统一的Json对象给前端
 */
@Getter
public class ServiceException extends RuntimeException {

    private Integer code;

    public ServiceException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
