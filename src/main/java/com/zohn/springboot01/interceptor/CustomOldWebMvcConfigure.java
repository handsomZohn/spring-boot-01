package com.zohn.springboot01.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Description: Spring-boot2.x之前的旧版本 继承WebMvcConfigurerAdapter
 * @Author: zohn
 * @CreateDate: 2019/1/5 10:06
 * @UpdateUser: zohn
 * @UpdateDate: 2019/1/5 10:06
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
// @Configuration
public class CustomOldWebMvcConfigure extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginIntercepter()).addPathPatterns("/api/");
        super.addInterceptors(registry);
    }
}
