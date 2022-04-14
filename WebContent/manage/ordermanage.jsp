<%@page import="com.tools.OrderStatus"%>
<%@page import="com.dao.OrderDao"%>
<%@page import="com.dao.orderDetailDao"%>
<%@page import="com.model.orderList"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html; charset=UTF-8" language="java"
	import="java.sql.*" errorPage=""%>
<%@page import="com.model.Menage"%>
<%
	Menage me = (Menage) session.getAttribute("manager");
	if (me == null) {
%>
<script>
	alert('请先登录');
	window.location.href = 'Login_M.jsp';
</script>
<%
	}
%>

<html>
<head>
<title>51商城――后台管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="CSS/style.css" rel="stylesheet">
<script src="JS/jquery.min.js"></script>
</head>

<body>
	<jsp:include page="banner.jsp" />
	<table width="1280" height="288" border="0" align="center"
		cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
		<tr>

			<td align="center" valign="top"><table width="100%" border="0"
					cellpadding="0" cellspacing="0">
					<tr>
						<td align="right">&nbsp;</td>
						<td height="10" colspan="3">&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td align="right">&nbsp;</td>
						<td height="10" colspan="3">
							<form action="ordermanage.jsp" method="get"
								onsubmit="return search();">
								<input type="text" placeholder="根据订单号查询" name="orderId"
									id="orderId" /> <input type="submit" value="查询" />
							</form>
						</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td height="29" align="right">&nbsp;</td>
						<td width="10" background="images/manage_leftTitle_left.GIF">&nbsp;</td>
						<td width="1089" align="center"
							background="images/manage_leftTitle_mid.GIF" class="word_white"><b>订单列表</b></td>
						<td width="10" background="images/manage_leftTitle_right.GIF">&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<%
						//如果没有数据显示
						String orderId = request.getParameter("orderId");

						ArrayList<orderList> list = OrderDao.serichOrderByUserID(orderId);

						if (list == null || list.size() == 0) {
					%>

					<tr>
						<td height="29" align="right">&nbsp;</td>
						<td width="10">&nbsp;</td>
						<td width="1089" align="center" style="color: #000"
							class="word_white"><b>没有记录!</b></td>
						<td width="10">&nbsp;</td>
						<td>&nbsp;</td>
					</tr>

				</table></td>

			<td width="182" valign="top">

				<table width="100%" height="431" border="0" cellpadding="0"
					cellspacing="0">
					<tr>
						<td width="199" valign="top" bgcolor="#FFFFFF"><jsp:include
								page="navigation.jsp" /></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>

	<jsp:include page="copyright.jsp" />
</body>
<%
	return;
	}
%>

