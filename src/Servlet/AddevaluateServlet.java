package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.EvaluateDao;
import com.model.Evaluate;
import com.model.Menber;
@WebServlet("/addEvaluate")
public class AddevaluateServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6942104989958684808L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String pj=req.getParameterValues("pj")[0];
		String text=req.getParameter("text");
		String pid=req.getParameter("pid");
		System.out.println(pj+"=="+text+"=="+pid);
		HttpSession session = req.getSession();
		Menber user= (Menber) session.getAttribute("user");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		if(user!=null) {
			String username=user.getUsername();
			Evaluate evaluateDao=new Evaluate(pj,text,pid,username);
			boolean b = EvaluateDao.addEvaluate(evaluateDao);
			if (b) {
				out.println("<script>");
				out.println("alert('评价成功')");
				out.println("window.location.href='/shop/fromt/orderList.jsp'");
				out.println("</script>");
			}
		}
	}
}
