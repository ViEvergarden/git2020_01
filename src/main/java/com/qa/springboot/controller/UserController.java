package com.qa.springboot.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.springboot.pojo.User;
import com.qa.springboot.pojo.Userinfo;
import com.qa.springboot.serviceImpl.UserServiceImpl;
import com.qa.springboot.serviceImpl.UserinfoServiceImpl;



@RestController
public class UserController {
	
	@Autowired
	UserServiceImpl us;
	@Autowired
	UserinfoServiceImpl uis;
	
	
	@RequestMapping("/login")
	public Map<String, Object> login(String uname,String password,HttpSession session){
		Map<String, Object> map=new HashMap<String, Object>();
		User user = us.login(uname, password);
		if(user!=null){
			Userinfo userinfo = us.queryByuid(user.getUserid());
			map.put("user", user);
			map.put("userinfo", userinfo);
		}	
		return map;
	}
	@RequestMapping("/resgister")
	public String resgister(User u,Userinfo uf){
			System.out.println("user:"+u+",userinfo:"+uf);
			String logname = u.getLogname();
			if(us.queryBylogname(logname)){
//				补全user字段
				String s = u.getSalt();
				int j = s.lastIndexOf("\\")+1;
				String salt = s.substring(j);
				u.setSalt(salt);
				u.setStatus(1111);
				u.setUtid(1);
//				新增user并获取userid
				Integer userid = us.addUser(u);
//				补全Userinfo字段
				uf.setUserid(userid);
				uf.setLogdate(new Date());
//				新增Userinfo
				uis.adduserinfo(uf);
			}

		return "";
	}

	
}
