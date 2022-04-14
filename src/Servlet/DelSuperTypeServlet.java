package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.SuperTypeDao;
import com.dao.goodsDao;
import com.model.goods;
@WebServlet("/DelSuperType")
public class DelSuperTypeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3591571317085182340L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		HttpSession session = req.getSession();
		Object user = session.getAttribute("manager");
		if(user==null) {
			resp.sendError(404);
			return;
		}
		String id []=req.getParameterValues("delid");
		boolean b=false;
		for (String idstr : id) {
				ArrayList<goods> serichByGoodsSuperType = goodsDao.serichByGoodsSuperType(idstr);
				if(serichByGoodsSuperType!=null&&serichByGoodsSuperType.size()>0) {
					resp.setContentType("text/html;charset=utf-8");
					PrintWriter out = resp.getWriter();
					out.print("<script>");
					out.print("alert('无法删除分类"+serichByGoodsSuperType.get(0).getTypeName()+",请先移除此分类下的商品');");
					out.print("window.location.href='manage/superType.jsp'");
					out.print("</script>");
					
				}else {
					 b = SuperTypeDao.delSuperType(idstr);
				}
			
		}
		if (b) {
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.print("<script>");
			out.print("alert('"+id.length+"条数据删除成功');");
			out.print("window.location.href='manage/superType.jsp'");
			out.print("</script>");
		}else {
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.print("<script>");
			out.print("alert('删除失败');");
			out.print("window.location.href='manage/superType.jsp'");
			out.print("</script>");
		}
	}
}
