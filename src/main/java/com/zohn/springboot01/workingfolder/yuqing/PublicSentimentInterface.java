package com.zohn.springboot01.workingfolder.yuqing;


import com.zohn.springboot01.workingfolder.filecall.callcommon.CallConfig;
import com.zohn.springboot01.workingfolder.filecall.callcommon.MD5Utils;
import com.zohn.springboot01.workingfolder.filecall.calldetail.BSSResponseBody;
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

/**
 * 获取舆情项目数据
 */
public class PublicSentimentInterface {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final String SUCCESS_CODE = "0";

    RestTemplate restTemplate = new RestTemplate();


    @Test
    public void publicSentimentTest() throws URISyntaxException {
        String interfaceCallURL = YuqingConfig.INTERFACECALLURL;
        /**
         * http请求头部参数设定
         */
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Content-Type", "application/json;charset=UTF-8");
        requestHeaders.add("Accept", "application/json");
        requestHeaders.add("apikey", "bw1BMNhQV1MNK9b5");


        RequestEntity requestEntity = new RequestEntity<>(requestHeaders, HttpMethod.POST, new URI(interfaceCallURL+YuqingConfig.CALLDETAILURL));

        logger.info("舆情搜索接口url为：{}", new URI(interfaceCallURL+YuqingConfig.CALLDETAILURL));

        ResponseEntity<PublicSentimentBody> responseEntity = restTemplate.exchange(requestEntity, PublicSentimentBody.class);

        logger.info("风报 Data接口返回的数据是:{}", responseEntity);

        PublicSentimentBody body = responseEntity.getBody();

        if(body.getCode()  != CallConfig.getSuccessCode()){
            logger.warn("风报 Data接口返回异常信息:{}", body.getMsg());
            return;
        }

        // 通话记录详细信息 存库及后续操作...
        HitsVOList hitsVOList = body.getHitsVOList();
        System.out.println(hitsVOList);
    }


    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        System.out.println("======^_^======variable l value is : " + l + ", " + " current method and class name is : BSSInterface.main()");
    }
}
