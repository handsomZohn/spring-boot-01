package com.zohn.springboot01.controller;

import com.zohn.springboot01.domain.ServerSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Administrator
 */
@Controller
@RequestMapping("/freemarker")
public class FreeMarkerController {


    @Autowired
    private ServerSetting serverSetting;


    @GetMapping("/hello")
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("serverSetting", serverSetting);
        // 不用加后缀  因为在properties文件里面已经指定了后缀
        return "fm/index";
    }
}
