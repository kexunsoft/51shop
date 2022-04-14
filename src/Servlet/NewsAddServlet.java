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
import com.model.News;
@WebServlet("/NewsAdd")
public class NewsAddServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7928216683422376919L;
	

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
		String newsName=req.getParameter("newsName");
		String introduce=req.getParameter("introduce");
		News news=new News();
		news.setEn_title(newsName);
		news.setEn_content(introduce);
		
		boolean b = NewDao.newsAdd(news);
		 if (b) {
			 resp.setContentType("text/html;charset=utf-8");
				PrintWriter out = resp.getWriter();
				out.print("<script>");
				out.print("alert('添加成功');");
				out.print("window.location.href='manage/news.jsp'");
				out.print("</script>");
		}else {
			 resp.setContentType("text/html;charset=utf-8");
				PrintWriter out = resp.getWriter();
				out.print("<script>");
				out.print("alert('添加失败');");
				out.print("window.location.href='manage/news_add.jsp'");
				out.print("</script>");
		}
	}
	
}
