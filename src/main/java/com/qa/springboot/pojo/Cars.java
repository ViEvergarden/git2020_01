package com.qa.springboot.pojo;

import org.springframework.stereotype.Component;

@Component
public class Cars {
	private Cart cart;
	private Goodsinfo goodsinfo;
	private String storename; 
	private String imgName; 
	private Integer storeid; 
	private Double price1;
	private Double price;
	private boolean checked;

	public Cars() {
		// TODO Auto-generated constructor stub
	}


	public Cart getCart() {
		return cart;
	}


	public void setCart(Cart cart) {
		this.cart = cart;
	}


	public Goodsinfo getGoodsinfo() {
		return goodsinfo;
	}


	public void setGoodsinfo(Goodsinfo goodsinfo) {
		this.goodsinfo = goodsinfo;
	}


	public String getStorename() {
		return storename;
	}


	public void setStorename(String storename) {
		this.storename = storename;
	}


	public String getImgName() {
		return imgName;
	}


	public void setImgName(String imgName) {
		this.imgName = imgName;
	}


	public Integer getStoreid() {
		return storeid;
	}


	public void setStoreid(Integer storeid) {
		this.storeid = storeid;
	}


	public Double getPrice1() {
		return price1;
	}


	public void setPrice1(Double price1) {
		this.price1 = price1;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "Cars [cart=" + cart + ", goodsinfo=" + goodsinfo + ", storename=" + storename + ", imgName=" + imgName
				+ ", storeid=" + storeid + ", price1=" + price1 + ", price=" + price + ", checked=" + checked + "]";
	}


	public Cars(Cart cart, Goodsinfo goodsinfo, String storename, String imgName, Integer storeid, Double price1,
			Double price, boolean checked) {
		super();
		this.cart = cart;
		this.goodsinfo = goodsinfo;
		this.storename = storename;
		this.imgName = imgName;
		this.storeid = storeid;
		this.price1 = price1;
		this.price = price;
		this.checked = checked;
	}


	public boolean isChecked() {
		return checked;
	}


	public void setChecked(boolean checked) {
		this.checked = checked;
	}




}
