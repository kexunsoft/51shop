<%@page import="com.model.Slideshow"%>
<%@page import="com.dao.SlideshowDao"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.dao.NewDao"%>
<%@page import="com.model.News"%>
<%@page import="com.dao.goodsDao"%>
<%@page import="com.model.goods"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>首页-51商城</title>
<link rel="stylesheet" href="css/mr-01.css" type="text/css">
<script src="js/jsArr01.js" type="text/javascript"></script>
<script src="js/module.js" type="text/javascript"></script>
<script src="js/jsArr02.js" type="text/javascript"></script>
<script src="js/tab.js" type="text/javascript"></script>
<style type="text/css">

</style>
</head>

<body>
	<jsp:include page="index-loginCon.jsp" />
	<!-- 网站头部 -->
	<%@ include file="common-header.jsp"%>
	<!-- //网站头部 -->
	<!-- 轮播广告及热门商品 -->
	<div class="container mr-sl mr-sl-1">
		<div class="mr-spotlight mr-spotlight-1  row">
			<!-- 显示轮播广告 -->
			<div
				class=" col-lg-9 col-md-12  col-sm-3 hidden-sm   col-xs-6 hidden-xs ">
				<div class="mr-module module " id="Mod159">
					<div class="module-inner">
						<div class="module-ct">
							<div class="mijoshop">
								<div class="container_oc">
									<div class="slideshow">
										<div id="slidershow" class="nivoSlider">
										<!-- 查询 -->
										<%
										ArrayList<Slideshow> Slideshow=SlideshowDao.serichAllSlideshow();
										if(Slideshow!=null&&Slideshow.size()>0){
											for( Slideshow s: Slideshow){
										%>
											
											 <a href="<%=s.getHref() %>" class="nivo-imageLink" style="display: none;">
												<img src="images/<%=s.getImg() %>" class="img-responsive"
												style="display: none;">
											</a>
											<%
											}
										}else{
											%>
											<a href="#" class="nivo-imageLink" style="display: block;"><img
												src="images/1.jpg" class="img-responsive"
												style="display: none;"> 
											</a>
											<% 
										}
											%>
										</div>
									</div>
									<script type="text/javascript">
										//实现调用幻灯片插件轮播广告
										<!--
										jQuery(document).ready(function() {
											jQuery('#slidershow').nivoSlider();
										});
									//-->
									</script>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- 显示热门商品 -->
			<div
				class="col-lg-3  col-md-6 hidden-md   col-sm-3 hidden-sm   col-xs-6 hidden-xs ">
				<div class="mr-module module highlight " id="Mod160">
					<div class="module-inner">
						<h3 class="module-title ">
							<span>商城快讯</span>
						</h3>
						<div class="module-ct">
							<div class="mijoshop">
								<div class="container_oc">
										<ul>
											<%
										ArrayList<News> nlist=NewDao.serichAllNews();
											if(nlist!=null){
												for(News n:nlist){
											%>
											<li style="list-style: none; position: relative; left:-20px; color: gray; "><a href="news.jsp?id=<%=n.getEn_id() %>" id="a1" style="color: gray; font-family: '微软雅黑';font-size: 14px; direction: inherit; text-decoration:none; ">[<%=n.getEn_title().length()>0?n.getEn_title().substring(0, 2)+"..":n.getEn_title() %>]<%=n.getEn_content().length()>10?n.getEn_content().substring(0, 10)+"...":n.getEn_content() %></a></li>
											<%
												}
											}
											%>
										</ul>
									
								
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- // 显示热门商品 -->
		</div>
	</div>
	<!-- //轮播广告及热门商品  -->
	<!-- 最新上架及打折商品展示 -->
	<nav class="container mr-masstop  hidden-sm hidden-xs">
	<div class="custom">
		<div>
			<div class="ja-tabswrap default" style="width: 100%;">
				<div id="myTab" class="container">

					<h3 class="index_h3">
						<span class="index_title">最新上架</span>
					</h3>
					<!-- //最新上架选项卡 -->
					<div class="ja-tab-content ja-tab-content col-6 active"
						style="opacity: 1; width: 100%; visibility: visible;">
						<div class="ja-tab-subcontent">
							<div class="mijoshop">
								<div class="container_oc">
									<div class="row">
									<%
										ArrayList<goods> list=goodsDao.serichByNewGoods();
										
										for(int i=0;i<list.size();i++){
										goods goods=list.get(i);
									%>
									
										<!-- 循环显示最新上架商品 ：添加12条商品信息-->
												<div
													class="product-grid col-lg-2 col-md-3 col-sm-6 col-xs-12">
													<div class="product-thumb transition">
														<div class="actions">
															<div class="image">
																<a href="/shop/serichProduct?ID=<%=goods.getID()%>">
																<img src="../images/goods/<%=goods.getPicture()%>" alt="<%=goods.getGoodsName()%>" class="img-responsive"></a>
															</div>
															<div class="button-group">
																<div class="cart">
																	<button class="btn btn-primary btn-primary" type="button" data-toggle="tooltip"
																		onclick='javascript:window.location.href="../cartadd?ID=<%=goods.getID()%>&num=1"; '
																		style="display: none; width: 33.3333%;" data-original-title="加入到购物车">
																		<i class="fa fa-shopping-cart"></i>
																	</button>
																</div>
															</div>
														</div>
														<div class="caption">
															<div class="name" style="height: 30px">
																<a href="/shop/serichProduct?ID=<%=goods.getID()%>"> <span style="color: #0885B1"></span><%=goods.getGoodsName()%></a>
															</div>
															<div class="name" style="margin-top: 10px"><p class="price">价格：<%= new DecimalFormat("#.00").format(goods.getNowPrice()) %>元</p></div>
														</div>
													</div>
												</div>
												<%
										}
									%>
										<!-- //循环显示最新上架商品：添加12条商品信息 -->
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- //最新上架选项卡 -->
					<!-- 打折商品选项卡 -->
					<h3 class="index_h3"><span class="index_title">打折商品</span></h3>
					<div class="ja-tab-subcontent">
						<div class="mijoshop">
							<div class="container_oc">
								<div class="row">
								<% 
								ArrayList<goods> list2=goodsDao.serichByZheGoods();
								for(int i=0;i<list2.size();i++){
									goods goods=list2.get(i);
								%>
									<!-- 循环显示打折商品 ：添加12条商品信息-->
										<div
													class="product-grid col-lg-2 col-md-3 col-sm-6 col-xs-12">
													<div class="product-thumb transition">
														<div class="actions">
															<div class="image">
																<a href="/shop/serichProduct?ID=<%=goods.getID()%> "><img src="../images/goods/<%=goods.getPicture()%>"
																	alt="<%=goods.getGoodsName()%>" class="img-responsive"> </a>
															</div>
															<div class="button-group">
																<div class="cart">
																	<button class="btn btn-primary btn-primary" type="button" data-toggle="tooltip"
																		onclick='javascript:window.location.href="../cartadd?ID=<%=goods.getID()%>&num=1"; '
																		style="display: none; width: 33.3333%;" data-original-title="加入到购物车">
																		<i class="fa fa-shopping-cart"></i>
																	</button>
																</div>
															</div>
														</div>
														<div class="caption">
															<div class="name" style="height: 30px">
																<a href="/shop/serichProduct?ID=<%=goods.getID()%>"
																	style="width: 95%"> <span style="color: #0885B1"></span><%=goods.getGoodsName()%></a>
															</div>
															<div class="name" style="margin-top: 10px">
																<span class="price"> 现价：<%=new DecimalFormat("#.00").format(goods.getNowPrice()) %> 元</span><br> <span class="oldprice">原价<%=new DecimalFormat("#.00").format(goods.getPrice()) %> 元</span>
															</div>
														</div>
													</div>
												</div>
												<%
								}
												%>
									<!-- 循环显示打折商品 ：添加12条商品信息-->
								</div>
							</div>
						</div>
					</div>
					
				<!-- //打折商品 选项卡-->
			</div>
			<h3 class="index_h3"><span class="index_title">热门商品</span></h3>
					<div class="ja-tab-subcontent">
						<div class="mijoshop">
							<div class="container_oc">
								<div class="row">
								<% 
								ArrayList<goods> list3=goodsDao.serichByRmGoods();
								for(int i=0;i<list3.size();i++){
									goods goods=list3.get(i);
								%>
									<!-- 循环显示rem商品 ：添加12条商品信息-->
										<div
													class="product-grid col-lg-2 col-md-3 col-sm-6 col-xs-12">
													<div class="product-thumb transition">
														<div class="actions">
															<div class="image">
																<a href="/shop/serichProduct?ID=<%=goods.getID()%> "><img src="../images/goods/<%=goods.getPicture()%>"
																	alt="<%=goods.getGoodsName()%>" class="img-responsive"> </a>
															</div>
															<div class="button-group">
																<div class="cart">
																	<button class="btn btn-primary btn-primary" type="button" data-toggle="tooltip"
																		onclick='javascript:window.location.href="../cartadd?ID=<%=goods.getID()%>&num=1"; '
																		style="display: none; width: 33.3333%;" data-original-title="加入到购物车">
																		<i class="fa fa-shopping-cart"></i>
																	</button>
																</div>
															</div>
														</div>
														<div class="caption">
															<div class="name" style="height: 30px">
																<a href="/shop/serichProduct?ID=<%=goods.getID()%>"
																	style="width: 95%"> <span style="color: #0885B1"></span><%=goods.getGoodsName()%></a>
															</div>
															<div class="name" style="margin-top: 10px">
																<span class="price">价格:<%=new DecimalFormat("#.00").format(goods.getNowPrice()) %> 元</span>
															</div>
														</div>
													</div>
												</div>
												<%
								}
												%>
									<!-- 循环显示打折商品 ：添加12条商品信息-->
								</div>
							</div>
						</div>
					</div>
				</div>
		</div>
	</div>
	</nav>
	<!-- //最新上架及打折商品展示 -->
	<!-- 版权栏 -->
	<%@ include file="common-footer.jsp"%>
	<!-- //版权栏 -->
</body>
</html>