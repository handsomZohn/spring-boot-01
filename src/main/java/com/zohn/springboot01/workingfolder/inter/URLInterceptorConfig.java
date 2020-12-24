package com.zohn.springboot01.workingfolder.inter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class URLInterceptorConfig implements WebMvcConfigurer {
    @Bean
    public URLHttpOrHttpsInterceptor getHttpOrHttpsInterceptor(){
        return new URLHttpOrHttpsInterceptor();
    }

    /**
     * 注册拦截器
     *
     * @param registry registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getHttpOrHttpsInterceptor())
                .addPathPatterns("/**");
    }
}
