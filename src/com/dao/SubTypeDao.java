package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.SubType;

import com.tools.DBhelper;

public class SubTypeDao  {
	public static ArrayList<SubType> serichAllSubType() {
		String sql="select t1.*,t2.TypeName as sTypeName from dbo.tb_subType t1 left join dbo.tb_superType t2 on t1.superType=t2.ID";
		DBhelper db=new DBhelper();
		ResultSet rs = db.find(sql);
		if (rs==null) {
			return null;
		}
		ArrayList<SubType> list=new ArrayList<SubType>();
		try {
		
			while (rs.next()) {
				SubType subType=new SubType(rs.getString("ID"),rs.getString("sTypeName"),rs.getString("TypeName"));
			list.add(subType);
			}
		} catch (SQLException e) {
			list=null;
			e.printStackTrace();
		}
		return list;
	}
	
	public static boolean delSubType(String ID) {
		DBhelper db=new DBhelper();
		String sql="delete from tb_subType where ID=?";
		boolean b = db.Update(sql,ID);
		return b;
	}
	public static boolean addSubType(String sID, String tName) {
		DBhelper db=new DBhelper();
		String sql="insert into dbo.tb_subType values(?,?)";
		boolean b = db.Update(sql,sID,tName);
		return b;
	}
	
}
