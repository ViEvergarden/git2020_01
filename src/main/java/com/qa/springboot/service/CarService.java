package com.qa.springboot.service;

import java.util.List;

import com.qa.springboot.pojo.Cart;

public interface CarService {
//	添加购物车
	void addCar(Cart cart);
//	根据用户id查询购物车
	List<Cart> querycar(Integer userid);
//	查重
	List<Cart> queryByGdidAndUid(Integer gdid,Integer uid,Integer gsid);
//	修改
	void update(Cart cart);
//	根据ctid查询购物车
	Cart queryByCtid(Integer ctid);
//	根据ctid删除购物车
	void delCart(Integer ctid);
//	根据gus删除
	void delByGFdidUidGsid(Integer gdid,Integer uid,Integer gsid);
}
