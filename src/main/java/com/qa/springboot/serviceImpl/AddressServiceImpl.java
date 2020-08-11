package com.qa.springboot.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.springboot.mapper.UserAddressMapper;
import com.qa.springboot.pojo.UserAddress;
import com.qa.springboot.pojo.UserAddressExample;
import com.qa.springboot.pojo.UserAddressExample.Criteria;
import com.qa.springboot.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService{

	@Autowired
	UserAddressMapper um;
	@Override
	public List<UserAddress> queryall(Integer userid) {
		UserAddressExample ue=new UserAddressExample();
		Criteria c = ue.createCriteria();
		c.andUseridEqualTo(userid);
		return um.selectByExample(ue);
	}
	@Override
	public void add(UserAddress u) {
		um.insert(u);
		
	}
	@Override
	public void del(Integer aid) {
		
		um.deleteByPrimaryKey(aid);
		
	}
	@Override
	public UserAddress update(UserAddress u) {
		um.updateByPrimaryKey(u);
		return um.selectByPrimaryKey(u.getAid());
	}
	@Override
	public UserAddress queryByaid(Integer aid) {
		return um.selectByPrimaryKey(aid);
	}

	
}
