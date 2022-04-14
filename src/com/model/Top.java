package com.model;

public class Top {
	private String goodsName;
	private String num;
	
	public Top() {
		super();
	}
	public Top(String goodsName, String num) {
		super();
		this.goodsName = goodsName;
		this.num = num;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
}
