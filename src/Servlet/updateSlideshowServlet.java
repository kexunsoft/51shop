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

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.dao.SlideshowDao;
import com.model.Slideshow;
@WebServlet("/updateSlideshow")
public class updateSlideshowServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1195332947438980695L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String img="";
		String title="";
		String href="";
		String id="";
		String path=req.getSession().getServletContext().getRealPath("fromt/images");
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
							  img=fileName;
							  File storeFile = new File(path+File.separator+fileName);
							  
							  item.write(storeFile);
							 
						}else {
							//拿到的是文本
							if("title".equals(item.getFieldName())){
								title=item.getString("utf-8");
							}
							if("href".equals(item.getFieldName())){
								href=item.getString("utf-8");
							}
							if("id".equals(item.getFieldName())){
								id=item.getString("utf-8");
							}
							
						}
					}
					
					
				}
			} catch ( Exception e) {
				
				e.printStackTrace();
			}
		 Slideshow slideshow=new Slideshow(id,title,img,href);
		 boolean b = SlideshowDao.updateSlideshow(slideshow);
		 if (b) {
				resp.setContentType("text/html;charset=utf-8");
				PrintWriter out = resp.getWriter();
				out.print("<script>");
				out.print("alert('修改成功');");
				out.print("window.location.href='manage/slideshow.jsp'");
				out.print("</script>");
			}else {
				resp.setContentType("text/html;charset=utf-8");
				PrintWriter out = resp.getWriter();
				out.print("<script>");
				out.print("alert('修改失败');");
				out.print("window.location.href='manage/slideshow.jsp'");
				out.print("</script>");
			}
	}
}
