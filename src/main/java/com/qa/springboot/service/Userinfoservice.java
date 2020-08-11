package com.qa.springboot.service;

import com.qa.springboot.pojo.Userinfo;

public interface Userinfoservice {
//	查询用户信息
	Userinfo update(Userinfo userinfo); 
//	增加用户信息
	void adduserinfo(Userinfo userinfo);
	
	

}
