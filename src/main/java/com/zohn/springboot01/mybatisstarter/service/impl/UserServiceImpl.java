package com.zohn.springboot01.mybatisstarter.service.impl;

import com.zohn.springboot01.mybatisstarter.domain.User;
import com.zohn.springboot01.mybatisstarter.mapper.UserMapper;
import com.zohn.springboot01.mybatisstarter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @Description: userService实现类
 * @Author: zohn
 * @CreateDate: 2019/3/17 11:08
 * @Version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public int add(User user) {
        userMapper.insert(user);
        int id = user.getId();
        return id;
    }


    /**
     * 测试
     *     propagation【传播属性】
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class,Error.class})
    public int addCount() {
        User user = new User();
        user.setAge(88);
        user.setCreateTime(new Date());
        user.setName("测试事务啦加入事务");
        user.setPhone("10010101010");
        userMapper.insert(user);
        int i = 19/0;
        return 0;
    }
}
