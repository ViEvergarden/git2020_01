package com.qa.springboot.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.springboot.pojo.Orderinfo;
import com.qa.springboot.pojo.Orderlist;
import com.qa.springboot.service.CarService;
import com.qa.springboot.service.GoodsService;
import com.qa.springboot.service.OrderService;

@RequestMapping("/orderController")
@RestController
public class OrderController {
	
	@Autowired
	OrderService os;
	@Autowired
	CarService cs;
	@Autowired
	GoodsService gs;
	
//	添加订单详情
	@RequestMapping("/addorderinfo")
	public void addorderinfo(Orderinfo orderinfo){
		System.out.println(orderinfo);
		os.addOrderinfo(orderinfo);
	}
	
//	添加订单列表
	@RequestMapping("/addorderlist")
	public void addorderlist(Orderlist orderlist,Integer ctid){
		String olid="OLID"+Math.ceil(Math.random()*1000000);
		orderlist.setOlid(olid);
		os.addOrderlist(orderlist);
	}
//	查询全部
	@RequestMapping("/queryall")
	public Map<String, Object> queryall(Integer userid){
//		传回前端的map
		Map<String, Object> map=new HashMap<String, Object>();
//		存放orderinfo的map
		Map<String, Object> mapiinfo=new HashMap<String, Object>();
//		存放ordelisto的map
		Map<String, Object> mapilist=new HashMap<String, Object>();
		
		
//		查询所有订单详情
		List<Orderinfo> infolist = os.queryInfoByuid(userid);
//		遍历订单详情
		for (Orderinfo orderinfo : infolist) {
			Map<String, Object> forinfo=new HashMap<String, Object>();
			List<Object> forlist=new ArrayList<Object>();
//			获取订单编号
			String ofid = orderinfo.getOfid();
//			获取订单时间
			Date ofdate = orderinfo.getOfdate();
//			获取订单状态
			Integer ofstate = orderinfo.getOfstate();
//			定义总价
			Double Totalprice=0.0;
//			获取订单列表
			List<Orderlist> ilist = os.queryListByOfid(ofid);
//			遍历订单列表
			for (Orderlist orderlist : ilist) {
				Map<String, Object> olist=new HashMap<String, Object>();
//				获取商品id
				Integer gdid = orderlist.getGdid();
//				获取小计
				Double subtotal = orderlist.getPrice();
//				计算总价
				Totalprice+=subtotal;
//				获取数量
				Integer gdcount = orderlist.getGdcount();
//				获取折扣价
				Double price1 =subtotal/gdcount;
//				获取商品名称
				String goodsname = gs.querygname(gdid);
//				获取原价
				Double price = gs.queryPrice(gdid, 1);
//				获取图片地址
				String imgurl = gs.queryUrlBygdid(gdid);
//				获取店铺id
				String storename = gs.querysname(gdid);
//				获取商品尺寸id
				Integer gsid = orderlist.getGsid();
				olist.put("subtotal", subtotal);
				olist.put("gdcount", gdcount);
				olist.put("price1", price1);
				olist.put("goodsname", goodsname);
				olist.put("price", price);
				olist.put("imgurl", imgurl);
				olist.put("gsid", gsid);
				olist.put("storename", storename);
				forlist.add(olist);
			}
			forinfo.put("ofdate", ofdate);
			forinfo.put("ofstate", ofstate);
			forinfo.put("Totalprice", Totalprice);
			
			mapiinfo.put(ofid, forinfo);
			mapilist.put(ofid, forlist);
			
		}
		map.put("orderinfo",mapiinfo);
		map.put("orderlist", mapilist);
		return map;
	}

}
