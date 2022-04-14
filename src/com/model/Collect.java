package com.model;

public class Collect {
	private String id;
	private String uid;
	private String pid;
	private String name;
	private String pctrue;
	private String price;
	
	public Collect(String id, String pid, String name, String pctrue, String price) {
		super();
		this.id = id;
		this.pid = pid;
		this.name = name;
		this.pctrue = pctrue;
		this.price = price;
	}

	public Collect(String id, String uid, String pid) {
		super();
		this.id = id;
		this.uid = uid;
		this.pid = pid;
	}
	
	public Collect(String uid, String pid) {
		super();
		this.uid = uid;
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPctrue() {
		return pctrue;
	}

	public void setPctrue(String pctrue) {
		this.pctrue = pctrue;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	
}
