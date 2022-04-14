package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.OrderDetail;
import com.model.Top;
import com.tools.DBhelper;

public class orderDetailDao {
	public static boolean InsertOrderDetail(OrderDetail od) {
		 
		String sql="insert into dbo.tb_order_detail(orderID,goodeID,price,number) values(?,?,?,?)";
		DBhelper db=new DBhelper();
		boolean b = db.Update(sql,od.getOrderID(),od.getGoodeID(),od.getPrice(),od.getNumber());
		return b;
	}
	public static ArrayList<Top> serichtop() {
		String sql="select top 10 t2.goodsName,sum(t1.number) as num from tb_order_detail t1,tb_goods t2  where t1.goodeID=t2.ID  group by t2.goodsName  order by num desc";
		DBhelper db=new DBhelper();
		ResultSet rs = db.find(sql);
		ArrayList<Top> list=new ArrayList<Top>();
		if (rs==null) {
			return null;
		}
		try {
			while (rs.next()) {
				Top top=new Top(rs.getString("goodsName"),rs.getString("num"));
				list.add(top);
			}
		} catch (SQLException e) {
			list=null;
			e.printStackTrace();
		}
		return list;
	}
	public static ArrayList<Top> serichtop5() {
		String sql="select top 5 t2.goodsName,sum(t1.number) as num from tb_order_detail t1,tb_goods t2  where t1.goodeID=t2.ID  group by t2.goodsName  order by num desc";
		DBhelper db=new DBhelper();
		ResultSet rs = db.find(sql);
		ArrayList<Top> list=new ArrayList<Top>();
		if (rs==null) {
			return null;
		}
		try {
			while (rs.next()) {
				Top top=new Top(rs.getString("goodsName"),rs.getString("num"));
				list.add(top);
			}
		} catch (SQLException e) {
			list=null;
			e.printStackTrace();
		}
		return list;
	}
	public static boolean updateOrder(String orderID,String status ) {
		String sql="update tb_order_detail set status=? where id=?";
		DBhelper dBhelper=new DBhelper();
		boolean b = dBhelper.Update(sql,status,orderID);
		return b;
	}
	//查询转态个数
	public static int serichOrderstutas(int stutas) {
		String sql="select COUNT(*) as '数量' from tb_order_detail where status=?";
		DBhelper dBhelper=new DBhelper();
		ResultSet rs = dBhelper.find(sql,stutas);
		int count=0;
		try {
			if (rs.next()) {
				count=rs.getInt("数量");
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			dBhelper.close();
		}
		return count;
	}
	//查询成交金额
	public static double serichOrderSumPrice() {
		String sql="select SUM(price*number) as '成交额' from tb_order_detail where status=4";
		DBhelper dBhelper=new DBhelper();
		ResultSet rs = dBhelper.find(sql);
		double sumPrice=0;
		try {
			if (rs.next()) {
				sumPrice=rs.getInt("成交额");
			}else {
				sumPrice=0;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			dBhelper.close();
		}
		return sumPrice;
	}
	//修改快递单号
	public static boolean updateOrderNumber(String orderNumber,String id) {
		String sql="update tb_order_detail set orderNumber=? where id=?";
		DBhelper dBhelper=new DBhelper();
		boolean b = dBhelper.Update(sql,orderNumber,id);
		return b;
	}
}
