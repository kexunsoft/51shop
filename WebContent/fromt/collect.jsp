<%@page import="com.model.Menber"%>
<%@page import="com.dao.CollectDao"%>
<%@page import="com.model.Collect"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.model.Gwc"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 
Menber user=(Menber)session.getAttribute("user");
int uid=0;
	if(user==null){
		uid=0;
		%>
		<script type="text/javascript">
		
		if(confirm('你还没有登录,是否返回登录?')){
		window.location.href='login.jsp';
		}else{
			window.location.href='index.jsp';
		}
		
		</script>
		<% 
		
	}else{
		uid=user.getID();
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>我的收藏-51商城</title>
<link rel="stylesheet" href="css/mr-01.css" type="text/css">


<script src="js/module.js" type="text/javascript"></script>
<script src="js/jsArr02.js" type="text/javascript"></script>
<script src="js/tab.js" type="text/javascript"></script>
<script src="js/jquery.1.3.2.js" type="text/javascript"></script>
<style type="text/css">
	.btn_reduce {
    height: 20px;
    width: 20px;
    border: 1px solid #CCCCCC;
    background: transparent;
    border-radius: 2px;
    outline: 0px;
    margin: 0px;
    padding: 0px;
    text-decoration: none;
    list-style: none;
    font-size: 12px;
    font-family: Arial;
}
.momey_input {
    border-radius: 5px;
    outline: 0px;
    height: 20px;
    width: 50px;
    border: 1px solid #CCCCCC;
    text-align: center;
    margin: 0px;
    padding: 0px;
    text-decoration: none;
    list-style: none;
    font-size: 12px;
    font-family: Arial;
    background-color: white;

}
.btn_add {
    height: 20px;
    width: 20px;
    border: 1px solid #CCCCCC;
    background: transparent;
    border-radius: 2px;
    outline: 0px;
    margin: 0px;
    padding: 0px;
    text-decoration: none;
    list-style: none;
    font-size: 12px;
    font-family: Arial;

}

</style>
</head>

<body>
	<jsp:include page="index-loginCon.jsp" />
	<!-- 网站头部 -->
	<%@ include file="common-header.jsp"%>
	<!-- //网站头部 -->
	<div id="mr-mainbody" class="container mr-mainbody">
		<div class="row">
			<!-- 页面主体内容 -->
			<div id="mr-content" class="mr-content col-xs-12">
				<div id="mrshop" class="mrshop common-home">
					<div class="container_oc">
						<div class="row">
							<div id="content_oc" class="col-sm-12">
								<h1>我的收藏</h1>
								<!-- 显示购物车中的商品 -->
								<div class="table-responsive cart-info" style="height: 500px" id="tb1">
									<table class="table table-bordered">
										<thead>
											<tr>
												<td class="text-center image">商品图片</td>
												<td class="text-left name">商品名称</td>
												
												<td class="text-right price">单价</td>
												<td class="text-right price">操作</td>
											</tr>
										</thead>
										<tbody>
										<!-- 遍历购物车中的商品并显示 -->
											<%
											double sum=0;
												//从session里去取
											ArrayList<Collect> list=CollectDao.serichCollect(uid);
											for(int i=0;i<list.size();i++){
												Collect c=list.get(i);
												
											%>
											<!-- 显示一条商品信息 -->
											<tr id="<%=c.getId()%>">
												<td class="text-center image" width="20%"><a href="/shop/serichProduct?ID=<%=c.getPid()%>">
													<img width="80px" src="../images/goods/<%=c.getPctrue()%>"> </a></td>
												<td class="text-left name"><a
													href="/shop/serichProduct?ID=<%=c.getPid()%>"><%=c.getName() %></a>
												</td>
												
												<td class="text-right price"><%=c.getPrice()%></td>
												<td class="text-right price" >
													<a href="javascript:del('<%=c.getId()%>')">删除</a>
													<a href="../cartadd?ID=<%=c.getPid()%>&num=1">添加到购物车</a>
												</td>
												
											</tr>
											<!-- 显示一条商品信息 -->
			<%
											}
			%>
											<!-- //遍历购物车中的商品并显示 -->
										</tbody>
									</table>
								</div>
								<!-- //显示购物车中的商品 -->
						
							</div>
						</div>

					</div>
				</div>
			</div>
			<!-- //页面主体内容 -->
		</div>
	</div>
	<!-- 版权栏 -->
	<%@ include file="common-footer.jsp"%>
	<!-- //版权栏 -->

	<!-- 使用jBox插件实现一个支付对话框 -->
	<script type="text/javascript" src="js/jBox/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="js/jBox/jquery.jBox-2.3.min.js"></script>
	<script type="text/javascript">
		function del(id){
			if(confirm("确定要删除这条收藏吗?")){
				$.get("/shop/delcollect",{id:id},function(data){
					if(data){
						alert(data);
						location.reload();
					}
				});
			}
			
		}
	</script>

</body>
</html>
