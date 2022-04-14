<%@page import="com.model.Menber"%>
<%@page import="com.model.Menage"%>
<%@page import="com.dao.goodsDao"%>
<%@page import="com.model.goods"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.ResultSet"%><%-- 导入java.sql.ResultSet类 --%>
<%-- 创建com.tools.ConnDB类的对象 --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>商品列表-51商城</title>
<link rel="stylesheet" href="css/mr-01.css" type="text/css">

<script src="js/jsArr01.js" type="text/javascript"></script>
<script src="js/module.js" type="text/javascript"></script>
<script src="js/jsArr02.js" type="text/javascript"></script>
<script src="js/tab.js" type="text/javascript"></script>
</head>
<%
String ID=request.getParameter("type");
if(ID==null){
	return;
}
SuperType s=SuperTypeDao.serichTypeByID(ID);  
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
			<!-- //分页显示图书列表 -->
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
										<h1 class="mrshop_heading_h1"><%=s.getTypeName()%></h1>
									</div>
									<div class="box-content">
										<hr>
										<div class="row">
										<!-- 循环 -->
										<%
										ArrayList<goods> list=goodsDao.serichByGoodsSuperType(ID);
										
										if(list==null){return;}
										int maxpage=list.size()%12==0?list.size()/12:(list.size()/12)+1;
										int pg=0;
										if(request.getParameter("page")==null){
											
											pg=1;
											
										}else{
											pg=Integer.valueOf(request.getParameter("page"));
											if(pg<=1){
												pg=1;
											}
											if(pg>=maxpage){
												pg=maxpage;
											}
											
										}
										 
										
										int start=12*(pg-1);
										int end=0;
										if(list.size()-start>12){
										end=start+12;
											
										}else{
											end=list.size();
										}
										for(int i=start;i<end;i++){
											goods g=list.get(i);
										%>
											<div
												class="product-layout product-grid col-lg-3 col-md-3 col-sm-6 col-xs-12">
												<div class="product-thumb">
													<div class="actions">
														<div class="image">
															<a style="width: 95%" href="/shop/serichProduct?ID=<%=g.getID() %>"><img
																src="../images/goods/<%=g.getPicture() %>"
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
																	title="收藏" onclick="sc(<%=g.getID()%>)">
																	<i class="fa fa-heart"></i>
																</button>
															</div>
														</div>
													</div>
													<div>
														<div class="caption">
															<div class="name">
																<a href="/shop/serichProduct?ID=<%=g.getID() %>" style="width: 95%">
																	<span style="color: #0885B1">名称：</span><%=g.getGoodsName() %></a>
															</div>

															<p class="price">
																
																<span class="price-tax">价格: <%=g.getNowPrice()%>元
																</span>
															</p>
														</div>

													</div>
												</div>
											</div>
											<%
										}
											%>
										<!-- 循环 -->
										</div>
										<div class="row pagination">
											<table width="100%" border="0" cellspacing="0"
												cellpadding="0">
												<tr>
													 <td height="30" align="right">当前页数：[<%=pg %>/<%=maxpage %>]&nbsp;
	<%
	if(pg>1){
	%>
	<a href="goodsList.jsp?page=1&type=<%=ID%>">第一页</a>　<a href="goodsList.jsp?page=<%=pg-1%>&type=<%=ID%>">上一页</a>
	<%
	}
	if(pg<maxpage){
	%>	
	　<a href="goodsList.jsp?page=<%=pg+1%>&type=<%=ID%>">下一页</a>　<a href="goodsList.jsp?page=<%=maxpage%>&type=<%=ID%>">最后一页&nbsp;</a>
	<%
	}
	%>
	</td>
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
			<!-- //分页显示图书列表 -->
			<!-- 显示左侧热门商品 -->
			<jsp:include page="leftHotGoods.jsp">
				<jsp:param name="type" value="type" />
			</jsp:include>
			<!-- // 显示左侧热门商品 -->
		</div>
	</div>
	<!-- 版权栏 -->
	<%@ include file="common-footer.jsp"%>
	<!-- //版权栏 -->
</body>
<script src="js/jquery.1.3.2.js" type="text/javascript"></script>
<script type="text/javascript">
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
</html>