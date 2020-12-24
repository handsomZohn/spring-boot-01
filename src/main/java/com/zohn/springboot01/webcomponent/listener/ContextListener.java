package com.zohn.springboot01.webcomponent.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // 资源加载
        System.out.println("================contextInitialized===============");

        // 预热数据-------
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // 最先加载 最后销毁
        System.out.println("=============contextDestroyed==================");
    }
}
