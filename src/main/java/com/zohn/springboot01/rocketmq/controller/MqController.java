package com.zohn.springboot01.rocketmq.controller;


import com.zohn.springboot01.rocketmq.domain.JsonData;
import com.zohn.springboot01.rocketmq.service.ProducerService;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;


@RequestMapping("/rocketmq")
@RestController
public class MqController {
    @Autowired
    private ProducerService producer;

    @RequestMapping("/push")
    public String pushMsg(String msg) {
        return producer.send("testTopic", "push", msg);
    }


    /**
     * 功能描述：微信支付回调接口
     *
     * @param msg 支付信息
     * @return
     */
    @GetMapping("comment")
    public Object comment(String msg) throws MQClientException, RemotingException, MQBrokerException, InterruptedException, UnsupportedEncodingException {

        /**
         * 创建一个消息实例，包含 topic、tag 和 消息体
         */
        Message message = new Message("commentTopic", "push", msg.getBytes(RemotingHelper.DEFAULT_CHARSET));

        //同步的方式，会有返回结果,发送的是普通消息
        String result = producer.send("commentTopic", "push", msg);

        return JsonData.buildSuccess(result);
    }


}
