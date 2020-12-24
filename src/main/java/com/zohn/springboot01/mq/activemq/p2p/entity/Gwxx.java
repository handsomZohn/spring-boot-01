package com.zohn.springboot01.mq.activemq.p2p.entity;

import lombok.Data;

import java.io.Serializable;

/**
 *@Description ERROR[http-nio-8080-exec-6]com.zohn.springboot01.webcomponent.handler.ExceptionHandler.handleException:29 - url http://127.0.0.1:8080/api/v1/gwxxDX, message com.zohn.springboot01.mq.activemq.p2p.entity.Gwxx cannot be cast to java.io.Serializable
 *@CreateDate 2020\4\1 0001 11:43
 *@Author zohn
 *@Version 1.0
 */
@Data
public class Gwxx implements Serializable {

    // 岗位id
    private Integer gwid;
    // 岗位编号
    private String gwbh;
    // 岗位名称
    private String gwmc;
    // 月薪
    private String yx;
    // 福利待遇
    private String fldy;
    // 公司名称
    private String gsmc;
    // 工作地址
    private String gzdz;


}
