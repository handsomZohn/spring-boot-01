package com.zohn.springboot01.reidsstarter.controller;


import com.zohn.springboot01.domain.JsonData;
import com.zohn.springboot01.domain.User;
import com.zohn.springboot01.utils.JsonUtils;
import com.zohn.springboot01.utils.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @Description: spring-boot整合redis
 * @Author: zohn
 * @CreateDate: 2019/3/24 20:50
 * @Version: 1.0
 */
@Controller
@RequestMapping("/api/v1/redis")
public class RedisController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private RedisClient redisClient;

    @GetMapping("/add")
    @ResponseBody
    public Object add(){
        redisTemplate.opsForValue().set("name","zhangyifeng");
        return JsonData.buildSuccess("ok");
    }


    @GetMapping("/get")
    @ResponseBody
    public Object get() {
        String name = redisTemplate.opsForValue().get("name");
        return JsonData.buildError(name);
    }

    @GetMapping("/addUser")
    @ResponseBody
    public Object addUser() {
        User user = new User("zhangwuji", "abc", "12", "18310834045", new Date());
        String s = JsonUtils.obj2String(user);
        boolean flag = redisClient.set("redis:user:12", s);
        return JsonData.buildSuccess(flag);
    }

    @GetMapping("/findUser")
    @ResponseBody
    public Object getUser(){
        String s = redisClient.get("redis:user:12");
        User user = JsonUtils.string2Obj(s, User.class);
        return JsonData.buildSuccess(user);
    }

}
