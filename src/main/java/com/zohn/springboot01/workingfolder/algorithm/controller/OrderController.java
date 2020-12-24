package com.zohn.springboot01.workingfolder.algorithm.controller;

import com.zohn.springboot01.workingfolder.algorithm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("snowflakeController")
public class OrderController {

    @Autowired
    @Qualifier("snowflakeTest")
    private OrderService service;

    @RequestMapping("snowflake")
    public String index(){
        return service.getIdBySnowflake();
    }
}
