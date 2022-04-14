package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.MenageDao;
import com.model.Menage;
@WebServlet("/doManageLogin")
public class doManageLoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6180345337019969594L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String name=req.getParameter("manager");
		String pwd=req.getParameter("PWD");
		Menage menage = MenageDao.serichMenageByIdAndPwd(name,pwd);
		if (menage!=null) {
			//保存session
			HttpSession session = req.getSession();
			session.setAttribute("manager",menage);
			resp.sendRedirect("manage/index.jsp");
		}else {
			 resp.setContentType("text/html;charset=utf-8");
				PrintWriter out = resp.getWriter();
				out.print("<script>");
				out.print("alert('密码错误');");
				out.print("window.location.href='manage/Login_M.jsp'");
				out.print("</script>");
		}
	}
}
