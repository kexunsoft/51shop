<%@page import="com.model.Menber"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<jsp:useBean id="chStr" scope="page" class="com.tools.ChStr" />
<%
Menber menber = (Menber) session.getAttribute("user");

	if (menber == null ) {
%>
<div id="toolbar" style="background-color: #F0F0F0; width: 100%;">
	<div class="container">
		<div class="row">
			<div class="toolbar-ct-1">
				<p>
					<i class="fa fa-phone"></i> <span style="margin-right: 15px;">电话：400-675-1066</span><a
						href="login.jsp">登录</a>&nbsp; ｜ &nbsp;<a href="register.jsp">注册</a>
				</p>
			</div>
			<div class="toolbar-ct-2">
				
			</div>
		</div>
	</div>
	<div style="background-color: white; width: 100%">
		<div class="container">
			<div class="row">
				<div class="toolbar-ct col-xs-12 col-md-6  hidden-sm hidden-xs">
					<div class="toolbar-ct-1">
						<img src="images/51logo.png">
					</div>
					<div>
						<!-- 搜索条 -->
						<div class="search_box">
							<div class="top-nav-search">
								<form method="get" action="search_result.jsp">
									<input type="text" name="searchword" size="38"
										style="border: 0px;" class="top-nav-search-input"
										placeholder="请输入内容" /> <input type="image"
										src="images/search.png" class="search_box_img"
										onFocus="this.blur()" />
								</form>
							</div>
						</div>
						<!-- //搜索条 -->



					</div>
				</div>

				<div class="toolbar-ct toolbar-ct-right col-xs-12 col-md-3">


					<div class="toolbar-ct-2 "
						style="margin-top: 35px; border: 1px solid #EAEAEA; padding: 5px;">
						<a href="cart_see.jsp" style="color: #E33737; font-size: 20px;"><i
							class="fa fa-cart1"></i> 我的购物车</a>


					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<%
	} else {
%>
<div id="toolbar" style="background-color: #F0F0F0; width: 100%;">
	<div class="container">
		<div class="row">
			<div class="toolbar-ct-1">
				<p>
					<i class="fa fa-phone"></i> <span style="margin-right: 15px;">电话：400-675-1066</span>您好，<%=menber.getTruename()%>
					&nbsp; &nbsp;<a href="modifyMember.jsp">修改</a>&nbsp;&nbsp;
					|&nbsp;&nbsp;<a href="logout.jsp">退出</a>
				</p>
			</div>
			<div class="toolbar-ct-2">
				<a href="orderList.jsp">我的订单</a>&nbsp;&nbsp; | &nbsp;&nbsp;<a href="/shop/fromt/collect.jsp">我的收藏</a>&nbsp;&nbsp;|&nbsp;&nbsp; <a
					href="goodbook.jsp">我要留言</a>
			</div>
		</div>
	</div>
	<div style="background-color: white; width: 100%">
		<div class="container">
			<div class="row">
				<div class="toolbar-ct col-xs-12 col-md-6  hidden-sm hidden-xs">
					<div class="toolbar-ct-1">
						<img src="images/51logo.png">
					</div>
					<div>
						<!-- 搜索条 -->
						<div class="search_box">
							<div class="top-nav-search">
								<form method="get" action="search_result.jsp">
									<input type="text" name="searchword" size="38"
										style="border: 0px;" class="top-nav-search-input"
										placeholder="请输入内容" /> <input type="image"
										src="images/search.png" class="search_box_img"
										onFocus="this.blur()" />
								</form>
							</div>
						</div>
						<!-- //搜索条 -->



					</div>
				</div>

				<div class="toolbar-ct toolbar-ct-right col-xs-12 col-md-3">


					<div class="toolbar-ct-2 "
						style="margin-top: 35px; border: 1px solid #EAEAEA; padding: 5px;">
						<a href="cart_see.jsp" style="color: #E33737; font-size: 20px;"><i
							class="fa fa-cart1"></i> 我的购物车</a>


					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<%
	}
%>