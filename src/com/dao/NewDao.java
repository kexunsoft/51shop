package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.News;
import com.tools.DBhelper;



public class NewDao {
	public static ArrayList<News> serichAllNews() {
		String sql="select top 12 * from News order by en_create_time desc";
		DBhelper baseDao=new DBhelper();
		ResultSet rs = baseDao.find(sql);
		ArrayList<News> list=new ArrayList<News>();
		try {
			while (rs.next()) {
				News news=new News(rs.getString("en_id"),rs.getString("en_title"),rs.getString("en_content"),rs.getString("en_create_time"));	
				list.add(news);
				}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			baseDao.close();
		}
		return list;
	}
	public static ArrayList<News> serichByAllNews() {
		String sql="select  * from News order by en_create_time desc";
		DBhelper baseDao=new DBhelper();
		ResultSet rs = baseDao.find(sql);
		ArrayList<News> list=new ArrayList<News>();
		try {
			while (rs.next()) {
				News news=new News(rs.getString("en_id"),rs.getString("en_title"),rs.getString("en_content"),rs.getString("en_create_time"));	
				list.add(news);
				}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			baseDao.close();
		}
		return list;
	}
	public static News serichNewsByID(String id) {
		String sql="select * from News where en_id=?";
		DBhelper baseDao=new DBhelper();
		ResultSet rs = baseDao.find(sql,id);
		News news=null;
		try {
			if(rs.next()) {
				news=new News(rs.getString("en_id"),rs.getString("en_title"),rs.getString("en_content"),rs.getString("en_create_time"));	
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			baseDao.close();
		}
		return news;
	}
	public static boolean newsAdd(News n) {
		String sql="insert into News values(?,?,GETDATE())";
		DBhelper dBhelper=new DBhelper();
		boolean b = dBhelper.Update(sql,n.getEn_title(),n.getEn_content());
		return b;
		
	}
	public static boolean updateNewsByID(News n) {
		String sql="update News set en_title=?,en_content=? where en_id=?";
		DBhelper dBhelper=new DBhelper();
		boolean b = dBhelper.Update(sql,n.getEn_title(),n.getEn_content(),n.getEn_id());
		return b;
	}
	public static boolean delNewsByID(String id) {
		String sql="delete News where en_id=?";
		DBhelper dBhelper=new DBhelper();
		boolean b = dBhelper.Update(sql,id);
		return b;
	}
}
