package com.zohn.springboot01.mybatisstarter.service;

import com.zohn.springboot01.mybatisstarter.domain.User;
import org.springframework.stereotype.Service;

/**
 * @Description: user业务接口
 * @Author: zohn
 * @CreateDate: 2019/3/17 11:06
 * @Version: 1.0
 */
public interface UserService {

    /**新增
     * @param user
     * @return
     */
    int add(User user);



    /**
     * 功能描述：测试事务
     * @return
     */
    int addCount();
}
