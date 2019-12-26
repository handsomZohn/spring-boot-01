package com.zohn.springboot01.activemq.p2p.controller;

import com.zohn.springboot01.domain.JsonData;
import com.zohn.springboot01.activemq.p2p.service.IProcedureService;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Destination;

/**
 *@Description 模拟微信支付回调
 *@CreateDate 19/04/29 17:13
 *@Author Administrator
 *@Version 1.0
 */
@RestController
@RequestMapping("/api/v1")
public class OrderController {

    @Autowired
    private IProcedureService iProcedureService;


    /**
     * @Description 微信支付回调接口
     * @Author zohn
     * @Date 19/04/29 17:17
     * @Param [msg 支付信息]
     * @Return java.lang.Object
     */
    @GetMapping("/order")
    public Object order(String msg){
        // 生成消息队列
        Destination destination = new ActiveMQQueue("order.queue");
        iProcedureService.sendMessage(msg, destination);
        return JsonData.buildSuccess();
    }

    /**
     * @Description 默认发送
     * @Author zohn
     * @Date 19/04/29 17:44
     * @Param [msg]
     * @Return java.lang.Object
     */
    @GetMapping("/common")
    public Object common(String msg){
        // 这个msg是要发送的消息 不能为空
        // Resolved exception caused by Handler execution: java.lang.IllegalArgumentException: Payload must not be null
        iProcedureService.sendMessage(msg);
        return JsonData.buildSuccess();
    }


    // =================================================发布订阅模式===============================

    /**
     * @Description 发布消息-生产者
     * @Author zohn
     * @Date 2019/5/28 20:46
     * @Param [msg]
     * @Return java.lang.Object
     */
    @GetMapping("/topic")
    public Object topic(String msg){
        iProcedureService.publish(msg);
        return JsonData.buildSuccess();
    }

}
