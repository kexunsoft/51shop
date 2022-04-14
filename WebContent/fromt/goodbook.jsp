<%@page import="com.tools.PageBreak"%>
<%@page import="com.model.Comment"%>
<%@page import="com.dao.CommentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>我要留言-51商城</title>
<link rel="stylesheet" href="css/mr-01.css" type="text/css">

<script src="js/jsArr01.js" type="text/javascript"></script>
<script src="js/module.js" type="text/javascript"></script>
<script src="js/jsArr02.js" type="text/javascript"></script>
<script src="js/tab.js" type="text/javascript"></script>
<style type="text/css">
	.main{
		width: 1000px;
		
		margin: 0 auto;
	}
	.dd{
		height: 20px;
	}
	*{
		list-style: none;
	}
</style>
</head>

<body>
	<jsp:include page="index-loginCon.jsp" />
	<!-- 网站头部 -->
	<%@ include file="common-header.jsp"%>
	<!-- //网站头部 -->
	<div class="main">
		<div class="guestbook">
			<h2>全部留言</h2>
			<ul>
			<%
			ArrayList<Comment> list=CommentDao.serichAllComment();
			int pPage=0;
			if(request.getParameter("pPage")==null){
				pPage=1;
			}else{
				pPage=Integer.parseInt(request.getParameter("pPage"));
				if(pPage<1){
					pPage=1;
				}
			}
			
			ArrayList<Comment> flist=PageBreak.fy(pPage, list, 5);
			if(flist!=null){
				for(Comment c:flist){
			%>
				<li>
					<dl>
						<dt style="background-color:#fafafa;"><%=c.getEc_content() %></dt>
						<dd style="height: 20px; width: 300px">网友：<%=c.getEc_nick_name() %> <span ><%=c.getEc_create_time() %></span></dd>
						<dd style="height: 20px;"><%=c.getEc_reply()==null?"":c.getEc_reply() %></dd>
					</dl>
				</li>
				<%
				}
			}
				%>
			</ul>
			<%if(pPage>1){ %>
				<a href="goodbook.jsp?pPage=<%=pPage-1%>">上一页</a>
				<%
				}
				%>
				<span>当前[<%=pPage%>/<%= PageBreak.getPageCount()%>]</span>
				<%if(pPage<PageBreak.getPageCount()){ %>
				<a href="goodbook.jsp?pPage=<%=pPage+1%>">下一页</a>
				<%
				} 
				%>
			
			<div>
				<form action="/shop/CommentAdd" method="post">
					<table >
						<tr >
							<td>昵称：</td>
							<td><input class="text" type="text" name="guestName" style="width: 300px;" required="required"/></td>
						</tr>
						<tr>
							<td >留言标题：</td>
							<td><input class="text" type="text" name="guestTitle" style="width: 300px" required="required"/></td>
						</tr>
						<tr>
							<td >留言内容：</td>
							<td><textarea name="guestContent" style="width: 600px;height: 100px" required="required"></textarea></td>
						</tr>
						<tr>
							<td></td>
							<td><label class="ui-blue"><input type="submit" name="submit" value="提交留言" style=" border: 0px solid; background-color: #E33737; color: white; height: 40px;width: 100px"/></label></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		
	</div>
	
	<!-- 版权栏 -->
	<%@ include file="common-footer.jsp"%>
	<!-- //版权栏 -->
</body>
</html>