<%@page import="com.dao.NewDao"%>
<%@page import="com.model.News"%>
<%@page import="com.tools.PageBreak"%>
<%@page import="com.model.Comment"%>
<%@page import="com.dao.CommentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>新闻详情-51商城</title>
<link rel="stylesheet" href="css/mr-01.css" type="text/css">

<script src="js/jsArr01.js" type="text/javascript"></script>
<script src="js/module.js" type="text/javascript"></script>
<script src="js/jsArr02.js" type="text/javascript"></script>
<script src="js/tab.js" type="text/javascript"></script>
<style type="text/css">
	.main{
		width: 1000px;
		height:600px;
		margin: 0 auto;
	}
	.dd{
		height: 20px;
	}
	*{
		list-style: none;
	}
	.content{
		width: 100%;
		height:500px;
		font-size: 16px;
		line-height:30px;
		text-indent: 2em;
		 border: 2px solid #C0C0C0;
		 background-color:#F8F8F8;
	}
	.tit{
	font-family:'微软雅黑';
	font-size:20px;
	font-weight:bolder;
		background-color:#E8E8E8;
		height: 50px;
		 line-height: 60px;
		 text-indent: 1em;
		 border: 2px solid #C0C0C0;
		  border-bottom: 0px;
	}
</style>
</head>

<body>
	<jsp:include page="index-loginCon.jsp" />
	<!-- 网站头部 -->
	<%@ include file="common-header.jsp"%>
	<!-- //网站头部 -->
	<div class="main">
		<h1 style="line-height: 50px">新闻详情</h1>
	<%
		
		String id=request.getParameter("id");
		if(id!=null){
		News n=	NewDao.serichNewsByID(id);
			if(n!=null){
	%>
			<div class="tit">
			标题:<%=n.getEn_title()%>
			<span style="margin-right:10px; font-size: 16px;">[发布时间]<%=n.getEn_create_time()%></span>
			
			</div>
			<div class="content">
			<textarea  readonly="readonly" disabled="disabled"  style="width: 100%; height: 100%; resize: none;">
				<%=n.getEn_content() %>	
			</textarea>
				
			</div>
			<%
			}
		}
		%>
	
		
	</div>
	
	<!-- 版权栏 -->
	<%@ include file="common-footer.jsp"%>
	<!-- //版权栏 -->
</body>
</html>