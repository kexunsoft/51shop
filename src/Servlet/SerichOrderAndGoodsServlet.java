package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EvaluateDao;
import com.dao.goodsDao;
import com.dao.orderDetailDao;
@WebServlet("/SerichOrderAndGoods")
public class SerichOrderAndGoodsServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7012468766750246974L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int count = goodsDao.SerichGoodsCount();
		int dcount=orderDetailDao.serichOrderstutas(1);
		int wcount=orderDetailDao.serichOrderstutas(4);
		int ncount=orderDetailDao.serichOrderstutas(3);
		double cje = orderDetailDao.serichOrderSumPrice();
		int pj=EvaluateDao.serichCount();
		DecimalFormat decimalFormat=new DecimalFormat("#.00");
		System.out.println(count);
		resp.setContentType("text/html;charset=utf-8");
		resp.setHeader("Access-Control-Allow-Origin","*");
		PrintWriter out = resp.getWriter();
		out.write("<span id='count'>"+count+"个</span>");
		out.write("<span id='dcount'>"+dcount+"个</span>");
		out.write("<span id='wcount'>"+wcount+"个</span>");
		out.write("<span id='ncount'>"+ncount+"个</span>");
		out.write("<span id='cje'>"+decimalFormat.format(cje)+"元</span>");
		out.write("<span id='pj'>"+pj+"条</span>");
		
	}
}
