<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="com.dao.goodsDao"%>
<%@page import="com.model.goods"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="java.sql.ResultSet"%>

<div
	class="mr-sidebar mr-sidebar-left col-xs-12 col-sm-4 col-sm-pull-8 col-md-3 col-md-pull-9  hidden-sm hidden-xs">

	<div class="mr-module module " id="Mod157">
		<div class="module-inner">
			<h3 class="module-title ">
				<span style="color: black; ">浏览记录</span>
			</h3>

			<div class="module-ct">
				<div class="mrshop">
					<div class="container_oc">
						<div class="box_oc">
							<div>
							
								<div class="box-product product-grid">
								<% 
							Cookie cookie[]=request.getCookies();
								String values="";
								for(Cookie co:cookie){
									if("his".equals(co.getName())){
										values=co.getValue();
									}
								}
								if(values!=""){
								String ids[]=values.split("-");
								ArrayList<goods> list3=new ArrayList<goods>() ;
								for(String id:ids){
								goods g=goodsDao.serichGoodsByID(id);
									list3.add(g);
								}
								
								
								for(int i=0;i<list3.size();i++){
									goods goods=list3.get(i);
								%>
									<div>
										<div class="image">
										<a href="goodsDetail.jsp?ID=<%=goods.getID()%>"><img
												src="../images/goods/<%=goods.getPicture() %>" width="80px">
											</a>
										</div>
										<div class="name">
											<a href="goodsDetail.jsp?ID=<%=goods.getID()%>"> <%=goods.getGoodsName() %>
											</a>
										</div>
										<div class="rating">
											<span class="fa fa-stack"><i
												class="fa fa-star fa-stack-2x"></i><i
												class="fa fa-star-o fa-stack-2x"></i></span> <span
												class="fa fa-stack"><i class="fa fa-star fa-stack-2x"></i><i
												class="fa fa-star-o fa-stack-2x"></i></span> <span
												class="fa fa-stack"><i class="fa fa-star fa-stack-2x"></i><i
												class="fa fa-star-o fa-stack-2x"></i></span> <span
												class="fa fa-stack"><i class="fa fa-star fa-stack-2x"></i><i
												class="fa fa-star-o fa-stack-2x"></i></span> <span
												class="fa fa-stack"><i class="fa fa-star fa-stack-2x"></i><i
												class="fa fa-star-o fa-stack-2x"></i></span>
										</div>
										<div class="price">
										
											<%=new DecimalFormat("#.00").format(goods.getNowPrice()) %>
											元
										</div>

									</div>
									<% 
								}
								
								}
												%>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>