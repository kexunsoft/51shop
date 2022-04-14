package com.model;

public class OrderDetail {
	private String ID ;
	private String orderID ;
	private String goodeID;
	private String price ;
	private String number;
	private int status;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public OrderDetail(String orderID, String goodeID, String price, String number) {
		super();
		this.orderID = orderID;
		this.goodeID = goodeID;
		this.price = price;
		this.number = number;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public String getGoodeID() {
		return goodeID;
	}
	public void setGoodeID(String goodeID) {
		this.goodeID = goodeID;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
}
