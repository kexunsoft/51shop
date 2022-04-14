package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import com.model.Order;
import com.model.orderList;
import com.tools.DBhelper;

public class OrderDao {
	public static String insertOrder(Order o) {
		String sql="insert into tb_order(OrderID,bnmunber,username,recevieName,address,tel,bz) values(?,?,?,?,?,?,?)";
		DBhelper db=new DBhelper();
		String OrderID="";
		boolean b = db.Update(sql,o.getOrderID(),o.getBnmunber(),o.getUsername(),o.getRecevieName(),o.getAddress(),o.getTel(),o.getBz());
		if (b) {
			//获取最新单号
			String ssql="select top 1 OrderID from dbo.tb_order order by id desc";
			ResultSet rs = db.find(ssql);
			try {
				if (rs.next()) {
					OrderID=rs.getString("OrderID");
				}
			} catch (SQLException e) {
				OrderID="";
				e.printStackTrace();
			}
		}
		return OrderID;
	}
	//查询用户订单
	public static ArrayList<orderList> serichOrderByUserName(String username) {
		DBhelper db=new DBhelper();
		String sql="select t1.OrderID,t1.bnmunber,t1.username,t1.recevieName,t1.address,t1.tel,t1.OrderDate,t3.goodsName,t3.price,t3.nowPrice,t2.* from tb_order t1,tb_order_detail t2,tb_goods t3 where t2.goodeID=t3.ID and t1.OrderID=t2.orderID and t1.username=? order by t1.OrderDate desc";
		ResultSet rs = db.find(sql,username);
		ArrayList<orderList> list =new ArrayList<orderList>();
		try {
			while (rs.next()) {
				String price=String.valueOf(rs.getDouble("price"));
				
				orderList orderList=new orderList(rs.getInt("ID"), rs.getString("orderID"),rs.getString("goodsName"),rs.getString("number"),price,rs.getString("recevieName"),rs.getString("tel"),rs.getString("OrderDate"),rs.getInt("status"),rs.getString("orderNumber"));
				orderList.setGoodsID(rs.getString("goodeID"));
				list.add(orderList);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			list=null;
		}
		return list;
	}
	public static ArrayList<orderList> serichOrderByUserID(String ID) {
		DBhelper db=new DBhelper();
		ResultSet rs=null;
		if(!"".equals(ID)) {
			String sql="select t1.*,t3.*,t2.number,t2.ID as did,t2.status from tb_order t1 left join tb_order_detail t2 on t1.OrderID=t2.orderID  left join tb_goods t3 on t2.goodeID=t3.ID  where  t1.OrderID like ? order by t1.OrderDate desc";
			 rs = db.find(sql,"%"+ID+"%");
		}else {
			String sql="select t1.*,t3.*,t2.number,t2.ID as did,t2.status  from tb_order t1 left join tb_order_detail t2 on t1.OrderID=t2.orderID  left join tb_goods t3 on t2.goodeID=t3.ID  order by t1.OrderDate desc";
			 rs = db.find(sql);
		}
	
		
		if (rs==null) {
			return null;
		}
		ArrayList<orderList> list =new ArrayList<orderList>();
		try {
			
			while (rs.next()) {
			
				orderList orderList=new orderList(rs.getInt("did"), rs.getString("orderID"),rs.getString("goodsName"),rs.getString("number"),rs.getString("recevieName"),rs.getString("tel"),rs.getString("OrderDate"),rs.getInt("status"));
				list.add(orderList);
			}
		} catch (SQLException e) {
			
			list=null;
		}finally {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			db.close();
		}
		return list;
	}
	
}
