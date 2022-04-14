package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/CheckCodeServlet")
public class CheckCodeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5658671392522858118L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String code=req.getParameter("code");
		String str=(String)req.getSession().getAttribute("randCheckCode");
		System.out.println(code);
		PrintWriter out = resp.getWriter();
		if(code.equalsIgnoreCase(str)) {
			out.write("true");
		}else {
			out.write("false");
		}
	}
}
