package com.zohn.springboot01.workingfolder.inter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 *@Description 替换HttpServletRequest
 *@CreateDate 2020\6\29 0029 9:37
 *@Author z
 *@Version 1.0
 */
public class URLReplaceStreamFilter implements Filter {

    /**
     * 日志组件
     */
    private final Logger log = LoggerFactory.getLogger(URLReplaceStreamFilter.class);


    @Override
    public void init(javax.servlet.FilterConfig filterConfig) throws ServletException {
        log.info("StreamFilter  initialization...");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        ServletRequest requestWrapper = new URLRequestWrapper((HttpServletRequest) request);
        chain.doFilter(requestWrapper, response);
    }

    @Override
    public void destroy() {
        log.info("StreamFilter destroy...");
    }
}
