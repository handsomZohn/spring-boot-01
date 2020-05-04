package com.zohn.springboot01.xdvideo.service;


import com.zohn.springboot01.xdvideo.domain.User;
import org.springframework.stereotype.Service;

/**
 *@Description 用户业务接口类
 *@CreateDate 2020/2/9 13:49
 *@Author zohn
 *@Version 1.0
 */
@Service("com.zohn.springboot01.xdvideo.service.impl.UserService")
public interface UserService {
   User saveWechatUser(String code);
}
