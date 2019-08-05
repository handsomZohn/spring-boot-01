package com.zohn.springboot01.asynctask;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * @Description: 异步任务
 * @Author: zohn
 * @CreateDate: 2019/4/17 21:05
 * @Version: 1.0
 */
@Component
@Async
public class AsyncTask {


    public void task01() throws InterruptedException{
        long begin = System.currentTimeMillis();
        Thread.sleep(1000L);
        long end = System.currentTimeMillis();
        System.out.println("任务01耗时：" + (end - begin) + "ms;");
    }

    public void task02() throws InterruptedException{
        long begin = System.currentTimeMillis();
        Thread.sleep(2000L);
        long end = System.currentTimeMillis();
        System.out.println("任务02耗时：" + (end - begin) + "ms;");
    }

    public void task03() throws InterruptedException{
        long begin = System.currentTimeMillis();
        Thread.sleep(3000L);
        long end = System.currentTimeMillis();
        System.out.println("任务03耗时：" + (end - begin) + "ms;");
    }


    // ================================================获取异步处理结果=============================



    public Future<String> task04() throws InterruptedException{
        long begin = System.currentTimeMillis();
        Thread.sleep(1000L);
        long end = System.currentTimeMillis();
        System.out.println("任务04耗时：" + (end - begin) + "ms;");
        return new AsyncResult<>("任务04");
    }

    public Future<String> task05() throws InterruptedException{
        long begin = System.currentTimeMillis();
        Thread.sleep(2000L);
        long end = System.currentTimeMillis();
        System.out.println("任务05耗时：" + (end - begin) + "ms;");
        return new AsyncResult<>("任务05");
    }

    public Future<String> task06() throws InterruptedException{
        long begin = System.currentTimeMillis();
        Thread.sleep(3000L);
        long end = System.currentTimeMillis();
        System.out.println("任务06耗时：" + (end - begin) + "ms;");
        return new AsyncResult<>("任务06");
    }



}
