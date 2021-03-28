package spring.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;


/**
 *@Description  定义观众切面 包含前置通知和后置通知
 *@CreateDate 2021/3/28 14:43
 *@Author zz
 *@Version 1.0
 */
@Aspect
public class Audience {

    /**
     * 表演前：手机静音
     */
    @Before("execution(* spring.aop.Performance.perform(..))")
    public void silenceCellPhones(){
        System.out.println("Silencing cell phones");
    }

    /**
     * 表演前：找个坐
     */
    @Before("execution(* spring.aop.Performance.perform(..))")
    public void takeSeats(){
        System.out.println("Taking seats");
    }

    /**
     * 表演后：鼓掌喝彩
     */
    @AfterReturning("execution(* spring.aop.Performance.perform(..))")
    public void applause(){
        System.out.println("CLAP! CLAP! CLAP! CLAP!");
    }

    /**
     * 表演失败后：要求退款
     */
    @AfterThrowing("execution(* spring.aop.Performance.perform(..))")
    public void demanRefund(){
        System.out.println("Demaning a refund");
    }
}


