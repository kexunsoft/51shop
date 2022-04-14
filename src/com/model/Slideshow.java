package com.model;

public class Slideshow {
	private String id;
	private String title;
	private String img;
	private String href;
	
	public Slideshow(String title, String img, String href) {
		super();
		this.title = title;
		this.img = img;
		this.href = href;
	}
	public Slideshow(String id, String title, String img, String href) {
		super();
		this.id = id;
		this.title = title;
		this.img = img;
		this.href = href;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	
}
