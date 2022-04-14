package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.SuperTypeDao;
@WebServlet("/AddSuperType")
public class AddSuperTypeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2635385216005022510L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		HttpSession session = req.getSession();
		Object user = session.getAttribute("manager");
		if(user==null) {
			resp.sendError(404);
			return;
		}
		req.setCharacterEncoding("utf-8");
		String typename=req.getParameter("typename");
		boolean b = SuperTypeDao.addSuperType(typename);
		if (b) {
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.print("<script>");
			out.print("alert('添加成功');");
			out.print("window.location.href='manage/superType.jsp'");
			out.print("</script>");
		}else {
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.print("<script>");
			out.print("alert('添加失败');");
			out.print("window.location.href='manage/super_add.jsp'");
			out.print("</script>");
		}
	}
}
