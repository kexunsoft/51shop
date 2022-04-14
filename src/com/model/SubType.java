package com.model;

public class SubType {
	private String ID;
	private String superType;
	private String TypeName;
	public SubType(String iD, String superType, String typeName) {
		
		this.ID = iD;
		this.superType = superType;
		this.TypeName = typeName;
	}
	public SubType(String superType, String typeName) {
		
		this.superType = superType;
		this.TypeName = typeName;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getSuperType() {
		return superType;
	}
	public void setSuperType(String superType) {
		this.superType = superType;
	}
	public String getTypeName() {
		return TypeName;
	}
	public void setTypeName(String typeName) {
		TypeName = typeName;
	}
	
}
