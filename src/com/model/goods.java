package com.model;

public class goods {
	public goods() {
		// TODO 自动生成的构造函数存根
	}
	
	public goods(int iD, String typeID, String goodsName, String introduce, double price, double nowPrice,
			String picture, String newGoods, String sale) {
		super();
		ID = iD;
		this.typeID = typeID;
		this.goodsName = goodsName;
		this.introduce = introduce;
		this.price = price;
		this.nowPrice = nowPrice;
		this.picture = picture;
		this.newGoods = newGoods;
		this.sale = sale;
	}

	public goods(String typeID, String goodsName, String introduce, double nowPrice, String picture, String newGoods,
			String sale) {
		super();
		this.typeID = typeID;
		this.goodsName = goodsName;
		this.introduce = introduce;
		this.nowPrice = nowPrice;
		this.picture = picture;
		this.newGoods = newGoods;
		this.sale = sale;
	}

	public goods(int iD, String goodsName, double nowPrice, String picture) {
		super();
		ID = iD;
		this.goodsName = goodsName;
		this.nowPrice = nowPrice;
		this.picture = picture;
	}

	private	int ID;
	private	String typeID;
	private	String typeName;
	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	private	String goodsName;
	private	String introduce;
	private	double price;
	private	double nowPrice;
	private	String picture;
	private	String INTime;
	private	String newGoods;
	private	String sale;
	private	String hit;
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getTypeID() {
		return typeID;
	}

	public void setTypeID(String typeID) {
		this.typeID = typeID;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getNowPrice() {
		return nowPrice;
	}

	public void setNowPrice(double nowPrice) {
		this.nowPrice = nowPrice;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getINTime() {
		return INTime;
	}

	public void setINTime(String iNTime) {
		INTime = iNTime;
	}

	public String getNewGoods() {
		return newGoods;
	}

	public void setNewGoods(String newGoods) {
		this.newGoods = newGoods;
	}

	public String getSale() {
		return sale;
	}

	public void setSale(String sale) {
		this.sale = sale;
	}

	public String getHit() {
		return hit;
	}

	public void setHit(String hit) {
		this.hit = hit;
	}
	
}
