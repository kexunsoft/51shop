package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.Comment;
import com.tools.DBhelper;



public class CommentDao {
	//查询所有留言
	public static ArrayList<Comment> serichAllComment() {
		String sql="select * from comment";
		DBhelper baseDao=new DBhelper();
		ResultSet rs = baseDao.find(sql);
		ArrayList<Comment> list=new ArrayList<Comment>();
		try {
			while (rs.next()) {
				Comment c=new Comment(rs.getString("ec_id"),rs.getString("ec_reply"),rs.getString("ec_content"),rs.getString("ec_create_time"),rs.getString("ec_reply_time"),rs.getString("ec_nick_name"));
				list.add(c);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			baseDao.close();
		}
		return list;
	}
	//添加留言
	public static boolean addComment(Comment c) {
		String sql="insert into comment(ec_content,ec_create_time,ec_nick_name) values(?,?,?)";
		DBhelper baseDao=new  DBhelper();
		boolean b = baseDao.Update(sql,c.getEc_content(),c.getEc_create_time(),c.getEc_nick_name());
		return b;
	}
	public static boolean updateComment(String id,String reply) {
		String sql="update comment set ec_reply=?,ec_reply_time=GETDATE() where ec_id=?";
		DBhelper baseDao=new  DBhelper();
		boolean b = baseDao.Update(sql,reply,id);
		return b;
	}
	public static boolean deleteComment(String id) {
		String sql="delete comment where ec_id=?";
		DBhelper baseDao=new  DBhelper();
		boolean b = baseDao.Update(sql,id);
		return b;
	}
}
