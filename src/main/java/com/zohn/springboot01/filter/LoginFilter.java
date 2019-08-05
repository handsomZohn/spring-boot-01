package com.zohn.springboot01.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// Servlet3.0引入的新注解
@WebFilter(urlPatterns = "/filter/*", filterName = "loginFilter")
public class LoginFilter implements Filter {

    /**
     * 容器加载时候调用
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init LoginFilter==================");
    }

    /**
     * 请求被拦截的时候调用
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("doFilter LoginFilter=====================");
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        String username = httpServletRequest.getParameter("username");
        if ("zohn".equals(username)) {
            chain.doFilter(request,response);
        } else {
            httpServletResponse.sendRedirect("/index.ftl");
            return;
        }
    }

    /**
     * 容器被销毁的时候调用
     */
    @Override
    public void destroy() {
        System.out.println("destroy loginFilter============");
    }
}
