<%@page import="com.dao.EvaluateDao"%>
<%@page import="com.model.Evaluate"%>
<%@page import="com.model.Menber"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.dao.goodsDao"%>
<%@page import="com.model.goods"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>51商城</title>
<link rel="stylesheet" href="css/mr-01.css" type="text/css">

<script src="js/jsArr01.js" type="text/javascript"></script>
<script src="js/module.js" type="text/javascript"></script>
<script src="js/jsArr02.js" type="text/javascript"></script>
<script src="js/tab.js" type="text/javascript"></script>
</head>
<%
Menber user= (Menber)session.getAttribute("user");
int uid=0;
if(user!=null){
	uid=user.getID();
}else{
	uid=0;
}
%>
<body>
	<jsp:include page="index-loginCon.jsp" />
	<!-- 网站头部 -->
	<%@ include file="common-header.jsp"%>
	<!-- //网站头部 -->
	<div id="mr-mainbody" class="container mr-mainbody">
		<div class="row">
			<!-- 页面主体内容 -->
			<div id="mr-content"
				class="mr-content col-xs-12 col-sm-12 col-md-9 col-md-push-3">
				<div id="mrshop" class="mrshop common-home">
					<div class="container_oc">
						<div class="row">
							<div id="content_oc" class="col-sm-12 view-product">
								<!-- 根据商品ID获取并显示商品信息 -->
								<%
									String id=request.getParameter("ID");
								if(id==null){
									response.sendError(404);
									return;
								}
					
								String typeSystem=null;
								int goodsID=0;
								if(id!=null){
									//点击数加一
									goodsDao.updateHit(id);
									//查询单个商品
									goods gd=goodsDao.serichGoodsByID(id); 
									if(gd!=null){
									 typeSystem=gd.getTypeID();	
										goodsID=gd.getID();
										
								%>
								<!-- 显示商品详细信息 -->
								<div class="row">
									<div class="col-xs-12 col-md-4 col-sm-4">
										<ul class="thumbnails" style="list-style: none">
											<li><a class="thumbnail" href="#"> <img src="../images/goods/<%=gd.getPicture()%>"></a></li>
										</ul>
									</div>
									<div class="col-xs-12 col-md-8 col-sm-8">
										<div style="margin-left: 30px; margin-top: 20px">
											<h1 class="product-title"><%=gd.getGoodsName() %></h1>
											<ul class="list-unstyled price"><li style="list-style: none;"><h2 style=" color: red;">￥<%=new DecimalFormat("#.00").format(gd.getNowPrice()) %></h2></li></ul>
											<ul class="list-unstyled price"><s>原价: <%=gd.getPrice() %>元</s></ul>
											<div class="rating"><p>商城活动：全场满99包邮</p></div>
											<div id="product"><hr>
												<div class="form-group">
													<label class="control-label" for="shuliang"> 数量 </label>
													<input type="number" name="quantity" value="1" size="2"
														id="shuliang" class="form-control"> <br>
													<div class="btn-group">
														<button type="button" onclick="addCart()" class="btn btn-primary btn-primary">
															<i class="fa fa-shopping-cart"></i> 添加到购物车</button>
														<button type="button" id="button-wishlist" data-toggle="tooltip" class="btn"
														 title="收藏" data-original-title="收藏" onclick="sc(<%=gd.getID() %>)" > <i class="fa fa-heart"></i></button>
													</div>
												</div>
											</div>
										</div>
									</div>
									
									<div class="col-sm-12 description_oc clearfix">
										<ul class="nav nav-tabs htabs">
											<li class="active" style="width: 150px"><a href="#tab-description" data-toggle="tab"
												aria-expanded="true">商品描述</a></li>
										</ul>
										<div class="tab-content" style="border: 1px solid #eee; overflow: hidden;">
											<div class="tab-pane active" id="tab-description">
												<%=gd.getIntroduce() %>
											</div>
										</div>
									</div>
								</div>
									<%
									}
								}
									%>
								<!-- //显示商品详细信息 -->
								<!-- 显示相关商品 -->
								<div>
										<h4>商品评价:</h4>
										<table style="width: 100%">
											<tr>
												<td width="80%">评价</td>
												<td style="border-left-width: 1px">日期</td>
												<td style="border-left-width: 1px">用户</td>
											</tr>
											<%
												ArrayList<Evaluate> list=EvaluateDao.serichEvaluate(id);
												if(list!=null&&list.size()>0){
													for(Evaluate e:list){
											%>
											<tr>
												<td width="80%" style="text-indent: 2em"><%=e.getF_text() %></td>
												<td style="border-left-width: 1px"><%=e.getDate() %></td>
												<td style="border-left-width: 1px"><%=e.getUsername() %></td>
											</tr>
											<%
													}
												}else{
													%>
													<tr>
												<td colspan="3">此商品暂无评价</td>
												
											</tr>
													<%
												}
											%>
											
										</table>
									</div>
								<!-- //显示相关商品 -->
								<!-- //根据商品ID获取并显示商品信息 -->
							</div>
						</div>
					</div>

				</div>
			</div>
			<!-- //页面主体内容 -->
			<!-- 显示左侧热门商品 -->
			<jsp:include page="leftHotGoods.jsp">
				<jsp:param name="typeSystem" value="<%=typeSystem%>" />
			</jsp:include>
			<!-- // 显示左侧热门商品 -->

		</div>
	</div>
	<!-- 版权栏 -->
	<%@ include file="common-footer.jsp"%>
	<!-- //版权栏 -->
<script src="js/jquery.1.3.2.js" type="text/javascript"></script>

<script type="text/javascript">
	function addCart() {
		var num = $('#shuliang').val();			//获取输入的商品数量
		//验证输入的数量是否合法
		if (num < 1) {							//如果输入的数量不合法
			alert('数量不能小于1！');
			return;
		}
		//调用添加购物车页面，实现将该商品添加到购物车
		window.location.href="../cartadd?ID=<%=id%>&num="+num;
	}
	function sc(id){
		if(<%=uid%>!=0){
			$.post("/shop/AddCollect",{uid:<%=uid%>,pid:id},function(data){
				if(data){
				alert(data);
				}
			});
		}else{
			alert("登录以后才能收藏哦");
		}
		
	}
</script>

</body>
</html>
