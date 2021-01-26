package com.zohn.springboot01.mq.rabbitmq;


import com.zohn.springboot01.mq.rocketmq.domain.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *@Description rabbit
 *@CreateDate 2021\1\26 0026 11:15
 *@Author z
 *@Version 1.0
 */
@RequestMapping("/rabbitmq")
@RestController
public class RabbitMQController {
    @Autowired
    private RabbitMQMsgProducer producer;


    /**
     * @Description 向消息队列里面发送消息  发送之后在RabbitMQMsgReceiver121的process()方法中会监听queue中的消息 有新的就会
     * 去消费
     * @Author z
     * @Date 2021\1\26 0026 11:21
     * @Param [msg]
     * @Return java.lang.Object
     */
    @RequestMapping("/push")
    public Object pushMsg(String msg) {
        producer.sendMsg(msg);
        return  JsonData.buildSuccess(msg);
    }

    @RequestMapping("/sendMsgToQueueB")
    public Object sendMsgToQueueB(String msg) {
        producer.sendMsgToQueueB(msg);
        return  JsonData.buildSuccess(msg);
    }
}
