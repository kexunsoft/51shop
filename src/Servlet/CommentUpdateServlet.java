package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.CommentDao;
@WebServlet("/CommentUpdate")
public class CommentUpdateServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1062333690451394764L;
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
		resp.setContentType("html/text;charset=utf-8");
		
		String id=req.getParameter("id");
		String reply=req.getParameter("reply");
		reply=new String(reply.getBytes("iso-8859-1"),"utf-8");
		System.out.println(id);
		System.out.println(reply);
		boolean b = CommentDao.updateComment(id,reply);
		PrintWriter out = resp.getWriter();
		if (b) {
			out.write("true");
		}else {
			out.write("false");
		}
	}
}
