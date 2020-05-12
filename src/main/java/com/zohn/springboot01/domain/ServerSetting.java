package com.zohn.springboot01.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

// 读取配置文件的第二种方式 放在单独定义的类里面
@Component
@PropertySource({"classpath:resource.properties"})
// @ConfigurationProperties
@ConfigurationProperties(prefix = "test") // 可以配置一个前缀 用前缀就不用value$
public class ServerSetting {

    // @Value("${test.appName}")
    // private String appName;// 应用的名字
    // @Value("appName")
    /**
     * 应用的名字
     */
    private String appName;

    // @Value("${test.domainAddress}")
    // private String domainAddress;// 域名地址
    // @Value("domainAddress")
    /**
     * 域名地址
     */
    private String domainAddress;

    /**
     * 上传文件所存放的位置
     */
    private String filePath;


    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

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
