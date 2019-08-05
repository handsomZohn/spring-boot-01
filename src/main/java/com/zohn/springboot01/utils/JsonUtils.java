package com.zohn.springboot01.utils;


import java.io.IOException;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @Description: json工具类
 * @Author: zohn
 * @CreateDate: 2019/3/24 21:26
 * @Version: 1.0
 */
public class JsonUtils {

    private static ObjectMapper objectMapper = new ObjectMapper();


    /**
     * 对象转字符串
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> String obj2String(T obj) {
        if (obj == null) {
            return null;
        }
        try {
            return obj instanceof String ? (String) obj : objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 字符串转对象
     * @param str
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T string2Obj(String str, Class<T> clazz) {
        if (StringUtils.isEmpty(str) || clazz == null) {
            return null;
        }
        try {
            return clazz.equals(String.class) ? (T) str : objectMapper.readValue(str, clazz);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

