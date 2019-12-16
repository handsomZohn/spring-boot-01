package com.zohn.springboot01.mybatisstarter.domain;

import lombok.Data;

import java.util.Date;

/**
* @Description: spring-boot整合mybatis--实体类
* @Author: zohn
* @CreateDate: 2019/3/17 10:24
* @Version: 1.0
*/
@Data
public class User {
    private int id;

    private String name;

    private String phone;

    private int age;

    private Date createTime;
}
