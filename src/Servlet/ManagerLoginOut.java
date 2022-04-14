package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/LoginOut")
public class ManagerLoginOut extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8076784183167780009L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		//销毁session
		session.invalidate();
		resp.sendRedirect("manage/Login_M.jsp");
	}
}
