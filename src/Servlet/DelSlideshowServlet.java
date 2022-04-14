package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.SlideshowDao;
@WebServlet("/DelSlideshow")
public class DelSlideshowServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4097848537121721105L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		boolean b = SlideshowDao.delSlideshow(id);
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		if(b) {
			out.write("删除成功");
		}else {
			out.write("删除失败");
		}
	}
}
