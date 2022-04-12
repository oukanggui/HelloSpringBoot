package com.okg.hello.exception;

import com.okg.hello.constants.enums.GlobalStatusEnum;
import com.okg.hello.dao.entity.CommonResponse;
import org.apache.tomcat.util.http.fileupload.impl.FileSizeLimitExceededException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Author:oukanggui
 * Date: 2022-03-06
 * Describe:统一异常处理器（基于Spring的AOP原理）
 * 可以针对异常自定义去捕获和处理，对某种异常，统一返回指定的类型（如Json类型）到前端
 * 需要使用@ControllerAdvice注释
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理自定义业务异常异常
     *
     * @param e
     * @return
     * @ExceptionHandler注解 指定需要拦截处理的异常
     * @ResponseBody注解 标记直接使用返回结果作为API的响应
     */
    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public CommonResponse handleServiceException(ServiceException e) {
        return CommonResponse.error(e.getCode(), e.getMessage());
    }

    /**
     * 处理其他异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public CommonResponse handleException(Exception e) {
        return CommonResponse.error(GlobalStatusEnum.SYS_ERROR.getCode(), GlobalStatusEnum.SYS_ERROR.getMsg());
    }

}
