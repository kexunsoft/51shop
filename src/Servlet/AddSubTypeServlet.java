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
@WebServlet("/AddSubType")
public class AddSubTypeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5172751853083878648L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自动生成的方法存根
	doPost(req,resp);
	}
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
		String sID=req.getParameter("superid");
		String tName=req.getParameter("typename");
		boolean b = SubTypeDao.addSubType(sID,tName);
		if (b) {
			
			PrintWriter out = resp.getWriter();
			out.print("<script>");
			out.print("alert('添加成功');");
			out.print("window.location.href='manage/superType.jsp'");
			out.print("</script>");
		}else {
			
			PrintWriter out = resp.getWriter();
			out.print("<script>");
			out.print("alert('添加失败');");
			out.print("window.location.href='manage/superType.jsp'");
			out.print("</script>");
		}
	}
}
