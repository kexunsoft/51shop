package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.SubTypeDao;
@WebServlet("/DelSubType")
public class DelSubTypeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8921096757874234448L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		HttpSession session = req.getSession();
		Object user = session.getAttribute("manager");
		if(user==null) {
			resp.sendError(404);
			return;
		}
		String ids[]=req.getParameterValues("delid");
		boolean b=false;
		for (String id : ids) {
			b = SubTypeDao.delSubType(id);
		}
		if (b) {
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.print("<script>");
			out.print("alert('"+ids.length+"条数据删除成功');");
			out.print("window.location.href='manage/subType.jsp'");
			out.print("</script>");
		}else {
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.print("<script>");
			out.print("alert('删除失败');");
			out.print("window.location.href='manage/subType.jsp'");
			out.print("</script>");
		}
		
	}
}
