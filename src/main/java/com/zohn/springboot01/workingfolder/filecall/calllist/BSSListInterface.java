package com.zohn.springboot01.workingfolder.filecall.calllist;

import com.zohn.springboot01.workingfolder.filecall.callcommon.CallConfig;
import com.zohn.springboot01.workingfolder.filecall.callcommon.MD5Utils;
import com.zohn.springboot01.workingfolder.filecall.calldetail.BSSVO;
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
import java.util.List;
import java.util.Map;

public class BSSListInterface {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final String SUCCESS_CODE = "0";

    RestTemplate restTemplate = new RestTemplate();


    @Test
    public void icListTest() throws URISyntaxException {
        String accessKey = CallConfig.getACCESSKEY();
        String secretKey = CallConfig.getSECRETKEY();
        String interfaceCallURL = CallConfig.getINTERFACECALLURL();
        String signType = CallConfig.getSIGNTYPE();
        // 随机6位
        String nonce = CallConfig.getNONCE();
        long timestamp = System.currentTimeMillis();
        // 验签前参数拼接
        String paramsforList = "accessKey="+accessKey+"&nonce="+nonce+"&timestamp="+timestamp+"&secretKey="+secretKey;
        // 执行加密
        String encryptionParams = MD5Utils.md5(paramsforList);

        /**
         * http请求头部参数设定
         */
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Content-Type", "application/json;charset=UTF-8");
        requestHeaders.add("Accept", "application/json");
        requestHeaders.add("token", encryptionParams);
        requestHeaders.add("timestamp", String.valueOf(timestamp));

        /**
         * http请求body参数设定
         */
        Map bodyMap = new HashMap<>();

        bodyMap.put("accessKey",accessKey);
        bodyMap.put("timestamp",String.valueOf(timestamp));
        bodyMap.put("nonce",nonce);
        bodyMap.put("sign",encryptionParams);
        bodyMap.put("signType",signType);
        bodyMap.put("planId","2566");
        bodyMap.put("pageNo","1");
        bodyMap.put("pageSize","10");


        RequestEntity requestEntity = new RequestEntity<>(bodyMap, requestHeaders, HttpMethod.POST, new URI(interfaceCallURL+CallConfig.getCALLLISTLURL()));

        logger.info("BSS供应商接口url为：{}", new URI(interfaceCallURL+ CallConfig.getCALLLISTLURL()));

        ResponseEntity<BSSListResponseBody> responseEntity = restTemplate.exchange(requestEntity, BSSListResponseBody.class);

        logger.info("BSS供应商接口返回的数据是:{}", responseEntity);

        BSSListResponseBody body = responseEntity.getBody();

        if(body.getCode()  != SUCCESS_CODE){
            logger.warn("BSS供应商接口返回异常信息:{}", body.getMsg());
            return;
        }

        // 获取通话记录列表 以及后续操作...
        List<BSSVO> bssvos = body.getBssvo().getBssvos();
    }
}
