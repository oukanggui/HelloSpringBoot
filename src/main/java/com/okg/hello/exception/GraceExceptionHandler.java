package com.okg.hello.exception;

import com.okg.hello.dao.entity.CommonResponse;
import org.apache.tomcat.util.http.fileupload.impl.FileSizeLimitExceededException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Author:oukanggui
 * Date: 2022-03-06
 * Describe:统一异常处理器（基于Spring的AOP原理）
 * 可以针对异常自定义去捕获和处理，返回指定的类型（如Json类型）到前端
 */
@ControllerAdvice
public class GraceExceptionHandler {

    /**
     * 统一拦截文件大小超出设置值的异常,当该异常发生时，返回统一的Json数据给前端处理
     * 通过@ExceptionHandler注解标明该方法需要拦截的异常
     * 通过@ResponseBody注解标明返回的是Json格式数据
     *
     * @return
     */
    @ExceptionHandler(FileSizeLimitExceededException.class)
    @ResponseBody
    public CommonResponse returnMaxFileSizeLimit() {
        return CommonResponse.error(500, "文件大小不能超过500KB");
    }
}
