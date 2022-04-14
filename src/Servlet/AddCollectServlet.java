package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CollectDao;
import com.model.Collect;
@WebServlet("/AddCollect")
public class AddCollectServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 803468309160033488L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		req.setCharacterEncoding("utf-8");
		String uid = req.getParameter("uid");
		String pid = req.getParameter("pid");
		if(uid==null) {
			out.write("uid为必须参数");
			return;
		}
		if(pid==null) {
			out.write("pid为必须参数");
			return;
		}
	
		Collect collect=new Collect(uid,pid);
		//查询是否已经存在
		boolean serichCollectByUidAndPid = CollectDao.serichCollectByUidAndPid(collect);
		if (!serichCollectByUidAndPid) {
			boolean b = CollectDao.addcollect(collect);
			if (b) {
				out.write("收藏成功");
			}else {
				out.write("收藏失败");
			}
		}else {
			out.write("已近在收藏了哦");
		}
		
	}
}
