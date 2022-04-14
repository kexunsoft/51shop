package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.MemberImpl;
@WebServlet("/NameCheck")
public class NameCheckSerclet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2842297513613356641L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String username=req.getParameter("username");
		System.out.println(username);
		MemberImpl memberImpl=new MemberImpl();
		 boolean b = memberImpl.serichByName(username);
		 if (b) {
			//存在
			 resp.setContentType("text/html;charset=utf-8");
				PrintWriter out = resp.getWriter();
				out.write("true");
		}else {
			
		}
	}
}
