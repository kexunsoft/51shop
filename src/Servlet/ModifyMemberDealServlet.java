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
@WebServlet("/ModifyMemberDeal")
public class ModifyMemberDealServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2524747279574836260L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		HttpSession session = req.getSession();
		Object user = session.getAttribute("user");
		if(user==null) {
			resp.sendError(404);
			return;
		}
		//获取前台传来的所有数据
		 String username = req.getParameter("username"); 					// 账户属性
		 String truename = req.getParameter("truename"); 	// 真实姓名属性
		 String pwd = req.getParameter("pwd"); 	//原密码
		 String newPwd=req.getParameter("newPwd");//新密码
		 String tel = req.getParameter("tel"); 						// 联系电话属性
		 String email = req.getParameter("email"); 						// 邮箱属性
		 MemberImpl memberImpl=new MemberImpl();
		 Menber menber=	memberImpl.serichByNameAndPWD(username,pwd);
		 if(menber!=null) {
			 //存在这个用户
			 //执行修改
			 Menber m=new Menber(username,truename,pwd,tel,email);
			 boolean b = memberImpl.updateByUserName(m);
			 if (b) {
				 resp.setContentType("text/html;charset=utf-8");
					PrintWriter out = resp.getWriter();
					out.print("<script>");
					out.print("alert('修改成功');");
					out.print("window.location.href='fromt/login.jsp'");
					out.print("</script>");
			}
			 
			 
		 }else {
			 resp.setContentType("text/html;charset=utf-8");
				PrintWriter out = resp.getWriter();
				out.print("<script>");
				out.print("alert('原密码不正确');");
				out.print("window.location.href='fromt/modifyMember.jsp'");
				out.print("</script>");
		}
		 
	}
	
	
	
	
}
