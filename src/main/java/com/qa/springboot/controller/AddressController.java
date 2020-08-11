package com.qa.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.springboot.pojo.UserAddress;
import com.qa.springboot.serviceImpl.AddressServiceImpl;

@RestController
@RequestMapping("/addressController")
public class AddressController {

	@Autowired
	AddressServiceImpl as;
	
	
	@RequestMapping("/queryAddress")
	public List<UserAddress> queryAddress(Integer userid){
		return as.queryall(userid);
	}
	
	
	@RequestMapping("/addAddress")
	public void addAddress(UserAddress u){
		as.add(u);
	
	}
	
	@RequestMapping("/delAddress")
	public void delAddress(Integer aid){
		as.del(aid);
	}
	@RequestMapping("/updateAddress")
	public UserAddress updateAddress(UserAddress u){
		return as.update(u);
	}
	
	
	
	@RequestMapping("/editAddress")
	public UserAddress editAddress(Integer aid){
		return as.queryByaid(aid);
	}
}
