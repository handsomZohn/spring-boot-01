package com.zohn.springboot01.xdvideo.controller;


import com.zohn.springboot01.mybatisstarter.mapper.VideoMapper;
import com.zohn.springboot01.xdvideo.config.WeChatConfig;
import com.zohn.springboot01.xdvideo.domain.JsonData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

	@Autowired
	private WeChatConfig weChatConfig;

	@RequestMapping("wechatConfig")
	public JsonData test(){
		return JsonData.buildSuccess(weChatConfig.getAppSecret());
	}

	@Autowired
	private VideoMapper videoMapper;

	@RequestMapping("findAll")
	public Object testDb(){
		return videoMapper.findAll();
	}


	@RequestMapping("findById")
	public Object findById(String id){
		return videoMapper.findById(Integer.parseInt(id));
	}
}
