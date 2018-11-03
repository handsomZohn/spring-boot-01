package com.zohn.springboot01.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
	private String username;
	
	// 意思是 如果这个值为空就不再显示了
	@JsonInclude(Include.NON_NULL)
	private String age;
	
	// 别名的转换
	@JsonProperty("account")
	private String telephone;
	
	// 一些敏感信息不向浏览器反馈
	@JsonIgnore
	private String pwd;

	// 指定日期的特定格式
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", locale = "zh", timezone = "GTM")
	private Date CT;// 创建时间

	public User(String username, String age, String telephone, String pwd, Date cT) {
		super();
		this.username = username;
		this.age = age;
		this.telephone = telephone;
		this.pwd = pwd;
		CT = cT;
	}

	public User(String username, String age) {
		super();
		this.username = username;
		this.age = age;

	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Date getCT() {
		return CT;
	}

	public void setCT(Date cT) {
		CT = cT;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

}
