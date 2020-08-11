package com.qa.springboot.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.springboot.mapper.GoodsimageMapper;
import com.qa.springboot.mapper.GoodsinfoMapper;
import com.qa.springboot.mapper.GoodspriceMapper;
import com.qa.springboot.mapper.GoodssizeMapper;
import com.qa.springboot.mapper.StoreinfoMapper;
import com.qa.springboot.pojo.Goodsimage;
import com.qa.springboot.pojo.GoodsimageExample;
import com.qa.springboot.pojo.Goodsinfo;
import com.qa.springboot.pojo.Goodsprice;
import com.qa.springboot.pojo.GoodspriceExample;
import com.qa.springboot.pojo.GoodspriceExample.Criteria;
import com.qa.springboot.pojo.Goodssize;
import com.qa.springboot.service.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	GoodsimageMapper gm;
	@Autowired
	GoodsinfoMapper gi;
	@Autowired
	GoodspriceMapper gpm;
	@Autowired
	GoodssizeMapper gsm;
	@Autowired
	StoreinfoMapper sm;
	
	
	@Override
	public List<Goodsimage> queryAllGoods(int current) {
		return gm.limitBycurrent(current);
		
	}
	@Override
	public Goodsinfo queryGoodsinfoByGdid(Integer gdid) {
		
		return gi.selectByPrimaryKey(gdid);
	}
	@Override
	public double queryPrice(Integer gdid, Integer utid) {
		GoodspriceExample ge = new GoodspriceExample();
		Criteria c = ge.createCriteria();
		c.andGdidEqualTo(gdid).andUtidEqualTo(utid);
		List<Goodsprice> list = gpm.selectByExample(ge);
		return list.get(0).getPrice();
	}
	@Override
	public List<Goodssize> getsize() {
		return gsm.selectByExample(null);
	}
	@Override
	public String queryUrlBygdid(Integer gdid) {
		GoodsimageExample ge = new GoodsimageExample();
		com.qa.springboot.pojo.GoodsimageExample.Criteria c = ge.createCriteria();
		c.andGdidEqualTo(gdid);
		return gm.selectByExample(ge).get(0).getGimgurl();
	}
	@Override
	public String querygname(Integer gdid) {
		return gi.selectByPrimaryKey(gdid).getGdname();
	}
	@Override
	public String querysname(Integer gdid) {
		Integer stid = gi.selectByPrimaryKey(gdid).getStid();
		return sm.selectByPrimaryKey(stid).getStname();
	}
	@Override
	public List<Goodsinfo> queryGoodsinfoLikeX(String x) {
		return gi.selectLikex(x);
	}
	@Override
	public Goodsimage queryGImg(Integer gdid) {
		return gm.selectGimgByGdid(gdid);
	}
	@Override
	public List<Goodsinfo> queryGLikeXInStore(String x, Integer stid) {
		
		return gi.selectByStidAndLikedx(x, stid);
	}

}
