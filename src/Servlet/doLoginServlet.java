package Servlet;

import com.dao.MemberImpl;
import com.model.Menber;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/doLogin")
public class doLoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7645023563858684812L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String name=(String)req.getAttribute("username");
		String pwd=(String)req.getAttribute("pwd");
		String yzm=(String)req.getAttribute("yzm");
		String str=(String)req.getSession().getAttribute("randCheckCode");
		MemberImpl memberImpl=new MemberImpl();
		if (yzm.equalsIgnoreCase(str)) {
			//验证码正确
			Menber menber=	memberImpl.serichByNameAndPWD(name,pwd);
			if (menber!=null) {
				//保存到session
				HttpSession session = req.getSession();
				session.setAttribute("user",menber);
				session.setMaxInactiveInterval(60*24);
				 resp.setContentType("text/html;charset=utf-8");
					PrintWriter out = resp.getWriter();
					
					
					out.print("ok");
					
			}else {
				 resp.setContentType("text/html;charset=utf-8");
					PrintWriter out = resp.getWriter();
					
					
					out.print("no");
			}
		}else {
			//验证码错误
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			
			
			out.print("no");
		}
		
		
		
	}
}
