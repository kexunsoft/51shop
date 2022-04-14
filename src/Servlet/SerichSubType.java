package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tools.DBhelper;
@WebServlet("/SerichSubType")
public class SerichSubType extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3681243780811222878L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String superType=req.getParameter("superID");
		String sql=" select * from tb_subType where superType=?";
		DBhelper db=new DBhelper();
		ResultSet rs = db.find(sql,superType);
		try {
			while (rs.next()) {
				resp.setCharacterEncoding("utf-8");
				resp.setContentType("text/html;charset=utf-8");
				PrintWriter out = resp.getWriter();
				out.println("<option value="+rs.getString("ID")+">"+rs.getString("TypeName")+"</option>");
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
