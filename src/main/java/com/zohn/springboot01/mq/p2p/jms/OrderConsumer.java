package com.zohn.springboot01.mq.p2p.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 *@Description 消费者
 *@CreateDate 19/04/29 17:29
 *@Author Administrator
 *@Version 1.0
 */
@Component
public class OrderConsumer {

    @JmsListener(destination = "order.queue")
    public void receiveQueue(String text){
        // 业务逻辑
        System.out.println("OrderConsumer收到的报文为：" + text);
    }

    @JmsListener(destination = "common.queue")
    public void commonqueue(String text){
        // 业务逻辑
        System.out.println("OrderConsumer收到的报文为(common.queue)：" + text);
    }
}
