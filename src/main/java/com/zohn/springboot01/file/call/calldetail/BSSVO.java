package com.zohn.springboot01.file.call.calldetail;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BSSVO {

    /**
     * 通话 ID
     */
    private String callid;

    /**
     * 音频总文件
     */
    @JsonProperty("file_all")
    private String fileAll;
}
