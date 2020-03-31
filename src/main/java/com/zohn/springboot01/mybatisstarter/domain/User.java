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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
