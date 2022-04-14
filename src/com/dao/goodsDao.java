package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import com.model.goods;
import com.tools.DBhelper;

public class goodsDao {
	public static ArrayList<goods> serichByNewGoods() {
		//查询新品
		DBhelper db=new DBhelper();
		String sql="select top 12 *  from tb_goods t1 where t1.newGoods=1 order by t1.INTime desc  ";
		ResultSet rs = db.find(sql);
		ArrayList<goods> list= new ArrayList<goods>();
		try {
			while (rs.next()) {
				goods g=new goods();
				g.setID(rs.getInt("ID"));
				g.setGoodsName(rs.getString("GoodsName"));
				g.setNowPrice(rs.getDouble("NowPrice"));
				g.setPicture(rs.getString("Picture"));
				list.add(g);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return list;
	}
	public static ArrayList<goods> serichByGoodsSuperType(String sID) {
		//根据大类别查询
		DBhelper db=new DBhelper();
		String sql="select t1.*,t2.TypeName from tb_goods t1 left join dbo.tb_subType t2 on t1.typeID=t2.superType where t1.typeID=?";
		ResultSet rs = db.find(sql,sID);
		ArrayList<goods> list= new ArrayList<goods>();
		try {
			while (rs.next()) {
				goods g=new goods();
				g.setID(rs.getInt("ID"));
				g.setGoodsName(rs.getString("GoodsName"));
				g.setNowPrice(rs.getDouble("price"));
				g.setPicture(rs.getString("Picture"));
				g.setTypeName(rs.getString("TypeName"));
				list.add(g);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return list;
	}
	public static ArrayList<goods> serichByZheGoods() {
		//查询新品
		DBhelper db=new DBhelper();
		String sql="select top 12 t1.ID, t1.GoodsName,t1.price,t1.nowPrice,t1.picture from tb_goods t1 where  t1.sale=1 order by t1.INTime desc";
		ResultSet rs = db.find(sql);
		ArrayList<goods> list= new ArrayList<goods>();
		try {
			while (rs.next()) {
				goods g=new goods();
				g.setID(rs.getInt("ID"));
				g.setGoodsName(rs.getString("GoodsName"));
				g.setNowPrice(rs.getDouble("NowPrice"));
				g.setPrice(rs.getDouble("Price"));
				g.setPicture(rs.getString("Picture"));
				list.add(g);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return list;
	}
	//查询热门
	public static ArrayList<goods> serichByRmGoods() {
		//查询新品
		DBhelper db=new DBhelper();
		String sql="select top 12 * from tb_goods order by hit desc";
		ResultSet rs = db.find(sql);
		if(rs==null) {return null;}
		ArrayList<goods> list= new ArrayList<goods>();
		try {
			while (rs.next()) {
				goods g=new goods();
				g.setID(rs.getInt("ID"));
				g.setGoodsName(rs.getString("GoodsName"));
				g.setPrice(rs.getDouble("Price"));
				g.setNowPrice(rs.getDouble("NowPrice"));
				g.setPicture(rs.getString("Picture"));
				list.add(g);
			}
		} catch (SQLException e) {
			list=null;
			e.printStackTrace();
		}
		return list;
	}
	//根据iD查询商品的详细信息
	public static goods serichGoodsByID(String id) {
		System.out.println("商品ID"+id);	
		//查询新品
			DBhelper db=new DBhelper();
			String sql="select * from tb_goods where ID=?";
			ResultSet rs = db.find(sql,id);
			goods g=null;
			
			try {
				if (rs.next()) {
					g=new goods();
					g.setID(rs.getInt("ID"));
					g.setGoodsName(rs.getString("GoodsName"));
					g.setSale(rs.getString("Sale"));
					g.setTypeID(rs.getString("TypeID"));
					g.setNowPrice(rs.getDouble("NowPrice"));
					g.setPrice(rs.getDouble("Price"));
					g.setPicture(rs.getString("Picture"));
					g.setTypeID(rs.getString("TypeID"));
					g.setIntroduce(rs.getString("Introduce"));
					g.setNewGoods(rs.getString("NewGoods"));
					
				}
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			return g;
		}
	public static ArrayList<goods> serichByName(String serichName) {
			String sql=" select * from tb_goods where  goodsName like ? order by id ";
			
			DBhelper db=new DBhelper();
			ResultSet rs = db.find(sql,"%"+serichName+"%");
			if(rs==null) {return null;}
			ArrayList<goods> list= new ArrayList<goods>();
			try {
				while (rs.next()) {
					goods g=new goods();
					g.setID(rs.getInt("ID"));
					g.setGoodsName(rs.getString("GoodsName"));
					
					g.setNowPrice(rs.getDouble("NowPrice"));
					g.setPicture(rs.getString("Picture"));
					list.add(g);
				}
			} catch (SQLException e) {
				list=null;
				e.printStackTrace();
			}
			return list;
		}
	public static ArrayList<goods> serichByAllGoods() {
			//查询新品
			DBhelper db=new DBhelper();
			String sql=" select * from tb_goods";
			ResultSet rs = db.find(sql);
			if (rs==null) {
				return null;
			}
			ArrayList<goods> list= new ArrayList<goods>();
			try {
				while (rs.next()) {
					goods g=new goods();
					g.setID(rs.getInt("ID"));
					g.setGoodsName(rs.getString("GoodsName"));
					g.setSale(rs.getString("Sale"));
					g.setNowPrice(rs.getDouble("NowPrice"));
					
					list.add(g);
				}
			} catch (SQLException e) {
				list=null;
				e.printStackTrace();
			}
			return list;
		}
	public static boolean addGoods(goods g) {
		String sql="INSERT INTO tb_goods([typeID],[goodsName],[introduce],[nowPrice],[price],[picture],[newGoods],[sale])VALUES(?,?,?,?,?,?,?,?)";
	
		DBhelper db=new DBhelper();
		boolean b = db.Update(sql,g.getTypeID(),g.getGoodsName(),g.getIntroduce(),g.getNowPrice(),g.getNowPrice(),g.getPicture(),g.getNewGoods(),g.getSale());
		return b;
	}
	//修改
	public static boolean modifyGoods(goods g) {
		String sql="UPDATE [db_shop].[dbo].[tb_goods] SET [typeID] = ?,[goodsName] = ?,[introduce] = ?,[price] =?,[nowPrice] = ?,[picture] = ?,[newGoods] = ?,[sale] = ? WHERE ID=?";
	
		DBhelper db=new DBhelper();
		boolean b = db.Update(sql,g.getTypeID(),g.getGoodsName(),g.getIntroduce(),g.getPrice(),g.getNowPrice(),g.getPicture(),g.getNewGoods(),g.getSale(),g.getID());
		return b;
	}	
	//删除
	public static boolean delGoods(String id) {
		DBhelper db=new DBhelper();
		String sql="delete dbo.tb_goods where ID=?";
		boolean b = db.Update(sql,id);
		return b;
	}
	//修改销量
	public static boolean updateHit(String id) {
		String sql="update dbo.tb_goods set hit+=1 where ID=?";
		DBhelper db=new DBhelper();
		boolean b = db.Update(sql,id);
		return b;
	}
	//查询商品数量
	public static int SerichGoodsCount() {
		String sql="select COUNT(ID) as '商品数' from dbo.tb_goods";
		DBhelper dBhelper=new DBhelper();
		ResultSet rs = dBhelper.find(sql);
		int count=0;
		try {
			if(rs.next()) {
				count=rs.getInt("商品数");
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			dBhelper.close();
		}
		return count;
	}
}
