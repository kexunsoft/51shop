package com.tools;

public class ChStr {
	//解决乱码的类
	public String chStr(String str) {
		if(str==null) {
			str="";
		}else {
			try {
				str=(new String(str.getBytes("utf-8"),"utf-8")).trim();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return str;
	}
}
