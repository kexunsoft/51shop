package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.Collect;
import com.tools.DBhelper;

public class CollectDao {
	//添加收藏
	public static boolean addcollect(Collect c) {
		String sql="insert into collect([uid],pid) values(?,?)";
		DBhelper dBhelper=new DBhelper();
		boolean b = dBhelper.Update(sql,c.getUid(),c.getPid());
		return b;
	}
	//查询收藏
	public static ArrayList<Collect> serichCollect(int uid) {
		String sql="select t1.id, t2.id as 'pid', t2.goodsName,t2.nowPrice,t2.picture from dbo.collect t1 join tb_goods t2 on t1.pid=t2.ID where [uid]=?";
		DBhelper dBhelper= new DBhelper();
		ResultSet rs = dBhelper.find(sql,uid);
		ArrayList<Collect> list=new ArrayList<Collect>();
		try {
			while (rs.next()) {
				Collect collect=new Collect(rs.getString("id"),rs.getString("pid"),rs.getString("goodsName"),rs.getString("picture"),rs.getString("nowPrice"));
				list.add(collect);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			dBhelper.close();
		}
		return list;
	}
	//查询这个商品是否已存在
	public static boolean serichCollectByUidAndPid(Collect c) {
		String sql="select * from dbo.collect where uid=? and pid=?";
		
		DBhelper dBhelper=new DBhelper();
		ResultSet rs = dBhelper.find(sql,c.getUid(),c.getPid());
		boolean tag=true;
		try {
			if (rs.next()) {
				tag=true;
			}else {
				tag=false;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			dBhelper.close();
		}
		return tag;
	}
	//删除收藏
	public static boolean delCollect(String id) {
		String sql="delete from collect where id=?";
		DBhelper dBhelper=new DBhelper();
		boolean b = dBhelper.Update(sql,id);
		return b;
	}
}
