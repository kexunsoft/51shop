package com.model;

public class Menage {
	private String id;
	private String manage;
	private String pwd;
	public Menage() {
		// TODO 自动生成的构造函数存根
	}
	public Menage( String manage, String pwd) {
		
		this.manage = manage;
		this.pwd = pwd;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getManage() {
		return manage;
	}
	public void setManage(String manage) {
		this.manage = manage;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
