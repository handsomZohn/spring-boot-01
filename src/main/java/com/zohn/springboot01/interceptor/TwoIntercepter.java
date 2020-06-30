package com.zohn.springboot01.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TwoIntercepter implements HandlerInterceptor {

    /**
     * 进入Controller方法之前
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("TwoIntercepter==preHandlerBeforeControllerMethod");
        String token = request.getParameter("access_token");
        /*if ("0X3FC".equals(token)) {
            response.getWriter().print("success");
        } else {
            response.getWriter().print("fail");
        }*/
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("TwoIntercepter==postHandlerAfterControllerMethod");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("TwoIntercepter==afterCompletionInAnyCase");
    }
}
