<%@page import="com.dao.SuperTypeDao"%>
<%@page import="com.model.SuperType"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>
<%@page import="com.model.Menage"%>
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
</head>
<script language="javascript">
function mycheck(){
	if (form1.typename.value==""){
		alert("请输入小分类名称！");form1.typename.focus();return;
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
        <td colspan="3" class="tableBorder_B_dashed"><img src="images/manage_ico2.GIF" width="11" height="11">&nbsp;<a href="subType.jsp">[小分类信息管理]</a></td>
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
        <td width="1089" align="center" background="images/manage_leftTitle_mid.GIF" class="word_white"><b>添加小分类信息</b></td>
        <td width="10" background="images/manage_leftTitle_right.GIF">&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
    </table>
	<!---->
      			  <form action="../AddSubType" method="post" name="form1">
			    <table width="94%"  border="0" align="right" cellpadding="-2" cellspacing="-2" bordercolordark="#FFFFFF">
                  <tr>
                    <td height="50">选择所属分类：</td>
					<td height="50"><select name="superid">
					
					<%
						ArrayList<SuperType> list=SuperTypeDao.serichAllSuperType();
					if(list==null){return;}
					if(list.size()==0){
						%>
						<script>
							alert('请先添加大分类');
							window.location.href='super_add.jsp';
		
						</script>
						<% 
						return;
					}
					for(int i=0;i<list.size();i++){
					%>
					  <option value="<%=list.get(i).getID()%>"><%=list.get(i).getTypeName()%></option>
					  <%
					  }
					  %>
					  </select></td>
                  </tr> 
				  <tr>
                    <td width="17%" height="50">小分类名称：</td>
                    <td width="83%" height="50"><input name="typename" type="text" id="typename" size="60"></td>
                  </tr>
                  <tr align="center">
                    <td height="38" colspan="3">
                        <input name="Button" type="button" class="btn_bg_short" value="保存" onClick="mycheck()">
&nbsp;                        
<input name="Submit2" type="reset" class="btn_bg_short" value="重置">
                        &nbsp;
                        <input name="Submit3" type="button" class="btn_bg_short" value="返回" onClick="JScript:window.location.href='subType.jsp';">                    </td>
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
