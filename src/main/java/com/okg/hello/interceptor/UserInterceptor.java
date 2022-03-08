package com.okg.hello.interceptor;

import com.okg.hello.exception.MyCustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Author:oukanggui
 * Date: 2022-03-06
 * Describe:用户接口拦截器，一般用于权限校验、登录态校验等
 * 需要实现HandlerInterceptor接口,代表该类为拦截器类
 * 需要配置注册了才能被Spring识别
 */
@Slf4j
public class UserInterceptor implements HandlerInterceptor {

    /**
     * 拦截请求，访问Controller之前，一般拦截处理，都是重写处理该方法
     *
     * @param request
     * @param response
     * @param handler
     * @return false-请求被拦截，true-请求被放行（没有被拦截，可以继续访问后续的Controller）
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 统一获取userToken
        String userToken = request.getHeader("token");
        if (StringUtils.isEmpty(userToken)) {
            log.info("用户未登录或登录已失效，请先登录再操作");
            throw new MyCustomException("用户未登录或登录已失效，请先登录再操作");
//            return false;
        }
        // 此处可以再继续校验token是否已过期
        return true;
    }

    /**
     * 请求访问到Controller后，渲染视图之前
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 请求访问到Controller后，渲染视图之后
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
