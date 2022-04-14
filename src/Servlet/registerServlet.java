package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.MemberImpl;
import com.model.Menber;

@WebServlet("/doRegister")
public class registerServlet extends HttpServlet {

	private static final long serialVersionUID = 6607656024478280742L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.setCharacterEncoding("utf-8");
		//获取前台传来的所有数据
		 String username = req.getParameter("username"); 					// 账户属性
		 String truename = req.getParameter("truename"); 					// 真实姓名属性
		 String pwd = req.getParameter("pwd"); 						// 密码属性
		 String city = req.getParameter("city"); 						// 所在城市属性
		 String address = req.getParameter("address"); 					// 地址属性
		 String postcode = req.getParameter("postcode"); 					// 邮编属性
		 String cardno = req.getParameter("cardno"); 						// 证件号码属性
		 String cardtype = req.getParameter("cardtype"); 					// 证件类型属性
		 String tel = req.getParameter("tel"); 						// 联系电话属性
		 String email = req.getParameter("email"); 						// 邮箱属性
		 //判断用户是否存在
		 MemberImpl memberImpl=new MemberImpl();
		 boolean b = memberImpl.serichByName(username);
		 if (b) {
			//存在
			 resp.setContentType("text/html;charset=utf-8");
				PrintWriter out = resp.getWriter();
				out.print("<script>");
				out.print("alert('这个账号已经存在了,换一个试试!');");
				out.print("window.location.href='fromt/register.jsp'");
				out.print("</script>");
		}else {
			//不存在,注册
			Menber menber=new Menber(username,truename,pwd,city,address,postcode,cardno,cardtype,tel,email);
			boolean ok = memberImpl.insert(menber);
			if (ok) {
				//注册成功
				 resp.sendRedirect("fromt/index.jsp");
				 HttpSession session = req.getSession();
					session.setAttribute("user",menber);
			}else {
				 resp.setContentType("text/html;charset=utf-8");
					PrintWriter out = resp.getWriter();
					out.print("<script>");
					out.print("alert('注册失败');");
					out.print("window.location.href='fromt/register.jsp'");
					out.print("</script>");
			}
		}
		 
	}
}
