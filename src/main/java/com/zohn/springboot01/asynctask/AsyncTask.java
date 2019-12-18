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
        System.out.println("Task01 Time consuming:" + (end - begin) + "ms;");
    }

    public void task02() throws InterruptedException{
        long begin = System.currentTimeMillis();
        Thread.sleep(2000L);
        long end = System.currentTimeMillis();
        System.out.println("Task02 Time consuming:" + (end - begin) + "ms;");
    }

    public void task03() throws InterruptedException{
        long begin = System.currentTimeMillis();
        Thread.sleep(3000L);
        long end = System.currentTimeMillis();
        System.out.println("Tasj03 Time consuming:" + (end - begin) + "ms;");
    }


    // ================================================获取异步处理结果=============================



    public Future<String> task04() throws InterruptedException{
        long begin = System.currentTimeMillis();
        Thread.sleep(1000L);
        long end = System.currentTimeMillis();
        System.out.println("Tasj04 Time consuming:" + (end - begin) + "ms;");
        return new AsyncResult<>("Task04");
    }

    public Future<String> task05() throws InterruptedException{
        long begin = System.currentTimeMillis();
        Thread.sleep(2000L);
        long end = System.currentTimeMillis();
        System.out.println("Task05Time consuming:" + (end - begin) + "ms;");
        return new AsyncResult<>("Task05");
    }

    public Future<String> task06() throws InterruptedException{
        long begin = System.currentTimeMillis();
        Thread.sleep(3000L);
        long end = System.currentTimeMillis();
        System.out.println("Tasj06 Time consuming:" + (end - begin) + "ms;");
        return new AsyncResult<>("Task06");
    }



}
