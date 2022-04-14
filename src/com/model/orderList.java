package com.model;

public class orderList {
	private int did;
	private String orderID;
	private String goodName;
	private String goodnumber;
	private String price;
	private String recevieName;
	private String tel;
	private String orderDate;
	private int status;
	private String orderNumber;
	private String goodsID;
	
	public String getGoodsID() {
		return goodsID;
	}



	public void setGoodsID(String goodsID) {
		this.goodsID = goodsID;
	}



	public String getOrderNumber() {
		return orderNumber;
	}



	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}



	public int getDid() {
		return did;
	}



	public void setDid(int did) {
		this.did = did;
	}



	public int getStatus() {
		return status;
	}



	public void setStatus(int status) {
		this.status = status;
	}

	

	public orderList(int did, String orderID, String goodName,String goodnumber, String recevieName, String tel, String orderDate,int status) {
		super();
		this.did=did;
		this.orderID = orderID;
		this.goodName = goodName;
		this.goodnumber = goodnumber;
		this.recevieName = recevieName;
		this.tel = tel;
		this.orderDate = orderDate;
		this.status=status;
	}

	
	
	public orderList(int did, String orderID, String goodName, String goodnumber, String price, String recevieName, String tel,
			String orderDate,int status,String orderNumber) {
		super();
		this.did=did;
		this.orderID = orderID;
		this.goodName = goodName;
		this.goodnumber = goodnumber;
		this.price = price;
		this.recevieName = recevieName;
		this.tel = tel;
		this.orderDate = orderDate;
		this.status=status;
		this.orderNumber=orderNumber;
	}
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public String getGoodName() {
		return goodName;
	}
	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}
	public String getGoodnumber() {
		return goodnumber;
	}
	public void setGoodnumber(String goodnumber) {
		this.goodnumber = goodnumber;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getRecevieName() {
		return recevieName;
	}
	public void setRecevieName(String recevieName) {
		this.recevieName = recevieName;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	
}
