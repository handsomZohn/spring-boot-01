package com.zohn.springboot01.domain;

import lombok.Data;

import java.io.Serializable;


@Data
public class JsonDate implements Serializable{
    /**
     * 状态码0 成功 -1 失败
     */
    private int code;
    /**
     * 结果
     */
    private Object data;
    /**
     * 错误消息
     */
    private String message;

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
