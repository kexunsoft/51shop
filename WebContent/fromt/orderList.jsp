<%@page import="com.tools.OrderStatus"%>
<%@page import="com.model.orderList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.model.Menber"%>
<%@page import="com.dao.OrderDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="java.sql.*"%>
<%@ page import="java.util.Vector"%>

<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>我的购物车-51商城</title>
<link rel="stylesheet" href="css/mr-01.css" type="text/css">

<script src="js/jsArr01.js" type="text/javascript"></script>
<script src="js/module.js" type="text/javascript"></script>
<script src="js/jsArr02.js" type="text/javascript"></script>
<script src="js/tab.js" type="text/javascript"></script>
<script src="js/jquery.1.3.2.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jBox/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="js/jBox/jquery.jBox-2.3.min.js"></script>
	<link type="text/css" rel="stylesheet" href="js/jBox/Skins2/Pink/jbox.css" />
<style type="text/css">
tr td{
padding: 10px 5px;
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
			<!-- 显示订单列表 -->
			<div id="mr-content" class="mr-content col-xs-12">
				<div id="mrshop" class="mrshop common-home">
					<div class="container_oc">
						<div class="row">
							<div id="content_oc" class="col-sm-12">
								<h1>我的订单</h1>
									<div class="table-responsive cart-info">
										<table class="table table-bordered" >
											<thead>
												<tr>
													<td class="text-center image" >订单号</td>
													<td class="text-center name">产品名称</td>
													<td class="text-center name">购买数量</td>
													<td class="text-center name">单价</td>
													<td class="text-center name">消费金额</td>
													<td class="text-center quantity">收货人姓名</td>
													<td class="text-center price">收货人手机</td>
													<td >下单日期</td>
													<td class="text-center total">订单状态</td>
													<td class="text-center total" >操作</td>
													
												</tr>
											</thead>
											<tbody>
												<!-- 循环显示 -->
												<%
												int maxpage=0;
												int pg=0;
											Menber user=(Menber)session.getAttribute("user");
												if(user!=null){
												ArrayList<orderList> list=OrderDao.serichOrderByUserName(user.getUsername());
												
												
													if(list!=null&&list.size()>0){
														 maxpage=list.size()%10==0?list.size()/10:(list.size()/10)+1;
														
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
														 
														
														int start=10*(pg-1);
														int end=0;
														if(list.size()-start>=10){
														end=start+10;
															
														}else{
															end=list.size();
														}
														
														for(int i=start;i<end;i++){
														orderList ol=list.get(i);
												%>
												<tr>
													<td class="text-center image" width="10%" style="padding: 10px 10px;"><%=ol.getOrderID() %>
													</td>
													<td class="text-center name"><%=ol.getGoodName() %></td>
													<td class="text-center quantity"><%=ol.getGoodnumber() %>件</td>
													<td class="text-center quantity"><%=ol.getPrice() %></td>
													<td class="text-center quantity"><%=Integer.valueOf(ol.getGoodnumber())*Double.valueOf(ol.getPrice()) %></td>
													<td class="text-center quantity"><%=ol.getRecevieName() %></td>
													<td class="text-center quantity"><%=ol.getTel()%></td>
													<td ><%=ol.getOrderDate() %></td>
													<td><%=OrderStatus.values()[ol.getStatus()-1] %></td>
													<td>
													<a <%=ol.getStatus()==4?"href=javascript:pj("+ol.getGoodsID()+")":"href=javascript:ock("+ol.getDid()+")" %> style="background-color: #E33737;border-color: #a30a11; color: white; padding: 5px 10px; border-radius: 5px;padding: 3px;"><%=ol.getStatus()==4?"评价":"确认收货" %></a>
													<a href="/shop/OrderSee.html?text=<%=ol.getOrderNumber() %>" style="background-color: #00CCFF;border-color: #a30a11; color: white; padding: 5px 10px; border-radius: 5px;padding: 3px;">物流信息</a>
													</td>
													
												</tr>
												<%
														}
													}else{
														%>
														<tr>
															<td class="text-center image" width="10%" colspan="10">您还没有订单哦</td>
														</tr>
														<% 
													}
												}else{
													%>
													<script type="text/javascript">
													alert("请先登录");
													window.location.href="login.jsp";
													</script>
													<% 
												}
												
												%>
												<!-- 循环显示 -->
												<tr>
													 <td height="30" align="right" colspan="10">当前页数：[<%=pg %>/<%=maxpage %>]&nbsp;
	<%
	if(pg>1){
	%>
	<a href="orderList.jsp?page=1">第一页</a>　<a href="orderList.jsp?page=<%=pg-1%>">上一页</a>
	<%
	}
	if(pg<maxpage){
	%>	
	　<a href="orderList.jsp?page=<%=pg+1%>">下一页</a>　<a href="orderList.jsp?page=<%=maxpage%>">最后一页&nbsp;</a>
	<%
	}
	%>
	</td>
												</tr>
											</tbody>
										</table>
									</div>
							</div>
						</div>
						<br /><br />
						<div class="row">
							<div id="content_oc" class="col-sm-12">
								<br />
								<br />
								<div class="buttons">
									<div class="pull-right">
										<a href="index.jsp" class="tigger btn btn-primary btn-primary">继续购物</a>
									</div>
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>
		<!-- //显示订单列表 -->
		</div>
	</div>
	
	<!-- 版权栏 -->
	<%@ include file="common-footer.jsp"%>
	<!-- //版权栏 -->
</body>
<script type="text/javascript">
	function ock(oid){
		if(confirm("请检查您的商品是否收到,此操作不给予撤回")){
		$.post("/shop/OrderUpdate?orderID="+oid+"&status=4",function(data){if(data=="true"){ location.reload();}});
	}
	}
	function pj(id){
		
		var html=
			'<form action="/shop/addEvaluate" method="post" id="from1">'
			+'<div class="popup_cont">'
			+ '<h4>商品评价</h4>'
			+ '<p>评级:&nbsp;&nbsp;好评:<input type="radio" value="1" name="pj" checked="checked">&nbsp;&nbsp;一般:<input type="radio" value="1" name="pj">&nbsp;&nbsp;差评:<input type="radio" value="1" name="pj"></p>'
			+'<input type="hidden" value='+id+' name="pid" checked="checked">'
			+'<textarea style="width:392px; hight:257px;resize:none;" name="text"></textarea>'
			+ '</div></form>';
		var content = {
				state1 : {
					content : html,
					buttons : {
						'取消' : 0,
						'确认' : 1
					},
					buttonsFocus : 0,
					submit : function(v, h, f) {
						if (v == 0) {//取消按钮的响应事件
							return true; //关闭窗口
						}
						if (v == 1) {//支付按钮的响应事件
							if(from1.text.value==""){
								
								alert("内容不能为空");
								
							}else{
								document.getElementById('from1').submit();
							}
							
							return true;
						}
						return false;
					}
				}
		};
		$.jBox.open(content, '评价', 410, 300);
	}
	
</script>
</html>

