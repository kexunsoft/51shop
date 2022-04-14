package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.dao.orderDetailDao;
import com.model.Top;
@WebServlet("/SerichTop5")
public class SerichTop5Servlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6118615208681641534L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<Top> list = orderDetailDao.serichtop5();
		String json = JSON.toJSON(list).toString();
		resp.setHeader("Access-Control-Allow-Origin","*");
		resp.setContentType("application/json;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.write(json);
		
	}
	
	
}
