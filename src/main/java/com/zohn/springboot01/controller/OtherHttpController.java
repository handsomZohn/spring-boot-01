package com.zohn.springboot01.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/**
  *    测试http协议的put，post，delete提交方式
 * @author zzohn
 *
 */
@RestController
public class OtherHttpController {
	
	
	private Map<String, Object> params = new HashMap<>();
	
	/**
	 * 测试postMapping
	 * @param id
	 * @param pwd
	 * @return
	 */
	@PostMapping("/v1/login")
	public Object login(String id, String pwd) {
		params.clear();
		params.put("id", id);
		params.put("pwd", pwd);
		return params;
	}
	
	/**
	 * putMapping
	 *  要在url里面加参数
	 * @param id
	 * @return
	 */
	@PutMapping("/v1/put")
	public Object put(String id) {
		params.clear();
		params.put("id", id);
		return params;
	}
	
	@DeleteMapping("/v1/del")
	public Object delete(String id) {
		params.clear();
		params.put("id", id);
		return params;
	}
	
}
