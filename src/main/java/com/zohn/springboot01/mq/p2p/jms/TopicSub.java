package com.zohn.springboot01.mq.p2p.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @Description: Topic消费者   简单理解为消息订阅
 * @Author: zohn
 * @CreateDate: 2019/5/28 20:51
 * @Version: 1.0
 */
@Component
public class TopicSub {

    /**
     * @Description 消费者001  积分系统
     * @Author zohn
     * @Date 2019/5/28 20:52
     * @Param []
     * @Return void
     */
    @JmsListener(destination = "video.topic", containerFactory = "jmsListenerContainerTopic")
    public void receiver001(String string) {
        System.out.println("video.topic consumer receive001:" + string);
    }
    /**
     * @Description 消费者  库存系统
     * @Author zohn
     * @Date 2019/5/28 20:52
     * @Param []
     * @Return void
     */
    @JmsListener(destination = "video.topic", containerFactory = "jmsListenerContainerTopic")
    public void receiver002(String string) {
        System.out.println("video.topic consumer receive002:" + string);
    }
    /**
     * @Description 消费者 订单系统
     * @Author zohn
     * @Date 2019/5/28 20:52
     * @Param []
     * @Return void
     */
    @JmsListener(destination = "video.topic")
    public void receiver003(String string) {
        System.out.println("video.topic consumer receive003:" + string);
    }

    // @JmsListener如果不指定独立的containerFactory的话是只能消费queue消息
    // 不能同时支持两种模式的消息发布模型

}
