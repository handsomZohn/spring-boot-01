package com.zohn.springboot01.interceptor.work;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
 *@Description 过滤器配置
 *@CreateDate 2020\6\29 0029 15:52
 *@Author z
 *@Version 1.0
 */
@Configuration
public class URLFilterConfig {
    /**
     * 注册过滤器
     *
     * @return FilterRegistrationBean
     */
    @Bean
    public FilterRegistrationBean someFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(replaceStreamFilter());
        registration.addUrlPatterns("/*");
        registration.setName("streamFilter");
        return registration;
    }

    /**
     * 实例化StreamFilter
     *
     * @return Filter
     */
    @Bean(name = "replaceStreamFilter")
    public Filter replaceStreamFilter() {
        return new URLReplaceStreamFilter();
    }
}
