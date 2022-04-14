package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.NewDao;
@WebServlet("/DelNews")
public class DelNewsServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4927882951674095905L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		HttpSession session = req.getSession();
		Object user = session.getAttribute("manager");
		if(user==null) {
			resp.sendError(404);
			return;
		}
		req.setCharacterEncoding("utf-8");
		String id=req.getParameter("ID");
		boolean b = NewDao.delNewsByID(id);
		if (b) {
			 resp.setContentType("text/html;charset=utf-8");
				PrintWriter out = resp.getWriter();
				out.print("<script>");
				out.print("alert('删除成功');");
				out.print("window.location.href='manage/news.jsp'");
				out.print("</script>");
		}else {
			 resp.setContentType("text/html;charset=utf-8");
				PrintWriter out = resp.getWriter();
				out.print("<script>");
				out.print("alert('删除失败');");
				out.print("window.location.href='manage/news.jsp'");
				out.print("</script>");
		}
	}
	
	
}
