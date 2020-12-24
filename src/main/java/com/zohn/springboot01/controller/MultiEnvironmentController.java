package com.zohn.springboot01.controller;

import com.zohn.springboot01.domain.JsonData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/multiEnvironment")
public class MultiEnvironmentController {
    @Value("${dateBase.url}")
    private String dataBaseUrl;

    @RequestMapping("/api/v1")
    public Object getataBaseUrl(){
        System.out.println("======^_^======variable dataBaseUrl value is : " + dataBaseUrl + ", " + " current method and class name is : MultiEnvironmentController.getataBaseUrl()");
        return JsonData.buildError(dataBaseUrl);
    }
}
