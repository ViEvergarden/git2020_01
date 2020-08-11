package com.qa.springboot.service;

import com.qa.springboot.pojo.User;
import com.qa.springboot.pojo.Userinfo;

public interface UserService {
//	登录
	User login(String uname,String password);
//	根据id查询用户详情
	Userinfo queryByuid(Integer uid);
//	增加用户并返回id
	Integer addUser(User user);
//	账号查重
	boolean queryBylogname(String logname);
//	查询等级
	Integer queryUtidByUid(Integer userid);
}
