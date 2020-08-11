package com.qa.springboot.service;

import com.qa.springboot.pojo.Storeinfo;

public interface StoreService {
//	根据店铺ID查询
	Storeinfo queryByStid(Integer stid);
	
//	根据商品查询店铺
	Storeinfo queryStoreinfo(Integer gtid);

}
