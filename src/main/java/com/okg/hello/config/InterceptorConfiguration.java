package com.okg.hello.config;

import com.okg.hello.interceptor.UserInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Author:oukanggui
 * Date: 2022-03-06
 * Describe:拦截器配置类
 * 需要实现WebMvcConfigurer类，重写相关方法进行拦截器注册及对应的规则配置
 * 通过@Configuration注释表明这个类是一个Spring配置类
 * 方法通过@Bean注视返回配置类的Bean对象，其生命周期由Spring管理，默认为全局单例
 */
@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {

    @Bean
    public UserInterceptor userInterceptor() {
        return new UserInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册拦截器，并匹配该拦截器使用的路径，即哪些接口开启这个拦截器：此处即是在删除用户时进行拦截校验
        registry.addInterceptor(userInterceptor())
//                .addPathPatterns("/**") // 拦截所有请求
                .addPathPatterns("/delete");
    }
}
