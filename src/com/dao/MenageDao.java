package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Menage;
import com.tools.DBhelper;

public class MenageDao {
	
	//登录
	public static Menage serichMenageByIdAndPwd(String manager,String PWD) {
		String sql=" select * from tb_manger where manager=? and PWD=?";
		DBhelper db=new DBhelper();
		ResultSet rs = db.find(sql,manager,PWD);
		if (rs==null) {
			return null;
		}
		Menage menage=null;
		try {
			if (rs.next()) {
				menage=new Menage(rs.getString("manager"),rs.getString("PWD"));
			}else {
				menage=null;
			}
		} catch (SQLException e) {
			menage=null;
			e.printStackTrace();
		}
		return menage;
	}
}
