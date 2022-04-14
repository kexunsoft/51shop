<%@page import="java.text.DecimalFormat"%>
<%@page import="com.model.Gwc"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 
	if(session.getAttribute("user")==null){
		%>
		<script type="text/javascript">
		
		if(confirm('你还没有登录,是否返回登录?')){
		window.location.href='login.jsp';
		}else{
			window.location.href='index.jsp';
			}
		
		</script>
		<% 
		
	}
%>

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
								<h1>我的购物车</h1>
								<!-- 显示购物车中的商品 -->
								<div class="table-responsive cart-info">
									<table class="table table-bordered">
										<thead>
											<tr>
												<td class="text-center image">商品图片</td>
												<td class="text-left name">商品名称</td>
												<td class="text-left quantity">数量(件)</td>
												<td class="text-right price">单价</td>
												<td class="text-right total">总计</td>
											</tr>
										</thead>
										<tbody>
										<!-- 遍历购物车中的商品并显示 -->
											<%
											double sum=0;
												//从session里去取
												if(session.getAttribute("cart")!=null){
											ArrayList<Gwc> list=(ArrayList<Gwc>)session.getAttribute("cart");
											for(int i=0;i<list.size();i++){
												Gwc g=list.get(i);
												sum+=(g.getPrice()*g.getCount());
											%>
											<!-- 显示一条商品信息 -->
											<tr>
												<td class="text-center image" width="20%"><a href="goodsDetail.jsp?ID=<%=g.getID()%>">
													<img width="80px" src="../images/goods/<%=g.getPictrue() %>"> </a></td>
												<td class="text-left name"><a
													href="goodsDetail.jsp?ID=<%=g.getID()%>"><%=g.getName() %></a>
												</td>
												<td class="text-left quantity">
													
												
																			
													<button class="btn_reduce" id="<%=g.getID() %>" onclick="javascript:onclick_reduce(this);">-</button>
													<input class="momey_input"  name="" id="momey_input_<%=g.getID() %>" value="<%=g.getCount() %>" disabled="disabled">
													<button class="btn_add" id="<%=g.getID() %>" onclick="javascript:onclick_btnAdd(this);">+</button>
						
												</td>
												<td class="text-right price" id="price_<%=g.getID()%>"><%=new DecimalFormat("#.00").format(g.getPrice()) %></td>
												<td class="text-right total" id="total_<%=g.getID()%>"><%=new DecimalFormat("#.00").format((g.getPrice()*g.getCount()) ) %>元
												</td>
											</tr>
											<!-- 显示一条商品信息 -->
			<%
											}
											}
			%>
											<!-- //遍历购物车中的商品并显示 -->
										</tbody>
									</table>
								</div>
								<!-- //显示购物车中的商品 -->
								<!-- 显示总计金额  -->
								<div class="row cart-total">
									<div class="col-sm-4 col-sm-offset-8">
										<table class="table table-bordered">
											<tbody>
												<tr >
												<span>
													<strong>总计:</strong>
													<p id="s_price"><%=new DecimalFormat("#.00").format(sum) %>元</p>
												</span>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
								<!-- //显示总计金额  -->
							</div>
						</div>

						<!-- 填写物流信息 -->
						<div class="row">
							<div id="content_oc" class="col-sm-12">
								<h1>物流信息</h1>
								<!-- 填写物流信息的表单 -->
								<form action="../cartOrder" method="post" id="myform">
									<div class="table-responsive cart-info">
										<table class="table table-bordered">
											<tbody>
												<tr>
													<td class="text-right" width="20%">收货人姓名：</td>
													<td class="text-left quantity">
														<div class="input-group btn-block" style="max-width: 400px;">
															<input type="text" id="recevieName" name="recevieName" size="10" class="form-control">
														</div>
													</td>
												</tr>
												<tr>
													<td class="text-right">收货人手机：</td>
													<td class="text-left quantity">
														<div class="input-group btn-block" style="max-width: 400px;">
															<input type="text" id="tel" name="tel" size="10" class="form-control">
														</div>
													</td>
												</tr>
												<tr>
													<td class="text-right">收货人地址：</td>
													<td class="text-left quantity">
														<div class="input-group btn-block" style="max-width: 400px;">
															<input type="text" id="address" name="address" size="1" class="form-control">
														</div>
													</td>
												</tr>
												<tr>
													<td class="text-right">备注：</td>
													<td class="text-left quantity">
														<div class="input-group btn-block" style="max-width: 400px;">
															<input type="text" name="bz" size="1" class="form-control">
														</div>
													</td>
												</tr>
											</tbody>
										</table>
									</div>
								</form>
								<!-- //填写物流信息的表单 -->
							</div>
						</div>
						<!-- //填写物流信息 -->
						<br />
						<!-- 显示支付方式 -->
						<div class="row">
							<div id="content_oc" class="col-sm-12">
								<h1>支付方式</h1>
								<div class="table-responsive cart-info">
									<table class="table table-bordered">
										<tbody>
											<tr>
												<td class="text-left"><img src="images/zhifubao.png" /></td>
											</tr>
										</tbody>
									</table>
								</div>
								<br /> <br />
								<div class="buttons">
									<div class="pull-left">
										<a href="index.jsp" class="btn btn-primary btn-default">继续购物</a>
									</div>
									<div class="pull-left">
										<a href="../cartclear" class="btn btn-primary btn-default">清空购物车</a>
									</div>
									<div class="pull-right">
										<a href="javascript:zhifu();" class="tigger btn btn-primary btn-primary">结账</a>
									</div>
								</div>
							</div>
						</div>
						<!-- //显示支付方式 -->
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
	<link type="text/css" rel="stylesheet" href="js/jBox/Skins2/Pink/jbox.css" />
	<script type="text/javascript">
		function onclick_reduce(obj){
			
			var id=obj.id;
			
		var momey_input= document.getElementById("momey_input_"+id);
		var total= document.getElementById("total_"+id);
		var price= document.getElementById("price_"+id);
		var sum = document.getElementById("s_price");
		
			if(momey_input.value-1<=0){
				alert("数量不能小于1");
			}else{
				$.get("/shop/CartUpdate?id="+id+"&num="+(parseFloat(momey_input.value)-1),function(data){
					
					momey_input.value=parseFloat(momey_input.value)-1;
					total.innerHTML=parseFloat(momey_input.value)*parseFloat(price.innerHTML)+".00元";
					sum.innerHTML=parseFloat(sum.innerHTML)+parseFloat(price.innerHTML)+".00元";
					
					
				});
			}
		}
		
