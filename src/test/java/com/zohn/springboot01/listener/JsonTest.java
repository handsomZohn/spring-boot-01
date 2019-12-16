package com.zohn.springboot01.listener;

import com.zohn.springboot01.ZohnApplication;
import com.zohn.springboot01.domain.User;
import com.zohn.springboot01.utils.JsonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ZohnApplication.class})
public class JsonTest {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void testOne(){
        User user = new User();
        user.setUsername("username01");
        user.setAge("1");
        user.setTelephone("18310834045");
        user.setPwd("123456789");
        user.setCT(new Date());
        String s = JsonUtils.obj2String(user);
        redisTemplate.opsForValue().set("test:json:02",s);
        System.out.println(s);
    }
}
