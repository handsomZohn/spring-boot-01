package com.zohn.springboot01.file.call.calldetail;


import com.zohn.springboot01.file.call.callcommon.CallConfig;
import com.zohn.springboot01.file.call.callcommon.MD5Utils;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/**
 *@Description 调用硅信智能 BSS 系统第三方 AP
 *@CreateDate 2020\10\13 0013 10:24
 *@Author z
 *@Version 1.0
 */
public class BSSInterface {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final String SUCCESS_CODE = "0";

    RestTemplate restTemplate = new RestTemplate();

    /**
     * @Description 通话详情
     * @Author z
     * @Date 2020\10\13 0013 14:40
     * @Param []
     * @Return void
     */
    @Test
    public void icDetailTest() throws URISyntaxException {
        String interfaceCallURL = CallConfig.getINTERFACECALLURL();
        long timestamp = System.currentTimeMillis();

        // 验签前参数拼接
        String paramsforDetail = String.format(CallConfig.getPARAMS(), CallConfig.getACCESSKEY(), CallConfig.getNONCE(),timestamp, CallConfig.getSECRETKEY());

        /**
         * http请求头部参数设定
         */
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Content-Type", "application/json;charset=UTF-8");
        requestHeaders.add("Accept", "application/json");
        requestHeaders.add("token", MD5Utils.md5(paramsforDetail));
        requestHeaders.add("timestamp", String.valueOf(timestamp));

        /**
         * http请求body参数设定
         */
        Map bodyMap = new HashMap<>();

        bodyMap.put("accessKey",CallConfig.getACCESSKEY());
        bodyMap.put("timestamp",String.valueOf(timestamp));
        bodyMap.put("nonce",CallConfig.getNONCE());
        bodyMap.put("sign",MD5Utils.md5(paramsforDetail));
        bodyMap.put("signType",CallConfig.getSIGNTYPE());
        bodyMap.put("callId","19609158521448192");


        RequestEntity requestEntity = new RequestEntity<>(bodyMap, requestHeaders, HttpMethod.POST, new URI(interfaceCallURL+CallConfig.getCALLDETAILURL()));

        logger.info("BSS供应商接口url为：{}", new URI(interfaceCallURL+CallConfig.getCALLDETAILURL()));

        ResponseEntity<BSSResponseBody> responseEntity = restTemplate.exchange(requestEntity, BSSResponseBody.class);

        logger.info("BSS供应商接口返回的数据是:{}", responseEntity);

        BSSResponseBody body = responseEntity.getBody();

        if(body.getCode()  != CallConfig.getSuccessCode()){
            logger.warn("BSS供应商接口返回异常信息:{}", body.getMsg());
            return;
        }

        // 通话记录详细信息 存库及后续操作...
        BSSVO bssvo = body.getBssvo();
    }


    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        System.out.println("======^_^======variable l value is : " + l + ", " + " current method and class name is : BSSInterface.main()");
    }
}
