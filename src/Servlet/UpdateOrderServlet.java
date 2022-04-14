package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.OrderDao;
import com.dao.orderDetailDao;
import com.model.OrderDetail;
@WebServlet("/OrderUpdate")
public class UpdateOrderServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2480042133939053256L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		HttpSession session = req.getSession();
		Object user = session.getAttribute("user");
		if(user==null) {
			resp.sendError(404);
			return;
		}
		req.setCharacterEncoding("utf-8");
		String orderID=req.getParameter("orderID");
		String status=req.getParameter("status");
		
		boolean b = orderDetailDao.updateOrder(orderID,status);
		PrintWriter out = resp.getWriter();
		if(b) {
			out.write("true");
		}else {
			out.write("false");
		}
	}
}
