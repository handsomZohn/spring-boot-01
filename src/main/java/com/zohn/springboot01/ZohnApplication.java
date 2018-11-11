package com.zohn.springboot01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

import javax.servlet.MultipartConfigElement;
import javax.servlet.annotation.MultipartConfig;

/**
 * 启动类
 *
 * @author zzohn
 */
@SpringBootApplication
@ServletComponentScan
public class ZohnApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZohnApplication.class, args);
    }

    @Bean
    public MultipartConfigElement multipartConfigElement () {
        MultipartConfigFactory multipartConfigFactory = new MultipartConfigFactory();
        multipartConfigFactory.setMaxFileSize("10240KB");
        multipartConfigFactory.setMaxRequestSize("102400KB");
        return multipartConfigFactory.createMultipartConfig();
    }
}
