package com.zohn.springboot01.controller;

import com.zohn.springboot01.domain.MyException;
import com.zohn.springboot01.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 全局异常
 * @Author: zohn
 * @CreateDate: 2018/11/3 9:17
 * @UpdateUser: zohn
 * @UpdateDate: 2018/11/3 9:17
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@RestController
@RequestMapping("/dsz")// 第四章
public class ExceptionController {

    @GetMapping("/exception/test")
    public Object exceptionTest() {
        // int i = 10 / 0;// 返回前端的是：：/ by zero
        int i = 0;
        User user = null;// 返回前端的消息是：： null
        user.getAge();
        return new User("zohn","20" + i);
    }


    @GetMapping("/myExceptionTest")
    public Object MyExceptionTest() throws MyException{
        throw new MyException("499", "lose conn with server");// 手动抛出异常
    }


}
