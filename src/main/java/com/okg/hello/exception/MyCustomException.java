package com.okg.hello.exception;

/**
 * Author:oukanggui
 * Date: 2022-03-06
 * Describe: 自定义异常类，统一处理异常信息
 * 以便于在拦截器拦截到Token相关异常时，抛出该异常，由统一的异常处理器处理返回Json对象给前端
 * 便于解耦，可以在拦截器，控制层和业务层去使用，统一在异常拦截器中拦截返回统一的Json对象给前端
 */
public class MyCustomException extends RuntimeException {

    public MyCustomException(String message) {
        super(message);
    }
}
