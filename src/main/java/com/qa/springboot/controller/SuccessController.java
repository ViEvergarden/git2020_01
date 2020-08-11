package com.qa.springboot.controller;


import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONObject;
import com.qa.springboot.pojo.Orderinfo;
import com.qa.springboot.pojo.Orderlist;
import com.qa.springboot.service.CarService;
import com.qa.springboot.service.OrderService;

@Controller
@RequestMapping("/success")
public class SuccessController {
	@Autowired
	OrderService os;
	@Autowired
	CarService cs;

	@RequestMapping("/pay")
	public String success(@RequestParam("out_trade_no")String ofid){
		Orderinfo info = os.queryInfoByOfid(ofid);
		info.setOfstate(1);
		List<Orderlist> ilist = os.queryListByOfid(ofid);
		for (Orderlist orderlist : ilist) {	
//			cs.delByGFdidUidGsid(orderlist.getGdid(), info.getUserid(),orderlist.getGsid());
		}
		return "redirect:http://localhost:8080/#/order";
	}
	
//	@RequestMapping("/doPostGetJson")
//	public String doPostGetJson() throws ParseException {
//	   //此处将要发送的数据转换为json格式字符串
//	   String jsonText = "{id：1}";
//	   JSONObject json = (JSONObject) JSONObject.parse(jsonText);
//	   JSONObject sr = this.doPost(json);
//	   System.out.println("返回参数：" + sr);
//	   return sr.toString();
//	}
//
//	public static JSONObject doPost(JSONObject date) {
//	   HttpClient client = HttpClients.createDefault();
//	   // 要调用的接口方法
//	   String url = "http://192.168.1.101:8080/getJson";
//	   HttpPost post = new HttpPost(url);
//	   JSONObject jsonObject = null;
//	   try {
//	      StringEntity s = new StringEntity(date.toString());
//	      s.setContentEncoding("UTF-8");
//	      s.setContentType("application/json");
//	      post.setEntity(s);
//	      post.addHeader("content-type", "text/xml");
//	      HttpResponse res = client.execute(post);
//	      String response1 = EntityUtils.toString(res.getEntity());
//	      System.out.println(response1);
//	      if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
//	         String result = EntityUtils.toString(res.getEntity());// 返回json格式：
//	         jsonObject = JSONObject.parseObject(result);
//	      }
//	   } catch (Exception e) {
//	      throw new RuntimeException(e);
//	   }
//	   return jsonObject;
//	}
}



