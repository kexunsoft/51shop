package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.Evaluate;
import com.tools.DBhelper;

public class EvaluateDao {
	//添加评价
	public static boolean addEvaluate(Evaluate e) {
		String sql="insert into dbo.evaluate([type],f_text,pid,username,[date]) values(?,?,?,?,GETDATE())";
		DBhelper dBhelper=new DBhelper();
		boolean b = dBhelper.Update(sql,e.getType(),e.getF_text(),e.getPid(),e.getUsername());
		return b;
	}
	//查询评价
	public static ArrayList<Evaluate> serichEvaluate(String pid) {
		String sql="select* from evaluate where pid=? order by date desc";
		DBhelper dBhelper=new DBhelper();
		ResultSet rs = dBhelper.find(sql,pid);
		ArrayList<Evaluate> list=new ArrayList<Evaluate>();
		try {
			while (rs.next()) {
				Evaluate evaluate=new Evaluate(rs.getString("id"),rs.getString("type"),rs.getString("f_text"),rs.getString("l_text"),rs.getString("pid"),rs.getString("username"),rs.getString("date"));
				list.add(evaluate);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			dBhelper.close();
		}
		return list;
	}
	//修改评价
	public static boolean updateEvaluate(String text,String pid,String username) {
		boolean b = false;
		String sql="update evaluate set l_text=? where pid=? and username=?";
		DBhelper dBhelper=new DBhelper();
		b = dBhelper.Update(sql,text,pid,username);
		return b;
	}
	//查询评价数量
	public static int serichCount() {
		String sql="select COUNT(*) as 'count' from evaluate";
		DBhelper dBhelper=new DBhelper();
		ResultSet rs = dBhelper.find(sql);
		int i=0;
		try {
			if (rs.next()) {
				i=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			dBhelper.close();
		}
		return i;
	}
}
