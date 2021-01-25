package com.zohn.springboot01.mq.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @Description RabbitMQ 配置类
 * @CreateDate 2021\1\25 0025 16:55
 * @Author z
 * @Version 1.0
 */
@Configuration
public class RabbitMQConfig {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${spring.rabbitmq.host}")
    private String host;

    @Value("${spring.rabbitmq.port}")
    private int port;

    @Value("${spring.rabbitmq.username}")
    private String username;

    @Value("${spring.rabbitmq.password}")
    private String password;

    public static final String EXCHANGE_A = "my-mq-exchange_A";
    public static final String EXCHANGE_B = "my-mq-exchange_B";
    public static final String EXCHANGE_C = "my-mq-exchange_C";


    public static final String QUEUE_A = "QUEUE_A";
    public static final String QUEUE_B = "QUEUE_B";
    public static final String QUEUE_C = "QUEUE_C";

    public static final String ROUTINGKEY_A = "spring-boot-routingKey_A";
    public static final String ROUTINGKEY_B = "spring-boot-routingKey_B";
    public static final String ROUTINGKEY_C = "spring-boot-routingKey_C";

    /**
     * @Description 链接工厂
     * @Author z
     * @Date 2021\1\25 0025 17:14
     * @Param []
     * @Return org.springframework.amqp.rabbit.connection.ConnectionFactory
     */
    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(host, port);
        cachingConnectionFactory.setUsername(username);
        cachingConnectionFactory.setPassword(password);
        cachingConnectionFactory.setVirtualHost("/");
        cachingConnectionFactory.setPublisherConfirms(true);
        return cachingConnectionFactory;
    }

    /**
     * @Description 必须是 prototype 类型 为什么呢
     * 看了这边文章 也没太懂 https://segmentfault.com/q/1010000017055914/a-1020000017056467
     *
     * @Author z
     * @Date 2021\1\25 0025 17:17
     * @Param []
     * @Return org.springframework.amqp.rabbit.core.RabbitTemplate
     */
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
        return rabbitTemplate;
    }
}
