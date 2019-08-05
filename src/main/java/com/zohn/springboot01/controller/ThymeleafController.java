package com.zohn.springboot01.controller;

import com.zohn.springboot01.domain.ServerSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("thymeleaf")
public class ThymeleafController {

    @GetMapping("hello")
    public String index() {
        return "index";// 返回index.html页面 不用加后缀，因为已经指定好了
    }

    @Autowired
    ServerSetting serverSetting;

    @GetMapping("serverInfo")
    public String serverInfo(ModelMap modelMap) {
        modelMap.put("serverSetting",serverSetting);
        return "admin/info";
    }
}
