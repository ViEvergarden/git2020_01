package com.qa.springboot.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.springboot.mapper.StoreinfoMapper;
import com.qa.springboot.pojo.Storeinfo;
import com.qa.springboot.service.StoreService;

@Service
public class StoreServiceImpl implements StoreService{
	
	@Autowired
	StoreinfoMapper sm;
	
	@Override
	public Storeinfo queryByStid(Integer stid) {
		return sm.selectByPrimaryKey(stid);
	}
	@Override
	public Storeinfo queryStoreinfo(Integer gtid) {
		return sm.selectByPrimaryKey(gtid);
	}

}
