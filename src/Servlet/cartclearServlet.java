package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/cartclear")
public class cartclearServlet extends HttpServlet  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5775920992379934268L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Object user = session.getAttribute("user");
		if(user==null) {
			response.sendError(404);
			return;
		}
		session.removeAttribute("cart");
		response.sendRedirect("fromt/cart_null.jsp");
	}
}
