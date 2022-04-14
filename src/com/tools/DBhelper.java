package com.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBhelper {
	//连接SQLserver数据库服务器
	private final String URL="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=db_shop";
	private final String USER="sa";
	private final String PWD="123";
	private	Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs =null;
	static {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public DBhelper() {
		try {
			 conn = DriverManager.getConnection(URL,USER,PWD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//查询
	public ResultSet find(String sql,Object...o) {
		if(conn==null) {return null;}
		try {
			
			 stmt = conn.prepareStatement(sql);
			if (o.length==0) {
				 rs = stmt.executeQuery();
			}else {
				for (int i = 0; i < o.length; i++) {
					stmt.setObject(i+1,o[i]);
				}
				 rs = stmt.executeQuery();
			}
			
		} catch (SQLException e) {
			rs=null;
			e.printStackTrace();
		}
		
		return rs;
	}
	//增删改
	public boolean Update(String sql,Object...o) {
		if(conn==null) {return false;}
		int ep=0;
		try {
			 stmt = conn.prepareStatement(sql);
			if (o.length==0) {
				 ep=stmt.executeUpdate();
			}else {
				for (int i = 0; i < o.length; i++) {
					stmt.setObject(i+1,o[i]);
				}
				 ep=stmt.executeUpdate();
			}
			
		} catch (SQLException e) {
			 ep=0;
			e.printStackTrace();
		}
		return ep>0?true:false;
	}
	//关闭方法
	public void close() {
		
			try {
				if (rs!=null) {
				rs.close();
				}
				if (stmt!=null) {
					stmt.close();
				}
				if (conn!=null) {
					conn.close();
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
	}
	public static void main(String[] args) {
		DBhelper dBhelper=new DBhelper();
		System.out.println(dBhelper.conn);
	}
}
