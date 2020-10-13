package com.zohn.springboot01.file.call.calldetail;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *@Description 回调实体
 *@CreateDate 2020\10\13 0013 13:39
 *@Author z
 *@Version 1.0
 */
public class BSSResponseBody {
    /**
     * 结果码
     */
    private String code;
    /**
     * 提 示 信
     * 息
     */
    private String msg;
    /**
     * 结果
     */
    private boolean success;

    /**
     * 返回参数Object
     */
    @JsonProperty("body")
    private BSSVO bssvo;

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

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public BSSVO getBssvo() {
        return bssvo;
    }

    public void setBssvo(BSSVO bssvo) {
        this.bssvo = bssvo;
    }
}
