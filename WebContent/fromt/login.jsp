<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>登录-51商城</title>
<link rel="stylesheet" href="css/mr-01.css" type="text/css">
<script src="js/jquery.1.3.2.js" type="text/javascript"></script>
<script src="https://cdn.bootcss.com/jsencrypt/3.0.0-rc.1/jsencrypt.js"></script>
</head>

<body>
	<div id="mr-mainbody" class="container mr-mainbody">
		<div class="row">
			<!-- 主体内容 -->
			<div id="mr-content" class="mr-content col-xs-12">
				<div class="login-wrap" style="margin-bottom: 60px; margin-top: 50px">
					<div style="max-width: 540px; margin: 0 auto;">
						<a href="index.jsp" title="点击返回首页"><img src="images/51logo.png"></a>
					</div>
					<div class="login">
						<div class="page-header" style="pause: 0px;"> <h1 class="login_h1">会员登录</h1> </div>
						<!-- 会员登录表单 -->
						<form class="form-horizontal">
							<fieldset>
								<div class="form-group">
									<div class="col-sm-4 control-label">
										<label id="username-lbl" for="username" class="required">账户 ：</label>
									</div>
									<div class="col-sm-8">
										<!-- 账户文本框 -->
										<input type="text" name="username" id="username" value="" size="38"
											class="validate-username required" required="required" autofocus="">
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-4 control-label">
										<label id="password-lbl" for="password" class="required">密码 ：</label>
									</div>
									<div class="col-sm-8">
										<!-- 密码文本框 -->
										<input type="password" name="PWD" id="password" value=""
											class="validate-password required" size="38" maxlength="99"
											required="required" aria-required="true">
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-4 control-label">
										<label id="password-lbl" for="password" class="required" required="required">验证码 ：</label>
									</div>
									<div class="col-sm-8" style="clear: none;">
										<!-- 验证码文本框 -->
										<input type="text" name="checkCode" id="checkCode" value=""
											class="validate-password required" style="float: left;"
											title="验证码不区分大小写" size="18" maxlength="4" required="required"
											aria-required="true"> 
											<!-- 显示验证码 -->
											<img src="../CheckCode" name="img_checkCode" onclick="myReload(this)" width="116" height="43" class="img_checkcode" id="img_checkcode"/>
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-offset-4 col-sm-8">
										<button type="button" class="btn btn-primary login" onclick="sub()">登录</button>
									</div>
								</div>
								<div class="form-group"
									style="border-top: 1px solid #D9D9D9; margin: 20px;">
									<label
										style="float: right; color: #858585; margin-right: 40px; margin-top: 10px; font-size: 14px;">没有账户？<a
										href="register.jsp">立即注册</a></label>
								</div>
							</fieldset>
						</form>
					</div>
				</div>
			</div>
			<!-- //主体内容 -->
		</div>
	</div>
	<script language="javascript">
		//刷新验证码
		function myReload(t) {
			t.src="../CheckCode?date="+new Date().getTime();
		}
		function sub(){
			var code=document.getElementById("checkCode").value;
			var b=false;
			$.ajaxSetup({async:false});
			
			$.post("/shop/CheckCodeServlet",{code:code},function(data){
				if(data=="true"){
					b=false;
					$.post("/shop/GetPublicKey",function(data){
						if(data){
							 var encrypt = new JSEncrypt();
						        encrypt.setPublicKey(data);
						     var newPwd=encrypt.encrypt($("#password").val());
						    $.post("/shop/keyLogin",{username:$("#username").val(),pwd:newPwd,yzm:$("#checkCode").val()},
						    		function(data){
						    	if(data=="ok"){
						    		window.location.href="index.jsp";
						    	}else{
						    		alert("账号或密码错误!");
						    	}
						    }
						    
						    );
						}
					});
				}else{
					
					b= false;
					alert("验证码不正确");
				}
				
			});
			
			return b;
			
		}
	</script>
</body>
</html>