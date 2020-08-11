package com.qa.springboot.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.springboot.pojo.Cart;
import com.qa.springboot.pojo.Goodsinfo;
import com.qa.springboot.pojo.Storeinfo;
import com.qa.springboot.service.CarService;
import com.qa.springboot.service.GoodsService;
import com.qa.springboot.service.StoreService;
import com.qa.springboot.service.UserService;
import com.qa.springboot.service.Userinfoservice;
import com.qa.springboot.pojo.Cars;
import com.qa.springboot.serviceImpl.CarServiceImpl;
import com.qa.springboot.serviceImpl.GoodsServiceImpl;
import com.qa.springboot.serviceImpl.UserServiceImpl;
import com.qa.springboot.serviceImpl.UserinfoServiceImpl;

@RequestMapping("/carController")
@RestController
public class CarController {

	@Autowired
	CarService cs;
	@Autowired
	GoodsService gs;
	@Autowired
	UserService us;
	@Autowired
	Userinfoservice uis;
	@Autowired
	StoreService ss;
	
	@RequestMapping("/addCar")
	public Map<String, Object> addcar(Cart cart){
		Map<String, Object> map =new HashMap<String ,Object>();
		
		List<Cart> list = cs.queryByGdidAndUid(cart.getGdid(), cart.getUserid(),cart.getGsid());
		if(list.size()>0){
			//有
			Cart cart1 = list.get(0);
			Integer gdcount = cart.getGdcount();
			Integer gdcount2 = cart1.getGdcount();
			int newcount=gdcount+gdcount2;
			cart1.setGdcount(newcount);
			cs.update(cart1);
		}else{
//			没有
			cs.addCar(cart);
		}
		Integer userid = cart.getUserid();
		List<Cart> list1 = cs.querycar(userid);
		map.put("cars", list1);
		return map;
	}
	
	@RequestMapping("/querycar")
	public Map<String, Object> querycar(Integer userid){
		Map<String, Object> maps=new HashMap<String, Object>();
		Map<String, List<Cars>> map=new HashMap<String, List<Cars>>();
//		查询该用户所有购物车
		List<Cart> list = cs.querycar(userid);
		int allcount=0;
//		遍历
		for (Cart cart : list) {
//			获得商品id
			Integer gdid = cart.getGdid();
//			获得商品对象
			Goodsinfo goodsinfo = gs.queryGoodsinfoByGdid(gdid);
//			获得店铺id
			Integer storeid = goodsinfo.getStid();
//			获得店铺对象
			Storeinfo store = ss.queryByStid(storeid);
//			获得店铺名字
			String storename = store.getStname();
//			获得图片路径
			String imgName = gs.queryUrlBygdid(gdid);
//			查询用户等级
			Integer utid = us.queryUtidByUid(userid);
//			获取价格
			double price = gs.queryPrice(gdid, utid);
			double price1 = gs.queryPrice(gdid, 1);
			
			Cars cars=new Cars(cart, goodsinfo, storename, imgName, storeid, price1, price, false);
//			查询是否有商店集合
			List<Cars> obj =map.get(storename);
			if(obj==null){
//				没有新建集合，放入map
				List<Cars> listofcars= new ArrayList<Cars>();
				listofcars.add(cars);
				map.put(storename, listofcars);
			
			}else{
//				有，将商品放入
				obj.add(cars);
			}
			
			allcount+=cart.getGdcount();
			
		}
		maps.put("allcount", allcount);
		maps.put("map", map);
		return maps;
	}
//	加
	@RequestMapping("/add")
	public void add(Integer ctid){
		Cart cart = cs.queryByCtid(ctid);
		Integer gdcount = cart.getGdcount();
		cart.setGdcount(gdcount+1);
		cs.update(cart);
	}
//	减
	@RequestMapping("/reduce")
	public void reduce(Integer ctid){
		Cart cart = cs.queryByCtid(ctid);
		Integer gdcount = cart.getGdcount();
		cart.setGdcount(gdcount-1);
		cs.update(cart);
	}
	
	@RequestMapping("/delCar")
	public void delCar(Integer ctid){
//		cs.delCart(ctid);
	}
}
