package spring.aop;

import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Bean;

/**
 *@Description  定义观众切面 包含前置通知和后置通知 如果不启用自动代理功能，该类只是一个简单的POJO
 * 使用@Pointcut注解
 *@CreateDate 2021/3/28 14:43
 *@Author zz
 *@Version 2.0
 */
@Aspect
public class Audience02 {
    @Bean
    public Audience02 audience02(){
        return new Audience02();
    }


    @Pointcut("execution(* spring.aop.Performance.perform(..))")
    public void performance(){

    }

    /**
     * 表演前：手机静音
     */
    @Before("performance()")
    public void silenceCellPhones(){
        System.out.println("Silencing cell phones");
    }

    /**
     * 表演前：找个坐
     */
    @Before("performance()")
    public void takeSeats(){
        System.out.println("Taking seats");
    }

    /**
     * 表演后：鼓掌喝彩
     */
    @AfterReturning("performance()")
    public void applause(){
        System.out.println("CLAP! CLAP! CLAP! CLAP!");
    }

    /**
     * 表演失败后：要求退款
     */
    @AfterThrowing("performance()")
    public void demanRefund(){
        System.out.println("Demaning a refund");
        throw new RuntimeException();
    }
}


