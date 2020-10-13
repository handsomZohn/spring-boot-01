package com.zohn.springboot01.file.call.calllist;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BSSListResponseBody {
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
    private BSSListVO bssvo;

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

    public BSSListVO getBssvo() {
        return bssvo;
    }

    public void setBssvo(BSSListVO bssvo) {
        this.bssvo = bssvo;
    }
}
