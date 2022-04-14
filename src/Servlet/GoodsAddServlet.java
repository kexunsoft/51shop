package Servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.dao.goodsDao;
import com.model.goods;
@WebServlet("/GoodsAdd")
public class GoodsAddServlet extends HttpServlet {


	private static final long serialVersionUID = 741923325167289157L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		HttpSession session = req.getSession();
		Object user = session.getAttribute("manager");
		if(user==null) {
			resp.sendError(404);
			return;
		}
		req.setCharacterEncoding("utf-8");
		String ID="";
		
		String goodsName="";
		String supertype="";
		String picture="";
		String price="";
		
		String newGoods="";
		String sale="";
		String introduce="";
		String path=req.getSession().getServletContext().getRealPath("images/goods");
		//获取所有商品信息
		if (!ServletFileUpload.isMultipartContent(req)) {
			PrintWriter out = resp.getWriter();
			out.println("Error: 表单必须包含 enctype=multipart/form-data");
			out.flush();
			return;
		}
		DiskFileItemFactory factory=new DiskFileItemFactory();
		factory.setSizeThreshold(1024 * 1024 * 3);
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
		ServletFileUpload upload=new ServletFileUpload(factory);
		upload.setFileSizeMax(1024 * 1024 * 40);
		upload.setSizeMax(1024 * 1024 * 50);
		upload.setHeaderEncoding("utf-8");
		String fileName="";
		 try {
				List<FileItem> formItems = upload.parseRequest(req);
				
				if (formItems != null && formItems.size() > 0) {
					for (FileItem item : formItems) {
						
						if (!item.isFormField()) {
							  fileName = new File(item.getName()).getName();
							  picture=fileName;
							  File storeFile = new File(path+File.separator+fileName);
							  
							  item.write(storeFile);
							 
						}else {
							//拿到的是文本
							if("ID".equals(item.getFieldName())){
								ID=item.getString("utf-8");
							}
							if("goodsName".equals(item.getFieldName())){
								goodsName=item.getString("utf-8");
							}
							if("supertype".equals(item.getFieldName())){
								supertype=item.getString("utf-8");
							}
							
							if("price".equals(item.getFieldName())){
								price=item.getString("utf-8");
							}
							if("newGoods".equals(item.getFieldName())){
								newGoods=item.getString("utf-8");
								
							}
							if("introduce".equals(item.getFieldName())){
								introduce=item.getString("utf-8");
							}
							if("sale".equals(item.getFieldName())){
								sale=item.getString("utf-8");
							}
						}
					}
					
					
				}
			} catch ( Exception e) {
				
				e.printStackTrace();
			}
		
		
		goods g=new goods(supertype,goodsName,introduce,Double.parseDouble(price),picture,newGoods,sale);
		boolean b = goodsDao.addGoods(g);
		if (b) {
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.print("<script>");
			out.print("alert('添加成功');");
			out.print("window.location.href='manage/index.jsp'");
			out.print("</script>");
		}else {
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.print("<script>");
			out.print("alert('添加失败');");
			out.print("window.location.href='manage/goods_add.jsp'");
			out.print("</script>");
		}
	}
}
