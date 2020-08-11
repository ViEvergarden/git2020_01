package com.qa.springboot.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.springboot.mapper.OrderinfoMapper;
import com.qa.springboot.mapper.OrderlistMapper;
import com.qa.springboot.pojo.Orderinfo;
import com.qa.springboot.pojo.OrderinfoExample;
import com.qa.springboot.pojo.OrderinfoExample.Criteria;
import com.qa.springboot.pojo.Orderlist;
import com.qa.springboot.pojo.OrderlistExample;
import com.qa.springboot.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderinfoMapper om;
	@Autowired
	OrderlistMapper olm;
	
	
	@Override
	public void addOrderinfo(Orderinfo orderinfo) {
		om.insert(orderinfo);
	}
	@Override
	public void addOrderlist(Orderlist orderlist) {
		olm.insert(orderlist);
	}
	@Override
	public List<Orderinfo> queryInfoByuid(Integer userid) {
		OrderinfoExample oie=new OrderinfoExample();
		Criteria c = oie.createCriteria();
		c.andUseridEqualTo(userid);
		return om.selectByExample(oie);
	}
	@Override
	public List<Orderlist> queryListByOfid(String ofid) {
		OrderlistExample ole=new OrderlistExample();
		ole.createCriteria().andOfidEqualTo(ofid);
		return olm.selectByExample(ole);
	}
	@Override
	public Orderinfo queryInfoByOfid(String ofid) {
		
		return om.selectByPrimaryKey(ofid);
	}

	
}
