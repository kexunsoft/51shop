<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.ResultSet"%>

<div class="row">

	

	<div class="col-lg-2 col-md-3 col-sm-4 col-xs-12">
		<div class="product-grid transition">
			<div class="actions">
				<div class="image">
					<a href="goodsDetail.jsp?ID=12"><img
						src="../images/goods/55.jpg"> </a>
				</div>
				<div class="button-group">
					<div class="cart">
						<button class="btn btn-primary btn-primary" type="button"
							data-toggle="tooltip" title=""
							onclick='javascript:window.location.href="cart_add.jsp?goodsID=12&num=1"; '
							data-original-title="加入购物车">
							<i class="fa fa-shopping-cart"></i>
						</button>
					</div>

				</div>
			</div>
			<div class="caption">
				<div class="name" style="height: 40px">
					<a style="width: 90%" href="goodsDetail.jsp?ID=12"><span
						style="color: #0885B1">名称:</span>华硕 </a>
				</div>


				<p class="price" style="margin-top: 40px">
					<span class="price-tax">价格:999 元
					</span>
				</p>
			</div>
		</div>
	</div>
	

</div>