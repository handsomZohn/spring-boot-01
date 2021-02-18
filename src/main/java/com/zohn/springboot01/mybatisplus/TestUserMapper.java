/*
package com.zohn.springboot01.mybatisplus;

import com.zohn.springboot01.mybatisplus.domain.User;
import com.zohn.springboot01.mybatisplus.mapper.MybatisPlusUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest

@Slf4j
public class TestUserMapper {

    // @Resource
    MybatisPlusUserMapper userMapper;

    @Test
    void insert() {
        User user = new User();
        user.setUsername("张三");
        user.setPassword("123456");
        user.setCreateTime(new Date());
        Integer count = userMapper.insert(user);
        log.info("count:{}", count);
    }

    @Test
    void selectById() {
        User user = userMapper.selectById(13);
        log.info("user:{}", user.toString());
    }

    @Test
    void selectByUsername() {
        User user = userMapper.selectByUsername("张三");
        log.info("user:{}", user.toString());
    }

    @Test
    void updateById() {
        User user = new User();
        user.setId(13);
        user.setUsername("李四");
        user.setPassword("111111");
        Integer count = userMapper.updateById(user);
        log.info("count:{}", count);
    }

    @Test
    void deleteById() {
        Integer count = userMapper.deleteById(13);
        log.info("count:{}", count);
    }
}
*/
