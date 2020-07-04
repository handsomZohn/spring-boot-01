package com.zohn.springboot01.mybatisstarter.controller;

import com.zohn.springboot01.mybatisstarter.domain.JsonData;
import com.zohn.springboot01.mybatisstarter.domain.User;
import com.zohn.springboot01.mybatisstarter.mapper.UserMapper;
import com.zohn.springboot01.mybatisstarter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Description: UserController
 * @Author: zohn
 * @CreateDate: 2019/3/17 11:21
 * @Version: 1.0
 */
@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * 添加
     * @return
     */
    @GetMapping("add")
    public Object add () {
        User user = new User();
        user.setAge(11);
        user.setCreateTime(new Date());
        user.setName("zohn");
        user.setPhone("18310834045");
        int id = userService.add(user);
        return JsonData.buildSuccess(id);
    }


    @Autowired
    UserMapper mapper;

    @GetMapping("/findAll")
    public Object findAll() {
        return JsonData.buildSuccess(mapper.getAll());
    }

    @GetMapping("/findById")
    public Object findById(String id) {
        return JsonData.buildSuccess(mapper.findById(id));
    }

    /**
     * get请求在url后面拼接参数时，可以不要@RequestParam
     *
     * @param name
     * @param id
     * @return
     */



    @GetMapping("/update")
    public Object update(String name, int id) {
        User user = new User();
        user.setName(name);
        user.setId(id);
        mapper.update(user);
        return JsonData.buildSuccess();
    }

    @GetMapping("/delete")
    public Object delete(String id) {
        mapper.delete(id);
        return JsonData.buildSuccess();
    }

    @GetMapping("/testTransAction")
    public Object addCount() {
        userService.addCount();
        return JsonData.buildSuccess();
    }


}
