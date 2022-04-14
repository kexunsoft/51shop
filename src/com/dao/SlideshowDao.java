package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.Slideshow;
import com.tools.DBhelper;

public class SlideshowDao {
	//插入轮播图
	public static boolean addSlideshow(Slideshow s) {
		String sql="insert into slideshow values(?,?,?)";
		DBhelper dBhelper=new DBhelper();
		boolean b = dBhelper.Update(sql,s.getTitle(),s.getImg(),s.getHref());
		return b;
	}
	//查询所有轮播图
	public static ArrayList<Slideshow> serichAllSlideshow() {
		String sql="select * from dbo.slideshow";
		DBhelper dBhelper=new DBhelper();
		ResultSet rs = dBhelper.find(sql);
		ArrayList<Slideshow> list=new ArrayList<Slideshow>();
		try {
			while(rs.next()) {
				Slideshow slideshow=new Slideshow(rs.getString("id"),rs.getString("title"),rs.getString("img"),rs.getString("href"));
				list.add(slideshow);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			dBhelper.close();
		}
		return list;
	}
	//根据id查轮播图
	public static Slideshow serichSlideshowByID(String id) {
		String sql="select * from dbo.slideshow where id=?";
		DBhelper dBhelper=new DBhelper();
		ResultSet rs = dBhelper.find(sql,id);
		Slideshow slideshow=null;
		try {
			if(rs.next()) {
				 slideshow=new Slideshow(rs.getString("id"),rs.getString("title"),rs.getString("img"),rs.getString("href"));
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			dBhelper.close();
		}
		return slideshow;
	}
	//修改轮播图
	public static boolean updateSlideshow(Slideshow s) {
		String sql="update slideshow set title=?,img=?,href=? where id=?";
		DBhelper dBhelper=new DBhelper();
		boolean b = dBhelper.Update(sql,s.getTitle(),s.getImg(),s.getHref(),s.getId());
		return b;
	}
	//删除轮播图
	public static boolean delSlideshow(String id) {
		String sql="delete slideshow where id=?";
		DBhelper dBhelper=new DBhelper();
		boolean b = dBhelper.Update(sql,id);
		return b;
	}
}
