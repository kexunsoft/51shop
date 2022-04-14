package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.OrderDao;
import com.dao.orderDetailDao;
import com.model.Gwc;
import com.model.Menber;
import com.model.Order;
import com.model.OrderDetail;
@WebServlet("/cartOrder")
public class cartOrder extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8843049112324627997L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//判断用户是否登录
		if (req.getSession().getAttribute("user")==null) {
			 	resp.setContentType("text/html;charset=utf-8");
				PrintWriter out = resp.getWriter();
				out.print("<script>");
				out.print("if(confirm('你还没有登录,是否返回登录?')){");
				out.print("window.location.href='fromt/login.jsp'}else{window.location.href='fromt/index.jsp'}");
				out.print("</script>");
				return;
		}
		//判断购物车是否有东西
		if(req.getSession().getAttribute("cart")==null) {
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.print("<script>");
			out.print("alert('购物车是空的,再去逛逛吧');");
			out.print("window.location.href='fromt/index.jsp'");
			out.print("</script>");
			return;
		}
		//保存订单
		//获取所有信息
		String recevieName=req.getParameter("recevieName");
		String tel=req.getParameter("tel");
		String address=req.getParameter("address");
		String bz=req.getParameter("bz");
		//生成id号
		SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMddHHmmSS");
		String orderID = format1.format(new Date());
		ArrayList<Gwc> list=(ArrayList<Gwc>)req.getSession().getAttribute("cart");
		Menber menber=(Menber)req.getSession().getAttribute("user");
		String username=menber.getUsername();
		Order order=new Order(orderID,String.valueOf(list.size()),username,recevieName,address,tel,bz);
		 orderID = OrderDao.insertOrder(order);
		
		 if (orderID!="") {
			//保存订单明细
			 boolean b=false;
			 for(int i=0;i<list.size();i++) {
				 //循环插入session(购物车)里的数据
				 Gwc g=list.get(i);
				 OrderDetail orderDetail=new OrderDetail(orderID,String.valueOf(g.getID()),String.valueOf(g.getPrice()),String.valueOf(g.getCount()));
				  b = orderDetailDao.InsertOrderDetail(orderDetail);
				
			 }
			 if (b) {
				 //销毁sesstion
				HttpSession session = req.getSession();
				session.removeAttribute("cart");
				 resp.setContentType("text/html;charset=utf-8");
					PrintWriter out = resp.getWriter();
					out.print("<script>");
					out.print("alert('您的订单号为"+orderID+"');");
					out.print("window.location.href='fromt/index.jsp'");
					out.print("</script>");
			}
		}
		
	}
}
