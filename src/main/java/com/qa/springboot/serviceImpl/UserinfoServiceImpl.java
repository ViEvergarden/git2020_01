package com.qa.springboot.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.springboot.mapper.UserinfoMapper;
import com.qa.springboot.pojo.UserExample;
import com.qa.springboot.pojo.UserExample.Criteria;
import com.qa.springboot.pojo.Userinfo;
import com.qa.springboot.service.Userinfoservice;

@Service
public class UserinfoServiceImpl implements Userinfoservice{

	@Autowired
	UserinfoMapper um;
	@Override
	public Userinfo update(Userinfo userinfo) {
		um.updateByPrimaryKey(userinfo);
		return um.selectByPrimaryKey(userinfo.getUserid());
	}
	@Override
	public void adduserinfo(Userinfo userinfo) {
		um.insert(userinfo);
		
	}


}
