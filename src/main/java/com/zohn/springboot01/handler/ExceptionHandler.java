package com.zohn.springboot01.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

//@ControllerAdvice
@RestControllerAdvice
public class ExceptionHandler {

    //日志
    private static final Logger log = LoggerFactory.getLogger(ExceptionHandler.class);
    /**
     * 捕获全局异常 处理不可知异常
     * @param e
     * @param request
     * @return
     */
    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    public Object handleException(Exception e, HttpServletRequest request){
        log.error(" url {}, message {}", request.getRequestURL(), e.getMessage());
        return new HashMap(){{
            put("code", 100);
            put("message", e.getMessage());
            put("url", request.getRequestURL());
        }};
    }
}
