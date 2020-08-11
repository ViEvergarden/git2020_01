package com.qa.springboot.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.springboot.mapper.CartMapper;
import com.qa.springboot.pojo.Cart;
import com.qa.springboot.pojo.CartExample;
import com.qa.springboot.pojo.CartExample.Criteria;
import com.qa.springboot.service.CarService;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	CartMapper cm;
	
	@Override
	public void addCar(Cart cart) {
		cm.insert(cart);
	}

	@Override
	public List<Cart> querycar(Integer userid) {
		CartExample ce=new CartExample();
		Criteria c = ce.createCriteria();
		c.andUseridEqualTo(userid);
		List<Cart> list = cm.selectByExample(ce);
		return list;
	}

	@Override
	public List<Cart> queryByGdidAndUid(Integer gdid, Integer uid,Integer gsid) {
		CartExample ce=new CartExample();
		Criteria c = ce.createCriteria();
		c.andUseridEqualTo(uid).andGdidEqualTo(gdid).andGsidEqualTo(gsid);
		List<Cart> list = cm.selectByExample(ce);
		return list;
	}

	@Override
	public void update(Cart cart) {
		cm.updateByPrimaryKey(cart);
	}

	@Override
	public Cart queryByCtid(Integer ctid) {
		return cm.selectByPrimaryKey(ctid);
	}

	@Override
	public void delCart(Integer ctid) {
		cm.deleteByPrimaryKey(ctid);
		
	}

	@Override
	public void delByGFdidUidGsid(Integer gdid, Integer uid, Integer gsid) {
		CartExample ce=new CartExample();
		Criteria c = ce.createCriteria();
		c.andUseridEqualTo(uid).andGdidEqualTo(gdid).andGsidEqualTo(gsid);
		cm.deleteByExample(ce);
		
	}






}
