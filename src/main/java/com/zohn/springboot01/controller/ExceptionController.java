package com.zohn.springboot01.controller;

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
        int i = 10 / 0;
        return new User("宋明潞","20" + i);
    }

}
