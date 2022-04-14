package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.orderDetailDao;
@WebServlet("/UpdateOrderNumber")
public class UpdateOrderNumberServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4550122042993875461L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		String orderNumber=req.getParameter("orderNumber");
		boolean b = orderDetailDao.updateOrderNumber(orderNumber,id);
		System.out.println(b);
		System.out.println(id);
		System.out.println(orderNumber);
		PrintWriter out = resp.getWriter();
		if(b) {
			out.write("ok");
		}else {
			out.write("no");
		}
	}
}
