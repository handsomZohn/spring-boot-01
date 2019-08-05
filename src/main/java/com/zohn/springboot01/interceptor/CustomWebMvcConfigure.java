package com.zohn.springboot01.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CustomWebMvcConfigure implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginIntercepter()).addPathPatterns("/api2/*/**");// 拦截路径
        registry.addInterceptor(new TwoIntercepter()).addPathPatterns("/api2/*/**");// 拦截路径
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
