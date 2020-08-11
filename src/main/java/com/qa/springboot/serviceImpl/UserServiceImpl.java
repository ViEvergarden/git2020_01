package com.qa.springboot.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.springboot.mapper.UserMapper;
import com.qa.springboot.mapper.UserinfoMapper;
import com.qa.springboot.pojo.User;
import com.qa.springboot.pojo.UserExample;
import com.qa.springboot.pojo.UserExample.Criteria;
import com.qa.springboot.pojo.Userinfo;
import com.qa.springboot.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserMapper um;
	@Autowired
	UserinfoMapper uim;
	
	@Override
	public User login(String uname,String password) {
		UserExample ue = new UserExample();
		Criteria c = ue.createCriteria();
		c.andLognameEqualTo(uname).andPasswordEqualTo(password);
		List<User> list = um.selectByExample(ue);
		if(list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
		
	}


	@Override
	public Userinfo queryByuid(Integer uid) {
		Userinfo uif = uim.selectByPrimaryKey(uid);
		return uif;
	}

//新增一个user并获取userid返回
	@Override
	public Integer addUser(User user) {
		um.insert(user);
		UserExample ue= new UserExample();
		Criteria c = ue.createCriteria();
		c.andLognameEqualTo(user.getLogname());
		return um.selectByExample(ue).get(0).getUserid();
	}

	@Override
	public boolean queryBylogname(String logname) {
		boolean falg=false;
		UserExample ue = new UserExample();
		Criteria c = ue.createCriteria();
		c.andLognameEqualTo(logname);
		List<User> list = um.selectByExample(ue);
		if(list.size()==0){
			falg=true;
		}
		return falg;
	}


	@Override
	public Integer queryUtidByUid(Integer userid) {
		return um.selectByPrimaryKey(userid).getUtid();
	}
}
