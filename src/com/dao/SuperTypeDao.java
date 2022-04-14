package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.SubType;
import com.model.SuperType;
import com.tools.DBhelper;

public class SuperTypeDao {
	public static ArrayList<SuperType> serichAllSuperType() {
		//查询所有大类型
		String sql=" select * from tb_superType";
		DBhelper db=new DBhelper();
		ResultSet rs = db.find(sql);
		ArrayList<SuperType> list=new ArrayList<SuperType>();
		try {
			while (rs.next()) {
				SuperType st=new SuperType(rs.getString("ID"),rs.getString("TypeName"));
				list.add(st);
			}
		} catch (SQLException e) {
			list=null;
			e.printStackTrace();
		}
		return list;
		
	}
	public static SuperType serichTypeByID(String ID) {
		String sql="select * from tb_superType where ID=?";
		DBhelper db=new DBhelper();
		ResultSet rs = db.find(sql,ID);
		SuperType st=null;
		try {
			if (rs.next()) {
				 st=new SuperType(rs.getString("ID"),rs.getString("TypeName"));
			}
		} catch (SQLException e) {
			st=null;
			e.printStackTrace();
		}
		return st;
	}
	public static boolean addSuperType(String typeName) {
		String sql="insert into dbo.tb_superType values(?)";
		DBhelper dBhelper=new DBhelper();
		boolean b = dBhelper.Update(sql,typeName);
		return b;
	}
	public static boolean delSuperType(String ID) {
		String sql="delete from tb_superType where ID=?";
		DBhelper dBhelper=new DBhelper();
		boolean b = dBhelper.Update(sql,ID);
		return b;
	}
}
