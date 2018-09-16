package com.zohn.springboot01.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

// 读取配置文件的第二种方式 放在单独定义的类里面
@Component
@PropertySource({"classpath:resource.properties"})
// @ConfigurationProperties
@ConfigurationProperties(prefix = "test") // 可以配置一个前缀
public class ServerSetting {

    // @Value("${test.appName}")
    // private String appName;// 应用的名字
    // @Value("appName")
    private String appName;// 应用的名字

    // @Value("${test.domainAddress}")
    // private String domainAddress;// 域名地址
    // @Value("domainAddress")
    private String domainAddress;// 域名地址


    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getDomainAddress() {
        return domainAddress;
    }

    public void setDomainAddress(String domainAddress) {
        this.domainAddress = domainAddress;
    }
}
