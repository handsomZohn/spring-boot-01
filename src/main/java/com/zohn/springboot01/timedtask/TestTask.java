package com.zohn.springboot01.timedtask;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description:定时任务业务类
 * @Author: zohn
 * @CreateDate: 2019/4/14 9:06
 * @Version: 1.0
 */
@Component
public class TestTask {


    /**
     * 每隔10秒  执行任务
     *
     */
    //@Scheduled(fixedRate = 1000*10)
    @Scheduled(cron = "*/10 * * * * *")
    public void sum(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        String format = simpleDateFormat.format(new Date());
        System.out.println("当前时间：" + format);
    }
}
