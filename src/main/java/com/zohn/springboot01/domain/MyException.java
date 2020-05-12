package com.zohn.springboot01.domain;

/**
 * @Description: 自定义异常类
 * @Author: zohn
 * @CreateDate: 2018/11/3 18:42
 * @UpdateUser: zohn
 * @UpdateDate: 2018/11/3 18:42
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class MyException extends RuntimeException {
    /**
     * 状态码
     */
    private String code;
    /**
     * 错误消息
     */
    private String msg;


    public MyException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
