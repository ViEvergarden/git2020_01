package com.qa.springboot.service;

import java.util.List;

import com.qa.springboot.pojo.UserAddress;

public interface AddressService {
//	查询某用户所有地址
	List<UserAddress> queryall(Integer userid);
//	添加地址
	void add(UserAddress u);
//	删除地址
	void del(Integer aid);
//	修改地址
	UserAddress update(UserAddress u);
//	根据id查询（用于回显）
	UserAddress queryByaid(Integer aid);
}
