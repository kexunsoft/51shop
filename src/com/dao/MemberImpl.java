package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import com.model.Menber;
import com.tools.ChStr;
import com.tools.DBhelper;

public class MemberImpl implements MenberDao {

	@Override
	public boolean insert(Menber m) {
		//添加会员
		String sql="insert into tb_Menber (UserName,TrueName,[PassWord],City,[address], postcode,CardNO,CardType,Tel,Email)"
				+ " values(?,?,?,?,?,?,?,?,?,?)";
		DBhelper db=new DBhelper();
		ChStr chStr=new ChStr();
		boolean b = db.Update(
				sql,
				chStr.chStr(m.getUsername()),
				chStr.chStr(m.getTruename()),
				chStr.chStr(m.getPwd()),
				chStr.chStr(m.getCity()), 
				chStr.chStr(m.getAddress()),
				chStr.chStr(m.getPostcode()) ,
				chStr.chStr(m.getCardno()) ,
				chStr.chStr(m.getCardtype()),
				chStr.chStr(m.getTel()) ,
				chStr.chStr(m.getEmail())
				);
		return b;
	}

	
	/*
	 * 存在就返回true不存在返回false
	 * */
	@Override
	public boolean serichByName(String name) {
		
		boolean b=true;//默认存爱
		DBhelper db=new DBhelper();
		String sql="select * from tb_Menber where UserName=?";
		ResultSet rs = db.find(sql,name);
		try {
			if (rs.next()) {
				//存在这个用户
				b=true;
			}else {
				b=false;
			}
		} catch (SQLException e) {
			b=true;
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public Menber serichByNameAndPWD(String name, String PWd) {
		String sql="select * from tb_Menber where UserName=? and [passWord]=?";
		DBhelper db=new DBhelper();
		ResultSet rs = db.find(sql,name,PWd);
		Menber menber=null;
		try {
			if (rs.next()) {
				menber=new Menber();
				menber.setUsername(rs.getString("userName"));
				menber.setTruename(rs.getString("Truename"));
				menber.setTel(rs.getString("tel"));
				menber.setEmail(rs.getString("Email"));
				menber.setID(rs.getInt("ID"));
			}else {
				menber=null;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return menber;
	}


	@Override
	public  ArrayList<Menber> selectAll() {
		String sql="select t1.userName,t1.trueName,t1.tel,t1.email,SUM(t3.price) as Amount from tb_menber t1 left join dbo.tb_order t2 on t1.userName=t2.username left join  dbo.tb_order_detail t3 on t2.OrderID=t3.orderID group by t1.userName,t1.trueName,t1.tel,t1.email";
		DBhelper db=new DBhelper();
		ResultSet rs = db.find(sql);
		if (rs==null) {
			return null;
		}
		DecimalFormat dFormat=new DecimalFormat("#.00");
		ArrayList<Menber> list=new ArrayList<Menber>();
		try {
			while(rs.next()) {
				Menber menber=new Menber();
				menber.setUsername(rs.getString("userName"));
				menber.setTruename(rs.getString("Truename"));
				menber.setTel("".equals(rs.getString("tel"))?"无":rs.getString("Email"));
				menber.setEmail("".equals(rs.getString("Email"))?"无":rs.getString("Email"));
				menber.setAmount(rs.getString("Amount")==null?"0":dFormat.format(rs.getDouble("Amount")));
				list.add(menber);
			}
		} catch (SQLException e) {
			list=null;
			e.printStackTrace();
		}
		
		return list;
	}


	@Override
	public boolean updateByUserName(Menber m) {
		String sql="update tb_menber set trueName=?,[passWord]=?,tel=?,email=? where userName=?";
		DBhelper db=new DBhelper();
		ChStr chStr=new ChStr();
		boolean b = db.Update(
				sql,
				chStr.chStr(m.getTruename()),
				chStr.chStr(m.getPwd()),
				chStr.chStr(m.getTel()) ,
				chStr.chStr(m.getEmail()),
				chStr.chStr(m.getUsername())
				);
		return b;
		
	}

}
