package com.zohn.springboot01.activemq.p2p.service.impl;

import com.zohn.springboot01.activemq.p2p.service.IProcedureService;
import org.apache.activemq.command.ActiveMQObjectMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.Topic;

/**
 *@Description 消息生产者实现类
 *@CreateDate 19/04/29 17:02
 *@Author Administrator
 *@Version 1.0
 */
@Service
public class ProcedureServiceImpl implements IProcedureService {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;// 用来发送消息到broker的对象

    @Autowired
    private Queue queue;


    /**
     * @Description 发送消息 提供消息的名字 以及发送消息的目的地 发送到哪一个队列
     * @Author zohn
     * @Date 19/04/29 17:00
     * @Param [msgName, destination]
     * @Return void
     */
    @Override
    public void sendMessage(String msgName, Destination destination) {
        jmsMessagingTemplate.convertAndSend(destination, msgName);
    }

    /**
     * @Description 发送消息 提供消息的名字 发送到默认队列
     * @Author zohn
     * @Date 19/04/29 17:00
     * @Param [msgName]
     * @Return void
     */
    @Override
    public void sendMessage(String msgName) {
        jmsMessagingTemplate.convertAndSend(this.queue, msgName);
    }

    /**
     * @Description 发送实体
     * @Author zohn
     * @Date 2020\4\1 0001 11:54
     * @Param [msg, destination]
     * @Return void
     */
    @Override
    public void send(ActiveMQObjectMessage msg, Destination destination) {
        jmsMessagingTemplate.convertAndSend(destination, msg);
    }




    // ============================================================发布订阅相关代码=====================

    @Autowired
    private Topic topic;

    /**
     * 消息发布者
     *
     * @param msg
     */
    @Override
    public void publish(String msg) {
        this.jmsMessagingTemplate.convertAndSend(this.topic, msg);
    }
}