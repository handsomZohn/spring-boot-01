package com.zohn.springboot01.handler;

import com.zohn.springboot01.domain.MyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;
import sun.awt.ModalityListener;

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

    /**
     * 处理自定义异常
     * @return
     */
    @org.springframework.web.bind.annotation.ExceptionHandler(value = MyException.class)
    public Object myExceptionTest(MyException e, HttpServletRequest request){

        // 返回ModelAndView 去同意的错误页面
        /*ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("PageNotFound.html");
        modelAndView.addObject("msg", e.getMessage());
        return modelAndView;*/

        // 返回json数据 由前端根据状态码判断加载什么页面
        log.error(" url {}, message {}", request.getRequestURL(), e.getMessage());
        return new HashMap(){{
            put("code", e.getCode());
            put("message", e.getMsg());
            put("url", request.getRequestURL());
        }};
    }
}
