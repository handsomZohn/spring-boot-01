package com.zohn.springboot01.activemq.p2p.controller;

import com.alibaba.fastjson.JSON;
import com.zohn.springboot01.activemq.p2p.entity.Gwxx;
import com.zohn.springboot01.activemq.p2p.service.impl.ProcedureServiceImpl;
import com.zohn.springboot01.domain.JsonData;
import com.zohn.springboot01.activemq.p2p.service.IProcedureService;
import org.apache.activemq.command.ActiveMQObjectMessage;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Destination;
import javax.jms.JMSException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
    @Qualifier("procedureService")
    private IProcedureService procedureService;

    // =================================================点对点模式=====================================================
    /**
     * @Description 模拟微信支付回调接口
     * @Author zohn
     * @Date 19/04/29 17:17
     * @Param [msg 支付信息]
     * @Return java.lang.Object
     */
    @GetMapping("/order")
    public Object order(String msg){
        // 生成消息队列
        Destination destination = new ActiveMQQueue("order.queue");
        procedureService.sendMessage(msg, destination);
        return JsonData.buildSuccess();
    }

    /**
     * @Description 默认发送到common
     * @Author zohn
     * @Date 19/04/29 17:44
     * @Param [msg]
     * @Return java.lang.Object
     */
    @GetMapping("/common")
    public Object common(String msg){
        // 这个msg是要发送的消息 不能为空
        // Resolved exception caused by Handler execution: java.lang.IllegalArgumentException: Payload must not be null
        procedureService.sendMessage(msg);
        return JsonData.buildSuccess();
    }

    /**
     * @Description 数据交换-最新招聘岗位信息同步
     * @Author zohn
     * @Date 2020\4\1 0001 10:56
     * @Param []
     * @Return java.lang.Object
     */
    @GetMapping("/gwxxDX")
    public Object gwxxDataExchange(@RequestBody Gwxx gwxx){
        // 生成消息队列
        Destination destination = new ActiveMQQueue("gwxx.queue");
        // iProcedureService.sendMessage(gwxx, destination);

        ActiveMQObjectMessage msg = new ActiveMQObjectMessage();
        try {
            msg.setObject(gwxx);
        } catch (JMSException e) {
            e.printStackTrace();
        }
        procedureService.send(msg,destination);
        return JsonData.buildSuccess();
    }


    /**
     * @Description 数据交换-最新招聘岗位信息同步List
     * @Author zohn
     * @Date 2020\4\1 0001 10:56
     * @Param []
     * @Return java.lang.Object
     */
    @GetMapping("/gwxxDXList")
    public Object gwxxDataExchangeList(@RequestBody Gwxx gwxx){

        // 生成mq
        Destination destination = new ActiveMQQueue("gwxx.queue.list");

        // 岗位信息
        List<Gwxx> gwxxList = new ArrayList(){{
            add(gwxx);
            add(gwxx);
            add(gwxx);
        }};

        // 转为json字符串
        String s = JSON.toJSONString(gwxxList);

        // 存入mq
        procedureService.sendMessage(s, destination);


        return JsonData.buildSuccess();
    }


    // =================================================发布订阅模式=====================================================

    /**
     * @Description 发布消息-生产者
     * @Author zohn
     * @Date 2019/5/28 20:46
     * @Param [msg]
     * @Return java.lang.Object
     */
    @GetMapping("/topic")
    public Object topic(String msg){
        procedureService.publish(msg);
        return JsonData.buildSuccess();
    }

}
