package com.model;

public class Order {
	private String	OrderID;
	private String	bnmunber;
	private String	username;
	private String	recevieName;
	private String	address;
	private String	tel;
	private String	OrderDate;
	private String	bz;
	public Order() {
		// TODO 自动生成的构造函数存根
	}
	
	public Order(String orderID, String bnmunber, String username, String recevieName, String address, String tel,
			String bz) {
		
		OrderID = orderID;
		this.bnmunber = bnmunber;
		this.username = username;
		this.recevieName = recevieName;
		this.address = address;
		this.tel = tel;
		this.bz = bz;
	}

	public String getOrderID() {
		return OrderID;
	}
	public void setOrderID(String orderID) {
		OrderID = orderID;
	}
	public String getBnmunber() {
		return bnmunber;
	}
	public void setBnmunber(String bnmunber) {
		this.bnmunber = bnmunber;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRecevieName() {
		return recevieName;
	}
	public void setRecevieName(String recevieName) {
		this.recevieName = recevieName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getOrderDate() {
		return OrderDate;
	}
	public void setOrderDate(String orderDate) {
		OrderDate = orderDate;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	
}
