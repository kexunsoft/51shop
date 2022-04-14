package com.model;

public class Evaluate {
	private String id;
	private String type;
	private String f_text;
	private String l_text;
	private String pid;
	private String username;
	private String date;
	
	public Evaluate(String type, String f_text, String pid, String username) {
		super();
		this.type = type;
		this.f_text = f_text;
		this.pid = pid;
		this.username = username;
		
	}
	public Evaluate(String id, String type, String f_text, String l_text, String pid, String username, String date) {
		super();
		this.id = id;
		this.type = type;
		this.f_text = f_text;
		this.l_text = l_text;
		this.pid = pid;
		this.username = username;
		this.date = date;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getF_text() {
		return f_text;
	}
	public void setF_text(String f_text) {
		this.f_text = f_text;
	}
	public String getL_text() {
		return l_text;
	}
	public void setL_text(String l_text) {
		this.l_text = l_text;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
