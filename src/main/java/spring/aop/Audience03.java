package spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Bean;

/**
 *@Description 创建环绕通知 定义观众切面 环绕通知 如果不启用自动代理功能，该类只是一个简单的POJO
 * 使用@Pointcut注解
 *@CreateDate 2021/3/28 14:43
 *@Author zz
 *@Version 2.0
 */
@Aspect
public class Audience03 {
    @Bean
    public Audience03 audience02(){
        return new Audience03();
    }


    @Pointcut("execution(* spring.aop.Performance.perform(..))")
    public void performance(){

    }

    /**
     * 环绕通知方法
     * @param joinPoint
     */
    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint joinPoint){

        try {
            System.out.println("Silencing cell phones");
            System.out.println("Taking seats");
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("Demaning a refund");
        }

    }
}


