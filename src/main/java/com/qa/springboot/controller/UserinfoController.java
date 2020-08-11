package com.qa.springboot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.springboot.pojo.Userinfo;
import com.qa.springboot.serviceImpl.UserinfoServiceImpl;

@RestController
@RequestMapping("/userinfo")
public class UserinfoController {

	@Autowired
	UserinfoServiceImpl us;
	@RequestMapping("/update")
	public Map<String, Object> update(Userinfo userinfo){
		Map<String, Object> map = new HashMap<String, Object>();
		Userinfo user = us.update(userinfo);
		map.put("userinfo", user);
		return map;
	}
}
