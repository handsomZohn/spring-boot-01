package com.zohn.springboot01.mybatisstarter.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 响应结果类
 * @Author: zohn
 * @CreateDate: 2019/3/17 10:25
 * @Version: 1.0
 */
@Data
public class JsonData implements Serializable {

    /**
     * 序列化id
     */
    private static final long serialVersionUID = -81990801300213095L;

    /**
     * 状态码0标识成功 1标识处理中 -1标识失败
     */
    private Integer code;

    /**
     * 数据
     */
    private Object data;


    /**
     * 提示消息
     */
    private String msg;


    public JsonData(Integer code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }


    /**
     * 成功,传入数据
     *
     * @return jsondata
     */
    public static JsonData buildSuccess() {
        return new JsonData(0, null, null);
    }


    /**
     * 成功传入数据
     * @param data
     * @return
     */
    public static JsonData buildSuccess(Object data) {
        return new JsonData(0, data, null);
    }

    /**
     * 失败 传入数据
     * @param msg
     * @return
     */
    public static JsonData buildError(String msg) {
        return new JsonData(-1,null, msg);
    }

    /**
     * 失败 传入数据
     * @param msg 提示信息
     * @param code 状态码
     * @return
     */
    public static JsonData buildError(String msg, Integer code){
        return new JsonData(code, null, msg);
    }


    /**
     * 成功
     * @param data 传入数据
     * @param msg 描述
     * @return
     */
    public static JsonData buildSuccess(Object data, String msg) {
        return new JsonData(null,data,msg);
    }


    /**
     * @param data
     * @param code
     * @return
     */
    public static JsonData buildSuccess(Object data, int code) {
        return new JsonData(code, data, null);
    }


    @Override
    public String toString() {
        return "JsonData{" +
                "code=" + code +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
}