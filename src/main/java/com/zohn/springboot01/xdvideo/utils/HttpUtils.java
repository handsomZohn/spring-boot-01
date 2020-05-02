package com.zohn.springboot01.xdvideo.utils;

import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;

/**
 *@Description 封装http请求 get post
 *@CreateDate 2020/2/5 16:43
 *@Author zohn
 *@Version 1.0
 */
public class HttpUtils {

    private static final Gson gson = new Gson();

    /**
     * @Description 封装get方法
     * @Author zohn
     * @Date 2020/2/5 16:45
     * @Param [url]
     * @Return java.util.Map<java.lang.String,java.lang.Object>
     */
    public static Map<String, Object> doGet(String url){

        Map<String, Object> map = new HashMap<>();

        CloseableHttpClient httpClient = HttpClients.createDefault();

        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(5000)// 连接超时
                .setConnectionRequestTimeout(5000)// 请求超时
                .setSocketTimeout(5000)//
                .setRedirectsEnabled(true)// 允许重定向
                .build();

        HttpGet httpGet = new HttpGet(url);
        httpGet.setConfig(requestConfig);

        try {
            CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
            if (httpResponse.getStatusLine().getStatusCode() == 200){
                HttpEntity entity = httpResponse.getEntity();
                String jsonResult = EntityUtils.toString(entity);
                map = gson.fromJson(jsonResult, map.getClass());
            }
        } catch (Exception  e) {
            e.printStackTrace();// 打印堆栈信息 高并发环境下不推荐打印 如果不差这点资源就可以打印。
            e.getMessage();
        } finally {
            try {
                httpClient.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return map;
    }

    /**
     * @Description 封装post
     * @Author zohn
     * @Date 2020/2/5 17:00
     * @Param []
     * @Return java.lang.String
     */
    public String doPost(String url, String data, int timeOut){

        CloseableHttpClient httpClient = HttpClients.createDefault();

        // 超时设置
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(5000)// 连接超时
                .setConnectionRequestTimeout(5000)// 请求超时
                .setSocketTimeout(5000)//
                .setRedirectsEnabled(true)// 允许重定向
                .build();

        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(requestConfig);
        httpPost.addHeader("Content-Type", "text/html;charset=UTF-8");

        // 使用字符串传参
        if (data != null && data instanceof String){
            StringEntity stringEntity = new StringEntity(data.toString(), "UTF-8");
            httpPost.setEntity(stringEntity);
        }

        // 发送请求
        try {
            CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity entity = httpResponse.getEntity();
            if (httpResponse.getStatusLine().getStatusCode() == 200){
                String result = EntityUtils.toString(entity);
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return "";
    }
}
