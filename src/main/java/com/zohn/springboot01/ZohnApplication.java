package com.zohn.springboot01;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;
import javax.servlet.MultipartConfigElement;
import javax.servlet.annotation.MultipartConfig;

/**
 * 启动类
 *
 * @author zzohn
 */
@SpringBootApplication
@ServletComponentScan
@MapperScan("com.zohn.springboot01.mybatisstarter.mapper")
@EnableScheduling
@EnableAsync
@EnableJms
public class ZohnApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZohnApplication.class, args);
    }

    @Bean
    public MultipartConfigElement multipartConfigElement () {
        MultipartConfigFactory multipartConfigFactory = new MultipartConfigFactory();
        multipartConfigFactory.setMaxFileSize("10240KB");
        multipartConfigFactory.setMaxRequestSize("102400KB");
        return multipartConfigFactory.createMultipartConfig();
    }


    /**
     * @Description 创建一个队列 交给spring管理
     * @Author zohn
     * @Date 19/04/29 16:53
     * @Param []
     * @Return javax.jms.Queue
     */
    @Bean
    public Queue queue () {
        return new ActiveMQQueue("common.queue");
    }

    /**
     * @Description 创建一个topic  交给spring管理
     * @Author zohn
     * @Date 2019/5/28 20:37
     * @Param []
     * @Return javax.jms.Topic
     */
    @Bean
    public Topic topic() {
        return new ActiveMQTopic("video.topic");
    }


    //  需要给topic定义独立的JmsListenerContainer
    /**
     * @Description @JmsListener如果不指定独立的containerFactory的话是只能消费queue消息
     * 修改订阅者container：004containerFactory="jmsListenerContainerTopic"
     * @Author zohn
     * @Date 2019/5/28 21:12
     * @Param [activeMQConnectionFactory]
     * @Return org.springframework.jms.config.JmsListenerContainerFactory<?>
     */
    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerTopic(ConnectionFactory activeMQConnectionFactory) {
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        bean.setPubSubDomain(true);
        bean.setConnectionFactory(activeMQConnectionFactory);
        return bean;
    }
}
