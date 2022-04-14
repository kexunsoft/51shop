package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tools.RASTest;
@WebServlet("/keyLogin")
public class DoPrivateLoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4004865668552351938L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String username=req.getParameter("username");
		String pwd=req.getParameter("pwd");
		String yzm=req.getParameter("yzm");
		String newPwd = RASTest.jiemi(pwd);
		req.setAttribute("username",username);
		req.setAttribute("pwd",newPwd);
		req.setAttribute("yzm",yzm);
		req.getRequestDispatcher("/doLogin").forward(req,resp);
		
	}
	
	
}
