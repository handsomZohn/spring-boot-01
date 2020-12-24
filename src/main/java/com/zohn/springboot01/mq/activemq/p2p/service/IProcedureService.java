package com.zohn.springboot01.mq.activemq.p2p.service;

import org.apache.activemq.command.ActiveMQObjectMessage;

import javax.jms.Destination;
/**
 *@Description 消息生产者
 *@CreateDate 19/04/29 17:00
 *@Author Administrator
 *@Version 1.0
 */
public interface IProcedureService {


    /**
     * @DeDescription 发送消息 提供消息的名字 以及发送消息的目的地 发送到哪一个队列
     * @param msgName
     * @param destination
     */
    void sendMessage(final String msgName, Destination destination);
    /**
     * @Description 发送消息 提供消息的名字
     * @Author zohn
     * @Date 19/04/29 17:00
     * @Param [msgName]
     * @Return void
     */
    void sendMessage(final String msgName);

    /**
     * @Description 发布者
     * @Author zohn
     * @Date 2019/5/28 20:40
     * @Param [msg]
     * @Return void
     */
    void publish(String msg);

    /**
     * @Description
     * @Author zohn
     * @Date 2020\4\1 0001 11:31
     * @Param [msg]
     * @Return void
     */
    void send(ActiveMQObjectMessage msg, Destination destination);
}