function onclick_btnAdd(obj){
			
			var id=obj.id;
			
		var momey_input= document.getElementById("momey_input_"+id);
		var total= document.getElementById("total_"+id);
		var price= document.getElementById("price_"+id);
		var sum = document.getElementById("s_price");
		//提交到服务器修改session
				$.get("/shop/CartUpdate?id="+id+"&num="+(parseFloat(momey_input.value)+1),function(data){
					
					momey_input.value=parseFloat(momey_input.value)+1;
					total.innerHTML=parseFloat(momey_input.value)*parseFloat(price.innerHTML)+".00元";
					sum.innerHTML=parseFloat(sum.innerHTML)+parseFloat(price.innerHTML)+".00元";
					
					
				});
				
			
		}
		
		
		
		
		
			
		function zhifu() {
			<%
			if(session.getAttribute("cart")==null) {
			%>
		
			alert('购物车是空的,再去逛逛吧');
			window.location.href='index.jsp';
			return;
			<%
			}
			%>
			
			//验证收货人姓名
			if ($('#recevieName').val() === "") {
				alert('收货人姓名不能为空！');
				return;
			}
			//验证收货人手机
			if ($('#tel').val() === "") {
				alert('收货人手机不能为空！');
				return;
			}
			//验证手机号是否合法
			if (isNaN($('#tel').val())) {
				alert("手机号请输入数字");
				return;
			}
			//验证收货人地址
			if ($('#address').val() === "") {
				alert('收货人地址不能为空！');
				return;
			}
			var sums = document.getElementById("s_price").innerHTML;
			//设置对话框中要显示的内容
			var html = '<div class="popup_cont">'
					+ '<p>扫一扫支付</p>'
					+ '<strong>￥<font id=show_money_info>'+sums+'</font></strong>'
					+ '<div style="width: 256px; height: 250px; text-align: center; margin-left: auto; margin-right: auto;" >'
					+ '<image src="images/qr.png" width="256" height="256" /></div>'
					+ '</div><p style="text-align:center">请在扫码支付的时候备注订单编号</p>';
			var content = {
				state1 : {
					content : html,
					buttons : {
						'取消' : 0,
						'支付' : 1
					},
					buttonsFocus : 0,
					submit : function(v, h, f) {
						if (v == 0) {//取消按钮的响应事件
							return true; //关闭窗口
						}
						if (v == 1) {//支付按钮的响应事件
							document.getElementById('myform').submit();//提交表单
							return true;
						}
						return false;
					}
				}
			};
			$.jBox.open(content, '支付', 400, 450);//打开支付窗口
			
		}
	</script>
	<!-- // 使用jBox插件实现一个支付对话框 -->
</body>
</html>
