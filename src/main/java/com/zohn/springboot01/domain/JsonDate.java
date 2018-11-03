package com.zohn.springboot01.domain;

import lombok.Data;

import java.io.Serializable;


@Data
public class JsonDate implements Serializable{
    private int code;// 状态码0 成功 -1 失败
    private Object data;// 结果
    private String message;// 错误消息


    // 使用 import lombok.Setter;
    // 没有setget返回json会报错
    // 会报错的原因是因为没有使用@Data
   /* public int getCode() {
        return code;
    }


    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }*/

    public JsonDate(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    public JsonDate(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
