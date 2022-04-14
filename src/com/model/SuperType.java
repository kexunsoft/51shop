package com.model;

public class SuperType {
	private	String ID;
	private String TypeName;
	public SuperType() {
	}
	
	public SuperType(String iD, String typeName) {
		super();
		ID = iD;
		TypeName = typeName;
	}

	public SuperType(String typeName) {
		super();
		TypeName = typeName;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getTypeName() {
		return TypeName;
	}
	public void setTypeName(String typeName) {
		TypeName = typeName;
	}
	
}
