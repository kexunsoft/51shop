<%@page import="com.dao.SubTypeDao"%>
<%@page import="com.model.SubType"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>

<html>
<head>
<title>51商城――后台管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="CSS/style.css" rel="stylesheet">
<script src="JS/check.js"></script>
<script src="onclock.JS"></script>
</head>
<body>
<jsp:include page="banner.jsp"/>
<table width="1280" height="288"  border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
  <tr>

    <td align="center" valign="top"><table width="100%"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td width="10" height="38" align="right">&nbsp;</td>
        <td colspan="3" class="tableBorder_B_dashed"><img src="images/manage_ico2.GIF" width="11" height="11">&nbsp;<a href="sub_add.jsp">[添加小分类信息]</a></td>
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
        <td width="1089" align="center" background="images/manage_leftTitle_mid.GIF" class="word_white"><b>小分类信息列表</b></td>
        <td width="10" background="images/manage_leftTitle_right.GIF">&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
    </table>
	<!---->
               <form action="../DelSubType" method="post" name="frm"> 
              <table width="92%" height="192"  border="0" cellpadding="0" cellspacing="0"> 
                <tr> 
                  <td valign="top"> <table width="100%" height="14"  border="0" cellpadding="0" cellspacing="0"> </table> 
                    <table width="100%" height="48"  border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#FFFFFF" bordercolorlight="#E6E6E6"> 
                      <tr bgcolor="#eeeeee"> 
                        <td width="48%" height="24" align="center">大分类信息名称</td> 
                        <td width="44%" align="center">小分类信息名称</td>
                        <td width="8%" align="center">删除</td> 
                      </tr> 
<!-- 循环展示 --> 
<%
					ArrayList<SubType> list=SubTypeDao.serichAllSubType();
if(list==null){return;}
for(int i=0;i<list.size();i++){
	SubType s=list.get(i);
%>
                      <tr style="padding:5px;"> 
                        <td height="20" align="center"><%=s.getSuperType() %></td> 
                        <td height="20" align="center"><%=s.getTypeName() %></td>
                        <td align="center"><input name="delid" type="checkbox" class="noborder" value="<%=s.getID()%>"></td> 
                      </tr> 
                      <%
}
                      %>
<!-- 循环展示 --> 
                    </table> 
                    <table width="100%"  border="0" cellspacing="0" cellpadding="0"> 
                      <tr> 
                        <td width="73%" height="24">&nbsp;</td> 
                        <td width="27%" align="right"><input name="checkbox" type="checkbox" class="noborder" onClick="CheckAll(frm.delid,frm.checkbox)"> 
                          [全选/反选] [<a style="color:red;cursor:hand;" onClick="checkdel(frm.delid,frm)">删除</a>] 
                          <div id="ch"> 
                            <input name="delid" type="checkbox" class="noborder" value="0"> 
                          </div></td> 
                        <!--层ch用于放置隐藏的checkbox控件，因为当表单中只是一个checkbox控件时，应用javascript获得其length属性值为undefine--> 
                        <script language="javascript">ch.style.display="none";</script> 
                      </tr> 
                    </table></td> 
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