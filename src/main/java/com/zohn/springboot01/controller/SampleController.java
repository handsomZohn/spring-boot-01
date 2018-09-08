package com.zohn.springboot01.controller;

import java.util.Date;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zohn.springboot01.domain.User;

@RestController
public class SampleController {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

    @GetMapping("/testJson")
    public Object testJson() {
        return new User("zhangyifeng", null, "18310834045", "123012301230", new Date());
    }


}
