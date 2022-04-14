<%@page import="com.dao.SuperTypeDao"%>
<%@page import="com.model.SuperType"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<header id="mr-header" class="wrap mr-header">
	<div class="container">
		<div class="row">
			<!-- //网站Logo -->
			<!-- 主导航条 -->
			<nav id="mr-mainnav"
				class="col-xs-12 col-md-6 mr-mainnav navbar navbar-default">
				<div class="mr-navbar navbar-collapse collapse">
					<div class="mr-megamenu animate slide" data-duration="400"
						data-responsive="true">
						<ul class="nav navbar-nav level0">
							<li itemprop="name" data-id="435" data-level="1"><a
								id="index" itemprop="url" class="" href="index.jsp"
								data-target="#">首页 </a></li>
								<%
									ArrayList<SuperType> slist=SuperTypeDao.serichAllSuperType();
									if(slist==null){return ;}
									for(int i=0;i<slist.size();i++){
								%>
							<li itemprop="name" data-id="510" data-level="1"><a
								id="<%=slist.get(i).getID() %>" itemprop="url" class=""
								href="goodsList.jsp?type=<%=slist.get(i).getID() %>" data-target="#"><%=slist.get(i).getTypeName() %></a>
							</li>
<%
									}
%>
							
						</ul>
					</div>

				</div>
			</nav>
			<!-- //主导航条 -->
		</div>
	</div>
</header>
<script>
	// 获取页面参数
	function GetString(name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");//正则表达式
		var r = window.location.search.substr(1).match(reg);//获取鼠标点击区域
		if (r != null)
			return unescape(r[2]);//返回区域编号
		return null;
	}
	var type = GetString('type');
	
		var jingying = document.getElementById(type);
		jingying.style.backgroundColor = "rgb(217, 69, 57)";

	
	
	if (type == null) {//默认登录无点击
		var index = document.getElementById('index');
		index.style.backgroundColor = "#9E2626";

	}
</script>