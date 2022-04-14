package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.model.GroupList;
import com.tools.DBhelper;

public class BigDataDao {
	//查询每个星期的销售额
	public static HashMap<Integer, Integer> serichOrderByWeekDay() {
		//键:星期 值:销售额
		HashMap<Integer,Integer> hashMap=new HashMap<Integer,Integer> ();
		hashMap.put(1,0);
		hashMap.put(2,0);
		hashMap.put(3,0);
		hashMap.put(4,0);
		hashMap.put(5,0);
		hashMap.put(6,0);
		hashMap.put(0,0);
		String sql="select (datepart(weekday,t2.OrderDate)-1) as '星期',sum(t1.price*t1.number) as '销售额' from dbo.tb_order_detail t1 left join dbo.tb_order t2 on t1.orderID=t2.OrderID group by  (datepart(weekday,t2.OrderDate)-1)";
		DBhelper dBhelper=new DBhelper();
		ResultSet rs = dBhelper.find(sql);
		try {
			while (rs.next()) {
				hashMap.put(rs.getInt("星期"),rs.getInt("销售额"));
				
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			dBhelper.close();
		}
		return hashMap;
		
	}
	//查询各分类销量
	public static ArrayList<GroupList> serichGroupCount() {
		String sql="select t3.TypeName,COUNT(t1.goodeID) as'销量' from dbo.tb_order_detail t1 left join dbo.tb_goods t2 on t1.goodeID=t2.ID right join dbo.tb_superType t3 on t2.typeID=t3.ID group by t3.TypeName";
		DBhelper dBhelper=new DBhelper();
		ResultSet rs = dBhelper.find(sql);
		ArrayList<GroupList> list=new ArrayList<GroupList>();
		try {
			while (rs.next()) {
				GroupList groupList=new GroupList();
				groupList.setName(rs.getString("TypeName"));
				groupList.setValue(rs.getInt("销量"));
				list.add(groupList);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			dBhelper.close();
		}
		return list;
		}
}
