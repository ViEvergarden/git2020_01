package com.qa.springboot.service;

import java.util.List;

import com.qa.springboot.pojo.Goodsimage;
import com.qa.springboot.pojo.Goodsinfo;
import com.qa.springboot.pojo.Goodssize;

public interface GoodsService {
//	查询所有商品
	List<Goodsimage> queryAllGoods(int current);
//	根据商品id查询商品对象
	Goodsinfo queryGoodsinfoByGdid(Integer gdid);
//	根据商品id和用户等级查询价格
	double queryPrice(Integer gdid,Integer utid);
//	获取所有尺寸
	List<Goodssize> getsize();
//	根据商品id查询图片对象
	Goodsimage queryGImg(Integer gdid);
//	根据商品ID查询图片地址
	String queryUrlBygdid(Integer gdid);
//	根据商品id查询商品名称
	String querygname(Integer gdid);
//	根据商品id查询店铺名称
	String querysname(Integer gdid);
//	模糊查询
	List<Goodsinfo> queryGoodsinfoLikeX(String x);
//	店内模糊查询
	List<Goodsinfo> queryGLikeXInStore(String x,Integer stid);
}
