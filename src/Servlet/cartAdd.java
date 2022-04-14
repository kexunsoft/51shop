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

import com.dao.goodsDao;
import com.model.Gwc;
import com.model.goods;
@WebServlet("/cartadd")
public class cartAdd extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5298185895418571785L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String id=req.getParameter("ID");
		
		int num=Integer.parseInt(req.getParameter("num"));
		
		HttpSession session = req.getSession();
		Object o = session.getAttribute("user");
		
		if (o!=null) {
			//已经登录 
			Gwc gwc=new Gwc();
			goods goods=goodsDao.serichGoodsByID(id);
			gwc.setID(goods.getID());
			gwc.setPrice(goods.getNowPrice());
			gwc.setCount(num);
			gwc.setName(goods.getGoodsName());
			gwc.setPictrue(goods.getPicture());
			HttpSession session2=req.getSession();
			@SuppressWarnings("unchecked")
			ArrayList<Gwc> list2=(ArrayList<Gwc>)session2.getAttribute("cart");
			//默认不存在
			boolean Flag=false;
			//判断购物车是否为空
			if (list2==null) {
				list2=new ArrayList<Gwc>();
			}else {
				
				for(int i=0;i<list2.size();i++) {
				Gwc	gwcitem=list2.get(i);
						//判断集合是否存在这个商品,如果存在就修改他的数量
					if(gwcitem.getID()==Integer.parseInt(id)) {
						
						gwcitem.setCount(gwcitem.getCount()+num);
						list2.set(i,gwcitem);
						Flag=true;
					}
					
				}
				
			}
			if (!Flag) {
				//表示不存在把购物车对象添加到list
				list2.add(gwc);
				
			}
			//添加到session
			HttpSession session3 = req.getSession();
			session3.setAttribute("cart",list2);
			resp.sendRedirect("fromt/cart_see.jsp");
			
		}else {
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.print("<script>");
			out.print("if(confirm('你还没有登录,是否返回登录?')){");
			out.print("window.location.href='fromt/login.jsp'}else{window.location.href='fromt/index.jsp'}");
			out.print("</script>");
		}
		
	}
}
