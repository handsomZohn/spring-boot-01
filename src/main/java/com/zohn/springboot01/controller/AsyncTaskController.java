package com.zohn.springboot01.controller;

import com.zohn.springboot01.asynctask.AsyncTask;
import com.zohn.springboot01.domain.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

/**
 * @Description: 异步任务Controller
 * @Author: zohn
 * @CreateDate: 2019/4/17 21:16
 * @Version: 1.0
 */
@RestController
@RequestMapping("/api/v1/")
public class AsyncTaskController {

    @Autowired
    private AsyncTask asyncTask;

    /**
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/asyncTask")
    public JsonData exeAsyncTask() throws Exception{

        long begin = System.currentTimeMillis();

        // 异步任务
        // asyncTask.task01();
        // asyncTask.task02();
        // asyncTask.task03();

        // 带有返回结果的异步任务
        Future<String> task04 = asyncTask.task04();
        Future<String> task05 = asyncTask.task05();
        Future<String> task06 = asyncTask.task06();
        for (;;){
            if (task04.isDone() && task05.isDone() && task06.isDone()){
                break;
            }
        }


        long end = System.currentTimeMillis();

        // return JsonData.buildSuccess("task01、02、03一共耗时：" + (end - begin) + "ms");

        // 异步耗时3010  同步耗时6003ms
        String DescOfExeResult = "task04,05,06 Time consuming:" + (end - begin) + "ms";
        System.out.println(DescOfExeResult);
        return JsonData.buildSuccess(DescOfExeResult);
    }
}
