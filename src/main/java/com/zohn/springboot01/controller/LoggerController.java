package com.zohn.springboot01.controller;

import com.zohn.springboot01.mybatisStarter.domain.JsonData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: logback日志框架Controller
 * @Author: zohn
 * @CreateDate: 2019/4/21 12:53
 * @Version: 1.0
 */
@RestController
@RequestMapping("/api/v1")
public class LoggerController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/log")
    public Object testLog() {
        logger.debug("this is debug level");
        logger.info("this is info level ");
        logger.warn("this is warn level ");
        logger.error("this is error level");
        return JsonData.buildSuccess();
    }

}
