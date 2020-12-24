package com.zohn.springboot01.mq.activemq.p2p.jms;

import com.alibaba.fastjson.JSON;
import com.zohn.springboot01.mq.activemq.p2p.entity.Gwxx;
import org.apache.activemq.command.ActiveMQObjectMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *@Description 消息队列--消费者
 *@CreateDate 19/04/29 17:29
 *@Author Administrator
 *@Version 1.0
 */
@Component
public class OrderConsumer {

    // 实时监听
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

    @JmsListener(destination = "gwxx.queue")
    public void gwxxDataExchangeQueue(ActiveMQObjectMessage msg) throws Exception{
        Gwxx gwxx = (Gwxx) msg.getObject();
        String s = gwxx.toString();
        System.out.println("======^_^======变量s值为: " + s + ", " + "当前类以及方法名字是: OrderConsumer.gwxxDXQueue()");
    }


    /*@Scheduled(cron = "20 7 15 * * *")
    public void gwxxDXQueue() throws Exception{
        gwxxDXQueue(new ActiveMQObjectMessage());
    }*/

    /**
     * @Description 获取gwxxList
     * @Author zohn
     * @Date 2020\4\1 0001 14:26
     * @Param [str]
     * @Return void
     */
    @JmsListener(destination = "gwxx.queue.list")
    public void gwxxDataExchangeListQueue(String str) throws Exception{
        List<Gwxx> gwxxList = JSON.parseArray(str, Gwxx.class);
        // 转为gwxx集合
        String s = gwxxList.toString();
        System.out.println("======^_^======变量s值为: " + s + ", " + "当前类以及方法名字是: OrderConsumer.gwxxDXQueue()");
    }
}