<!---->
<table width="96%" height="48" border="1" cellpadding="0"
	cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#CCCCCC"
	bordercolorlight="#FFFFFF">
	<tr align="center">
		<td width="8%" height="30">订单号</td>
		<td width="20%">产品名称</td>
		<td width="8%">数量</td>
		<td width="10%">收货人</td>
		<td width="15%">电话</td>
		<td width="20%">下单日期</td>
		<td>状态</td>
	</tr>
	<!-- 循环 -->
	<%
		int maxpage = list.size() % 12 == 0 ? list.size() / 12 : (list.size() / 12) + 1;
		int pg = 0;
		if (request.getParameter("page") == null) {

			pg = 1;

		} else {
			pg = Integer.valueOf(request.getParameter("page"));
			if (pg <= 1) {
				pg = 1;
			}
			if (pg >= maxpage) {
				pg = maxpage;
			}

		}

		int start = 12 * (pg - 1);
		int end = 0;
		if (list.size() - start > 12) {
			end = start + 12;

		} else {
			end = list.size();
		}
		for (int i = start; i < end; i++) {
			orderList o = list.get(i);
	%>
	<tr align="center">
		<td height="24"><%=o.getOrderID()%></td>
		<td><%=o.getGoodName() == null ? "<font color=red>此商品已经下架</font>" : o.getGoodName()%></td>
		<td><%=o.getGoodnumber()%></td>
		<td><%=o.getRecevieName()%></td>
		<td><%=o.getTel()%></td>
		<td><%=o.getOrderDate()%></td>
		<td><select style="height: 25px; font-size: 12px; padding: 2px;"
			lastval="<%=o.getStatus()%>" orderID="<%=o.getDid()%>"
			onchange="sck(this)">
				<option value="1" <%=o.getStatus() == 1 ? "selected" : ""%>>待处理</option>
				<option value="2" <%=o.getStatus() == 2 ? "selected" : ""%>>审核通过</option>
				<option value="3" <%=o.getStatus() == 3 ? "selected" : ""%>>发货中</option>
				<option value="4" <%=o.getStatus() == 4 ? "selected" : ""%>>确认收货</option>
		</select></td>
	</tr>
	<%
		}
	%>
	<!-- 循环 -->
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td height="24" align="right">当前页数：[<%=pg%>/<%=maxpage%>]&nbsp;
			<%
				if (pg > 1) {
			%> <a href="ordermanage.jsp?page=1&orderId=<%=orderId%>">第一页</a> <a
			href="ordermanage.jsp?page=<%=pg - 1%>&orderId=<%=orderId%>">上一页</a> <%
 	}
 	if (pg < maxpage) {
 %> <a href="ordermanage.jsp?page=<%=pg + 1%>&orderId=<%=orderId%>">下一页</a>
			<a href="ordermanage.jsp?page=<%=maxpage%>&orderId=<%=orderId%>">最后一页&nbsp;</a>
			<%
				}
			%>
		</td>
	</tr>
</table>
<!---->
</td>

<td width="182" valign="top"><table width="100%" height="431"
		border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="199" valign="top" bgcolor="#FFFFFF"><jsp:include
					page="navigation.jsp" /></td>
		</tr>
	</table></td>
</tr>
</table>
<jsp:include page="copyright.jsp" />
</body>
<script>
	function search() {
		var z = /^[0-9]*$/;
		if (!z.test($('#orderId').val())) {
			alert('订单号为数字格式！');
			return false;
		}

		return true;
	}
	function sck(obj) {

		if (parseInt(obj.value) < parseInt(obj.getAttribute('lastval'))) {
			alert('状态不可后撤');
			obj.selectedIndex = parseInt(obj.getAttribute('lastval')) - 1;
			return;

		}
		if (obj.selectedIndex == 2) {
			var num = prompt("请输入物流单号");

			if (num != "" && num != null) {
				var test = /\d{7}/;

				if (test.test(num)) {
					$.get("/shop/UpdateOrderNumber?orderNumber=" + num + "&id="
							+ obj.getAttribute('orderID'), function(data) {
						if (data != "ok") {
							alert("服务器发生错误");
							return;
						} else {
							alert("快递单号填写正确");
						}
					});
				} else {
					alert("快递单号格式不正确");
					obj.selectedIndex = parseInt(obj.getAttribute('lastval')) - 1;
					return;
				}
			} else {
				obj.selectedIndex = parseInt(obj.getAttribute('lastval')) - 1;
				return;
			}
		}

		//执行修改ajax实现
		var xhr;
		//创建XMLHttpRequest对象
		if (window.XMLHttpRequest) {
			//非IE6
			xhr = new XMLHttpRequest();
		} else {
			xhr = new ActiveXObject('Microsoft.XMLHTTP');
		}
		xhr.open("post", "/shop/OrderUpdate?orderID="
				+ obj.getAttribute('orderID') + "&status=" + obj.value, false);
		xhr.send(null);
		xhr.onreadystatechange = function() {

			if (xhr.readyState == 4 && xhr.status == 200) {
				if ("true" == xhr.responseText) {

					obj.setAttribute("lastval", obj.value);
					alert("修改成功");

				}
			}
		}

	}
</script>
</html>

