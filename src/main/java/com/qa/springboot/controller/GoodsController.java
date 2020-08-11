package com.qa.springboot.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.springboot.pojo.Goodsimage;
import com.qa.springboot.pojo.Goodsinfo;
import com.qa.springboot.pojo.Goodssize;
import com.qa.springboot.pojo.Storeinfo;
import com.qa.springboot.service.StoreService;
import com.qa.springboot.serviceImpl.GoodsServiceImpl;

@RestController
@RequestMapping("/goodsController")
public class GoodsController {

	@Autowired
	GoodsServiceImpl gi;
	@Autowired
	StoreService ss;
	
	
	@RequestMapping("/goodsimgs")
	public Map<String, Object> querygoods(Integer current){
		Map<String, Object> map= new HashMap<String, Object>();
		List<Goodsimage> list = gi.queryAllGoods(current);
		map.put("goodsimg", list);
		return map;
	}
	
	@RequestMapping("/goodsinfo")
	public Map<String, Object> goodsinfo(Integer gdid,Integer utid){
		Map<String, Object> map= new HashMap<String, Object>();
		Goodsinfo goods = gi.queryGoodsinfoByGdid(gdid);
		Integer stid = goods.getStid();
		Storeinfo store = ss.queryStoreinfo(stid);
		Double price = gi.queryPrice(gdid, utid);
		Double price1 = gi.queryPrice(gdid, 1);
		Goodsimage goodsimg = gi.queryGImg(gdid);
		map.put("goodsimg", goodsimg);
		map.put("goodsinfo", goods);
		map.put("storeinfo", store);
		map.put("price", price);
		map.put("price2", price1);
		return map;
	}
	
	@RequestMapping("/getsize")
	public Map<String, Object> getsize(){
		Map<String, Object> map= new HashMap<String, Object>();
		List<Goodssize> list = gi.getsize();
		map.put("size", list);
		return map;
	}
	@RequestMapping("/search")
	public Map<String, Object> search(String x,Integer utid,Integer stid){
		Map<String, Object> map= new HashMap<String, Object>();
		if(x==null){
			x="";
		}
//		商品详情集合
		List<Goodsinfo> goodslist=new ArrayList<>();
		if(stid==null){
			goodslist = gi.queryGoodsinfoLikeX(x);
		}else{
			goodslist=gi.queryGLikeXInStore(x, stid);
		}
//		关键词
		Set<String> key = new HashSet<String>();
		List<Object> list = new ArrayList<Object>();
		for (Goodsinfo goodsinfo : goodslist) {
			Map<String, Object> goods=new HashMap<String ,Object>();
//			商品id
			Integer gdid = goodsinfo.getGdid();
//			商品名称
			String gdname = goodsinfo.getGdname();
//			关键词
			String gtkeywords = goodsinfo.getGtkeywords();
			String[] split = gtkeywords.split(" ");
			for (String string : split) {
				key.add(string);
			}
//			折扣价
			Double price2 = gi.queryPrice(gdid, utid);
//			原价
			Double price1 = gi.queryPrice(gdid, 1);
//			图片地址
			String imgurl = gi.queryUrlBygdid(gdid);
			goods.put("gdid", gdid);
			goods.put("gdname", gdname);
			goods.put("price1", price1);
			goods.put("price2", price2);
			goods.put("imgurl", imgurl);
			goods.put("keywords", split);
			list.add(goods);
		}
		map.put("key", key);
		map.put("list", list);
		return map;
	}
}
