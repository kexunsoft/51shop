package Servlet;

import java.io.IOException;
import java.util.Arrays;

import java.util.LinkedList;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/serichProduct")
public class SerichProductServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1548568782725465012L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("ID");
		
		String getids = getids(id,req);
		Cookie cookie=new Cookie("his",getids);
		//设置存活时间
		cookie.setMaxAge(60*24);
		resp.addCookie(cookie);
		resp.sendRedirect("fromt/goodsDetail.jsp?ID="+id);
	}
	private  String getids(String id,HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (cookies==null) {
			return id;
		}
		Cookie his=null;
		for (int i = 0; i < cookies.length; i++) {
			if("his".equals(cookies[i].getName())) {
				his=cookies[i];
			}
		}
		if (his==null) {
			return id;
		}
		String value=his.getValue();
		String [] ids=value.split("-");
		LinkedList<String> list=new LinkedList<String>(Arrays.asList(ids));
		if (list.size()<5) {
			if(list.contains(id)) {
				list.remove(id);
			}
		}else {
			if(list.contains(id)) {
				list.remove(id);
			}else {
				list.removeLast();
			}
		}
		list.addFirst(id);
		StringBuffer sb=new StringBuffer();
		
		for (int i = 0; i < list.size(); i++) {
			if(i>0) {
				sb.append("-");
			}
			sb.append(list.get(i));
		}
		return sb.toString();
	}
}
