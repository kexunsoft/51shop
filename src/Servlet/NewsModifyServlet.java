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
import com.model.Menage;
import com.model.News;
@WebServlet("/NewsModify")
public class NewsModifyServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 511915917458383726L;

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			resp.setContentType("text/html;charset=utf-8");
			HttpSession session1 = req.getSession();
			Object user = session1.getAttribute("manager");
			if(user==null) {
				resp.sendError(404);
				return;
			}
			req.setCharacterEncoding("utf-8");
			HttpSession session = req.getSession();
			Menage m=(Menage)session.getAttribute("manager");
			if(m==null){
					
				 resp.setContentType("text/html;charset=utf-8");
					PrintWriter out = resp.getWriter();
					out.print("<script>");
					out.print("alert('请先登录');");
					out.print("window.location.href='manage/Login_M.jsp'");
					out.print("</script>");
					return;
					
			}
			String newsID=req.getParameter("newsID");
			String newsName=req.getParameter("newsName");
			String introduce=req.getParameter("introduce");
			
			News news=new News();
			news.setEn_id(newsID);
			news.setEn_title(newsName);
			news.setEn_content(introduce);
			
			boolean b = NewDao.updateNewsByID(news);
			 if (b) {
				 resp.setContentType("text/html;charset=utf-8");
					PrintWriter out = resp.getWriter();
					out.print("<script>");
					out.print("alert('修改成功');");
					out.print("window.location.href='manage/news.jsp'");
					out.print("</script>");
			}else {
				 resp.setContentType("text/html;charset=utf-8");
					PrintWriter out = resp.getWriter();
					out.print("<script>");
					out.print("alert('修改失败');");
					out.print("window.location.href='manage/news_modify.jsp'");
					out.print("</script>");
			}
		}
	
		
}
