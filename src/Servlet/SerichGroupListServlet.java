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
import com.dao.BigDataDao;
import com.model.GroupList;
@WebServlet("/SerichGroupList")
public class SerichGroupListServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5087456132684060560L;
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doPost(req,resp);
		}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<GroupList> list = BigDataDao.serichGroupCount();
		String json = JSON.toJSON(list).toString();
		resp.setHeader("Access-Control-Allow-Origin","*");
		resp.setContentType("application/json;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println(json);
		out.close();
	}
	
}
