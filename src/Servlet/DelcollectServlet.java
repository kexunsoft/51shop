package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CollectDao;
import com.model.Menber;
@WebServlet("/delcollect")
public class DelcollectServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7863344209879561459L;
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.setCharacterEncoding("utf-8");
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			String id = req.getParameter("id");
			Menber user=(Menber)req.getSession().getAttribute("user");
			if (user==null) {
				resp.sendError(404);
				return;
			}
			boolean b = CollectDao.delCollect(id);
			if (b) {
				out.write("删除成功");
			}else {
				out.write("删除失败");
			}
		
		}
	
	
	
}
