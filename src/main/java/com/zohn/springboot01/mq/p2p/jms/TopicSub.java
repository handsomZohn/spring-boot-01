package com.zohn.springboot01.mq.p2p.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @Description: Topic������   �����Ϊ��Ϣ����
 * @Author: zohn
 * @CreateDate: 2019/5/28 20:51
 * @Version: 1.0
 */
@Component
public class TopicSub {

    /**
     * @Description ������001  ����ϵͳ
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
     * @Description ������  ���ϵͳ
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
     * @Description ������ ����ϵͳ
     * @Author zohn
     * @Date 2019/5/28 20:52
     * @Param []
     * @Return void
     */
    @JmsListener(destination = "video.topic")
    public void receiver003(String string) {
        System.out.println("video.topic consumer receive003:" + string);
    }

    // @JmsListener�����ָ��������containerFactory�Ļ���ֻ������queue��Ϣ
    // ����ͬʱ֧������ģʽ����Ϣ����ģ��

}
