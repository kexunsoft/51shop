package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BigDataDao;
@WebServlet("/SerichOrdetByWeekDay")
public class SerichOrdetByWeekDayServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2138323015213589556L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HashMap<Integer, Integer> serichOrderByWeekDay = BigDataDao.serichOrderByWeekDay();
		StringBuffer sb=new StringBuffer();
		for(Entry<Integer, Integer> s:serichOrderByWeekDay.entrySet()) {
			
			sb.append(s.getValue().toString());
			sb.append(",");
		}
		resp.setHeader("Access-Control-Allow-Origin","*");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println(sb.toString());
		out.close();
	}
	
}
