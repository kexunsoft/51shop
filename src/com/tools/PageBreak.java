package com.tools;

import java.util.ArrayList;

public class PageBreak {
	private static int pagecount;
	public static <T> ArrayList<T> fy(int page, ArrayList<T> list,int PAGESIZE){
		if(page<=0) {
			
			return null;
		}
		ArrayList<T> oList=new ArrayList<T>();
		
		pagecount=list.size()%PAGESIZE==0?list.size()/PAGESIZE:list.size()/PAGESIZE+1;
		
		//开始标记
		int start=PAGESIZE*(page-1);
		//结束标记
		int end=0;
		//判断,如果总条数-开始位置>页大小结束标记就加上页大小
		if(list.size()-start>=PAGESIZE){
		end=start+PAGESIZE;
			
		}else{
			//否则就直接读到末尾
			end=list.size();
		}
		
		System.out.println(start);
		System.out.println(end);
		for (int i = start; i < end; i++) {
			//把获取到的集合放新的集合里面去
			oList.add(list.get(i));
		}
		//返回新的集合
		return oList;
	}
	public static int getPageCount() {
		return pagecount;
	}
}
