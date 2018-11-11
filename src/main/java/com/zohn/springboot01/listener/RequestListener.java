package com.zohn.springboot01.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * @Description: 自定义原生Listener监听器
 * @Author: zohn
 * @CreateDate: 2018/11/11 21:55
 * @UpdateUser: zohn
 * @UpdateDate: 2018/11/11 21:55
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@WebListener
public class RequestListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        // 资源统计
        System.out.println("==============requestDestroyed==============");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("==============requestInitialized==============");
    }
}
