package com.zohn.springboot01.mq.rabbitmq;

import com.zohn.springboot01.mybatisstarter.domain.User;
import com.zohn.springboot01.mybatisstarter.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 *@Description rabbitmq消息接受者 一对一 一个生产者 一个消费者
 *@CreateDate 2021\1\26 0026 10:53
 *@Author z
 *@Version 1.0
 */
@Component
@RabbitListener(queues = RabbitMQConfig.QUEUE_A)
public class RabbitMQMsgReceiver121 {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @RabbitHandler
    public void process(String content){
        logger.info("接收处理队列A当中的消息： " + content);
        User user = new User();
        user.setAge(11);
        user.setCreateTime(new Date());
        user.setName(content);
        user.setPhone("18310834045");
        int id = userService.add(user);
    }
}
