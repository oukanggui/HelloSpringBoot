package com.okg.hello.interceptor;

import com.okg.hello.constants.enums.GlobalStatusEnum;
import com.okg.hello.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Author:oukanggui
 * Date: 2022-03-06
 * Describe:用户接口拦截器，一般用于权限校验、（认证）登录态校验等，需要实现HandlerInterceptor接口,代表该类为拦截器类，需要配置注册了才能被Spring识别
 * 拦截器的一般用途如下：
 * 【日志拦截器】记录请求与响应。这样，我们可以知道每一次请求的参数，响应的结果，执行的时长等等信息
 * 【认证拦截器】我们可以解析前端传入的用户标识，例如说 access_token 访问令牌，获得当前用户的信息，记录到 ThreadLocal 中。这样，后续的逻辑，只需要通过 ThreadLocal 就可以获取到用户信息
 * 【授权拦截器】我们可以通过每个API接口需要的授权信息，进行判断，当前请求是否允许访问。例如说，用户是否登录，是否有该 API 操作的权限等等
 * 【限流拦截器】我们可以通过每个API接口的限流配置，进行判断，当前请求是否超过允许的请求频率，避免恶意的请求，打爆整个系统
 */
@Slf4j
public class UserInterceptor implements HandlerInterceptor {

    /**
     * 前置处理：实现handler（请求的方法）的前置处理逻辑。当返回true时，继续后续handler的执行；当返回false时，不进行后续handler的执行
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
            throw new ServiceException(GlobalStatusEnum.TOKEN_ERROR.getCode(), GlobalStatusEnum.TOKEN_ERROR.getMsg());
//            return false;
        }
        // 此处可以再继续校验token是否已过期
        return true;
    }

    /**
     * 后置处理：实现handler的后置处理逻辑，如在视图View在渲染之前，做一些处理。不过因为目前都前后端分离，所以这个后置拦截点，使用的就已经比较少了
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
     * 请求访问到Controller后，渲染视图之后，
     * 整个handler执行完成，并且拦截器链都执行完前置和后置的拦截逻辑，实现请求完成后的处理逻辑
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
