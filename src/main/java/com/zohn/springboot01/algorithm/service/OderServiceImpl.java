package com.zohn.springboot01.algorithm.service;

import com.zohn.springboot01.algorithm.utils.IdGeneratorSnowflake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service("snowflakeTest")
public class OderServiceImpl implements OrderService {

    @Autowired
    private IdGeneratorSnowflake idGeneratorSnowflake;

    @Override
    public String getIdBySnowflake() {
        ExecutorService threadPool = Executors.newFixedThreadPool(15);
        for (int i = 0; i < 20; i++) {
            threadPool.submit(() -> {
                System.out.println(idGeneratorSnowflake.snowflakeId());
            });
        }

        threadPool.shutdown();

        return "hello snowflake";
    }
}
