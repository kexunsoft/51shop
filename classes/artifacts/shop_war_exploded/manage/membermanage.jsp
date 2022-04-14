<%@page import="java.lang.reflect.Member"%>
<%@page import="com.dao.MemberImpl"%>
<%@page import="com.model.Menber"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>
<%@page import="com.model.Menage"%>
<%
Menage me=(Menage)session.getAttribute("manager");
if(me==null){
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

<body>  
<jsp:include page="banner.jsp"/>
<table width="1280" height="288"  border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
  <tr>

    <td align="center" valign="top"><table width="100%"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td align="right">&nbsp;</td>
        <td height="10" colspan="3">&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td height="29" align="right">&nbsp;</td>
        <td width="10" background="images/manage_leftTitle_left.GIF">&nbsp;</td>
        <td width="1089" align="center" background="images/manage_leftTitle_mid.GIF" class="word_white"><b>会员列表</b></td>
        <td width="10" background="images/manage_leftTitle_right.GIF">&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
    </table>
	<!---->
<table width="100%" height="14"  border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td height="13" align="center">&nbsp;</td>
            </tr>
      </table>
            <table width="96%" height="48"  border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#CCCCCC" bordercolorlight="#FFFFFF">
              <tr>
                <td width="14%" height="27" align="center">
                  用户名</td>
                <td width="14%" align="center">真实姓名</td>
                
                <td width="14%" align="center">电话</td>
                <td width="26%" align="center">Email</td>
                <td width="10%" align="center">销费额</td>
                <%--<td width="11%" align="center">冻结/解冻</td>
              --%></tr>
<!-- 玄幻 -->
			<%
			MemberImpl m=new MemberImpl();
				ArrayList<Menber> list=m.selectAll();
				if(list==null){return;}
				int maxpage=list.size()%12==0?list.size()/12:(list.size()/12)+1;
				int pg=0;
				if(request.getParameter("page")==null){
					
					pg=1;
					
				}else{
					pg=Integer.valueOf(request.getParameter("page"));
					if(pg<=1){
						pg=1;
					}
					if(pg>=maxpage){
						pg=maxpage;
					}
					
				}
				 
				
				int start=12*(pg-1);
				int end=0;
				if(list.size()-start>12){
				end=start+12;
					
				}else{
					end=list.size();
				}
				for(int i=start;i<end;i++){
					Menber menber=list.get(i);
			%>
              <tr style="padding:5px;">
                <td height="24" align="center"><a href="member_detail.jsp?ID=ID"><%=menber.getUsername() %></a>&nbsp;</td>
                <td align="center"><%=menber.getTruename() %>&nbsp;</td>
                
                <td align="center"><%=menber.getTel()%>&nbsp;</td>
                <td align="center"><%=menber.getTel() %>&nbsp;</td>
                <td align="center"><%=menber.getAmount() %></td>
                
              </tr>
              <%
				}
              %>
<!-- 玄幻 -->
      </table>
<table width="100%"  border="0" cellspacing="0" cellpadding="0">
  <tr>
   <td height="27" align="right">当前页数：[<%=pg %>/<%=maxpage %>]&nbsp;
	<%
	if(pg==maxpage&&pg>1){
	%>
	<a href="membermanage.jsp?page=1">第一页</a>　<a href="membermanage.jsp?page=<%=pg-1%>">上一页</a>
	<%
	}
	if(pg!=maxpage){
	%>	
	　<a href="membermanage.jsp?page=<%=pg+1%>">下一页</a>　<a href="membermanage.jsp?page=<%=maxpage%>">最后一页&nbsp;</a>
	<%
	}
	%>
  </tr>
</table>
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
