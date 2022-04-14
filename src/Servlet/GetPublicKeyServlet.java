package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tools.RASTest;
@WebServlet("/GetPublicKey")
public class GetPublicKeyServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8818146658547170263L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		String publicKey = RASTest.getPublicKey();
		out.write(publicKey);
	}
}
