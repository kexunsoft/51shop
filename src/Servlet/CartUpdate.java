package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Gwc;
@WebServlet("/CartUpdate")
public class CartUpdate extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7786273848208061232L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		HttpSession session1 = req.getSession();
		Object user = session1.getAttribute("user");
		if(user==null) {
			resp.sendError(404);
			return;
		}
		req.setCharacterEncoding("utf-8");
		String id=req.getParameter("id");
		int num=Integer.parseInt(req.getParameter("num"));
		System.out.println(num);
		HttpSession session = req.getSession();
		@SuppressWarnings("unchecked")
		ArrayList<Gwc> list2=(ArrayList<Gwc>)session.getAttribute("cart");
		for(int i=0;i<list2.size();i++) {
			Gwc	gwcitem=list2.get(i);
					//判断集合是否存在这个商品,如果存在就修改他的数量
				if(gwcitem.getID()==Integer.parseInt(id)) {
					
					gwcitem.setCount(num);
					list2.set(i,gwcitem);
					
				}
				
			}
		session.setAttribute("cart",list2);
	}
}
