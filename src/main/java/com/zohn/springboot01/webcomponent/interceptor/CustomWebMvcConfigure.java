package com.zohn.springboot01.webcomponent.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *@Description 拦截器配置 2.x及以后的拦截器配置
 *@CreateDate 2020\7\2 0002 9:15
 *@Author z
 *@Version 1.0
 */
@Configuration
public class CustomWebMvcConfigure implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 拦截路径
        // registry.addInterceptor(new LoginIntercepter()).addPathPatterns("/api2/*/**");
        // 拦截路径
        // registry.addInterceptor(new TwoIntercepter()).addPathPatterns("/api2/*/**");
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
