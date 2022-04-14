<%@page import="com.dao.SuperTypeDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.model.SuperType"%>
<%@page import="com.model.Menage"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>
<%
Menage m=(Menage)session.getAttribute("manager");
if(m==null){
		 %>
		<script>
		alert('请先登录');
		window.location.href='Login_M.jsp';
		
		</script>
		<% 
}
%>

<html>
<head>
<title>51商城――后台管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="CSS/style.css" rel="stylesheet">
<script language="javascript" src="JS/jquery.min.js"></script>

</head>
<script language="javascript">
function mycheck(){
	if (form1.title.value==""){
		alert("请输入标题！");form1.goodsName.focus();return;
	}
	if (form1.picture.value==""){
		alert("请选择图片文件！");form1.picture.focus();return;
	}
	if (form1.href.value==""){
		alert("请输入链接地址！");form1.price.focus();return;
	}
	
	form1.submit();
}
</script>
<body>
<jsp:include page="banner.jsp"/>
<table width="1280" height="288"  border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
  <tr>

    <td align="center" valign="top"><table width="100%"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td width="10" height="38" align="right">&nbsp;</td>
        <td colspan="3" class="tableBorder_B_dashed"><img src="images/manage_ico3.GIF" width="12" height="12">&nbsp;<a href="goods_add.jsp">[添加轮播图]</a></td>
        <td width="12">&nbsp;</td>
      </tr>
      <tr>
        <td align="right">&nbsp;</td>
        <td height="10" colspan="3">&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td height="29" align="right">&nbsp;</td>
        <td width="10" background="images/manage_leftTitle_left.GIF">&nbsp;</td>
        <td width="1089" align="center" background="images/manage_leftTitle_mid.GIF" class="word_white"><b>添加轮播图</b></td>
        <td width="10" background="images/manage_leftTitle_right.GIF">&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
    </table>
	<!---->
       			  			  <form action="/shop/AddSlideshow" method="post" name="form1" enctype="multipart/form-data">
			    <table width="94%"  border="0" align="center" cellpadding="0" cellspacing="0" bordercolordark="#FFFFFF">
                  <tr>
                    <td width="14%" height="27">&nbsp;标题：</td>
                    <td height="27" colspan="3">&nbsp;
                      <input name="title" type="text" class="Sytle_text" id="bookID2" size="50">&nbsp;&nbsp;  </td>
                  </tr>				
                   <tr>
                    <td width="14%" height="27">&nbsp;链接地址：</td>
                    <td height="27" colspan="3">&nbsp;
                      <input name="href" type="text" class="Sytle_text" id="bookID2" size="50">&nbsp;&nbsp;  </td>
                  </tr>	
                  <tr>
                    <td height="41">&nbsp;轮播图片：</td>
                    <td height="41">&nbsp;
                          <input name="picture" type="file" class="Style_upload" id="picture">
                    </td>
                   
                  </tr>
                 
                  <tr>
                    <td height="38" colspan="4" align="center">
                        <input name="Button" type="button" class="btn_bg_short" value="保存" onClick="mycheck()">
&nbsp;                        
<input name="Submit2" type="reset" class="btn_bg_short" value="重置">
                        &nbsp;
                        <input name="Submit3" type="button" class="btn_bg_short" value="返回" onClick="JScript:history.back(-1)">
                    </td>
                  </tr>
                </table>
			  </form>    
	 <!----> 
</td>
	  
	      <td width="182" valign="top"><table width="100%" height="431"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td width="199" valign="top" bgcolor="#FFFFFF"><jsp:include page="navigation.jsp"/></td>
      </tr>
    </table></td>	  
  </tr>
</table>
<jsp:include page="copyright.jsp"/>
</body>
</html>
