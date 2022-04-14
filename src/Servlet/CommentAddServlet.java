package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.CommentDao;
import com.model.Comment;


@WebServlet("/CommentAdd")
public class CommentAddServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8955033408799587473L;
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
		String guestName=req.getParameter("guestName");
		//String guestTitle=req.getParameter("guestTitle");
		String guestContent=req.getParameter("guestContent");
		SimpleDateFormat sd=new SimpleDateFormat("YYYY-MM-DD");
		String format = sd.format(new Date());
		Comment comment=new Comment(guestContent,format,guestName);
		boolean b = CommentDao.addComment(comment);
		 resp.setContentType("text/html;charset=utf-8");
		  PrintWriter pw=resp.getWriter();
		if(b) {
				pw.println("<script>");
			  pw.println("alert('留言成功');");
			  pw.println("window.location.href='fromt/goodbook.jsp';");
			  pw.println("</script>");
		}else {
				pw.println("<script>");
			  pw.println("alert('留言失败');");
			  pw.println("window.location.href='fromt/goodbook.jsp';");
			  pw.println("</script>");
		}
		
	}
}
