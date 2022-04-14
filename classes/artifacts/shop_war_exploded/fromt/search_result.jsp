<%@page import="java.text.DecimalFormat"%>
<%@page import="com.tools.ChStr"%>
<%@page import="com.tools.PageBreak"%>
<%@page import="com.model.goods"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dao.goodsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.ResultSet"%><%-- 导入java.sql.ResultSet类 --%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>图书列表-51商城</title>
<link rel="stylesheet" href="css/mr-01.css" type="text/css">

<script src="js/jsArr01.js" type="text/javascript"></script>
<script src="js/module.js" type="text/javascript"></script>
<script src="js/jsArr02.js" type="text/javascript"></script>
<script src="js/tab.js" type="text/javascript"></script>
</head>

<body>
	<jsp:include page="index-loginCon.jsp" />
	<!-- 网站头部 -->
	<%@ include file="common-header.jsp"%>
	<!-- //网站头部 -->
	<div id="mr-mainbody" class="container mr-mainbody">
		<div class="row">

			<!-- 显示搜索到的图书列表 -->
			<div id="mr-content"
				class="mr-content col-xs-12 col-sm-12 col-md-9 col-md-push-3">

				<div id="system-message-container" style="display: none;"></div>

				<div id="mrshop" class="mrshop common-home">
					<div class="container_oc">
						<ul class="breadcrumb">
						</ul>
						<div class="row">
							<div id="content_oc" class="col-sm-12">
								<div class="box_oc">
									<div class="box-heading">
										<h1 class="mrshop_heading_h1">搜索结果</h1>
									</div>
									<div class="box-content1">
										<hr>
										<div class="row">
											<!-- 循环显示 -->
											<%
											request.setCharacterEncoding("utf-8");
											String serichName=request.getParameter("searchword");
											if(serichName==null){
												return;
											}
											int pPage=0;
											if(request.getParameter("pPage")==null){
												pPage=1;
											}else{
												pPage=Integer.parseInt(request.getParameter("pPage"));
												if(pPage<1){
													pPage=1;
												}
											}
											
									
										
											String str= new String(serichName.getBytes("iso-8859-1"),"utf-8");
											
											
											ArrayList<goods> list=goodsDao.serichByName(str);
											ArrayList<goods> glist=PageBreak.fy(pPage, list, 12);
											if(list==null){out.println("无法连接到数据库服务器");return;}
											if(glist!=null&&glist.size()>0){
												for(int i=0;i<glist.size();i++){
													goods g=glist.get(i);
											%>
											<div
												class="product-layout product-grid col-lg-3 col-md-3 col-sm-6 col-xs-12">
												<div class="product-thumb">
													<div class="actions">
														<div class="image">
															<a href="/shop/serichProduct?ID=<%=g.getID()%>"><img
																src="../images/goods/<%=g.getPicture()%>"
																class="img-responsive"> </a>
														</div>
														<div class="button-group btn-grid">
															<div class="cart">
																<button class="btn btn-primary btn-primary"
																	type="button" data-toggle="tooltip"
																	onclick='javascript:window.location.href="../cartadd?ID=<%=g.getID() %>&num=1"; '
																	style="display: none; width: 33.3333%;"
																	data-original-title="添加到购物车">
																	<i class="fa fa-shopping-cart"></i>
																</button>
															</div>
															<div class="wishlist">
																<button class="btn" type="button" data-toggle="tooltip"
																	title="收藏">
																	<i class="fa fa-heart"></i>
																</button>
															</div>
														</div>
													</div>
													<div>
														<div class="caption">
															<div class="name">
																<a href="/shop/serichProduct?ID=<%=g.getID() %>" style="width: 95%">
																	<span style="color: #0885B1">品名：</span><%=g.getGoodsName() %></a>
															</div>
															<p class="price">
																
																<span class="price-tax">价格:<%=new DecimalFormat("#.00").format(g.getNowPrice())%>元
																</span>
															</p>
														</div>

													</div>
												</div>
											</div>
											<%
												}
											}
											%>
											<!-- 循环显示 -->
										</div>
										<div class="row pagination">
											<table width="100%" border="0" cellspacing="0"
												cellpadding="0">
												<tr>
												<%if(pPage>1){ %>
				<a href="search_result.jsp?pPage=<%=pPage-1%>&searchword=<%=str%>">上一页</a>
				<%
				}
				%>
				<span>当前页[<%=pPage%>/<%=PageBreak.getPageCount() %>]</span>
				<%if(pPage<PageBreak.getPageCount()){ %>
				<a href="search_result.jsp?pPage=<%=pPage+1%>&searchword=<%=str%>">下一页</a>
				<%
				} 
				%>
												</tr>
											</table>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- //显示搜索到的图书列表-->
			<!-- 显示左侧热门商品 -->
			<jsp:include page="leftHotGoods.jsp" />
			<!-- // 显示左侧热门商品 -->

		</div>
	</div>
	<!-- 版权栏 -->
	<%@ include file="common-footer.jsp"%>
	<!-- //版权栏 -->
</body>
</html>