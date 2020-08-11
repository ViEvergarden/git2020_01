package com.qa.springboot.service;

import java.util.List;

import com.qa.springboot.pojo.Orderinfo;
import com.qa.springboot.pojo.Orderlist;

public interface OrderService {
//	新增orderinfor
	public void addOrderinfo(Orderinfo orderinfo);
	
//	新增orderlist
	public void addOrderlist(Orderlist orderlist);
//	根据userid查询info
	public List<Orderinfo> queryInfoByuid(Integer userid);
//	根据ofid查询list
	public List<Orderlist> queryListByOfid(String ofid);
//	根据主键查询orderinfo
	public Orderinfo queryInfoByOfid(String ofid);
	
}
