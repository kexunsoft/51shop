
<%@page import="com.dao.SlideshowDao"%>
<%@page import="com.model.Slideshow"%>
<%@page import="com.model.goods"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dao.goodsDao"%>
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
<script type="text/javascript" src="JS/jquery-1.11.3.min.js"></script>
</head>

<body>
<jsp:include page="banner.jsp"/>
<table width="1280" height="288"  border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
  <tr>

    <td align="center" valign="top"><table width="100%"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td width="18" height="45" align="right">&nbsp;</td>
        <td colspan="3" class="tableBorder_B_dashed">&nbsp;&nbsp;&nbsp;<img src="images/manage_ico3.GIF" width="12" height="12">&nbsp;<a href="slideshow_add.jsp">[添加商轮播图]</a></td>
        <td width="24">&nbsp;</td>
      </tr>
      <tr>
        <td align="right">&nbsp;</td>
        <td height="10" colspan="3">&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td height="29" align="right">&nbsp;</td>
        <td width="10" background="images/manage_leftTitle_left.GIF">&nbsp;</td>
        <td width="989" align="center" background="images/manage_leftTitle_mid.GIF" class="word_white"><b>轮播图列表</b></td>
        <td width="10" background="images/manage_leftTitle_right.GIF">&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
    </table>
	<!---->
    <table width="92%" height="192"  border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td valign="top">
<table width="100%" height="14"  border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td height="13" align="center">&nbsp;</td>
            </tr>
         
          </table>
            <table width="100%" height="60"  border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#FFFFFF" bordercolorlight="#E6E6E6">
              <tr bgcolor="#eeeeee">
                <td width="20%" height="24" align="center">主题</td>
                <td width="30%" align="center">图片</td>
                <td width="20%" align="center">连接地址</td>
                
                <td width="8%" align="center">修改</td>
                <td width="8%" align="center">删除</td>
              </tr>
				<%
				ArrayList<Slideshow> list=SlideshowDao.serichAllSlideshow();
				if(list==null){
					out.println("数据库服务器连接失败");
					return;
				}
				int maxpage=list.size()%4==0?list.size()/4:(list.size()/4)+1;
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
				 
				
				int start=4*(pg-1);
				int end=0;
				if(list.size()-start>4){
				end=start+4;
					
				}else{
					end=list.size();
				}
				System.out.println(pg);
				for(int i=start;i<end;i++){
					Slideshow s=list.get(i);
				%>
			
              <tr style="padding:5px;">
                <td height="20" align="center"><%=s.getTitle() %></td>
                <td align="center" ><img src="/shop/fromt/images/<%=s.getImg()%>" style="height:80px"/> </td>
                <td align="center"><%=s.getHref() %></td>
              
                <td align="center"><a href="slideshow_modify.jsp?id=<%=s.getId()%>"><img src="images/modify.gif" width="19" height="19"></a></td>
                <td align="center"><a href="javascript:del('<%=s.getId()%>')"><img src="images/del.gif" width="20" height="20"></a></td>
              </tr>
<%
				}
%>
            </table>
<table width="100%"  border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="30" align="right">当前页数：[<%=pg %>/<%=maxpage %>]&nbsp;
	<%
	if(pg>1){
	%>
	<a href="slideshow.jsp?page=1">第一页</a>　<a href="slideshow.jsp?page=<%=pg-1%>">上一页</a>
	<%
	}
	if(pg<maxpage){
	%>	
	　<a href="slideshow.jsp?page=<%=pg+1%>">下一页</a>　<a href="slideshow.jsp?page=<%=maxpage%>">最后一页&nbsp;</a>
	<%
	}
	%>
	</td>
  </tr>
</table>		  </td>
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
<script type="text/javascript">
	function del(id){
		if(confirm("确定要删除这个轮播图吗?")){
			$.get("/shop/DelSlideshow",{id:id},function (data){
				if(data){
					alert(data);
					location.reload();
				}
			});
		}
	}
</script>
</body>
</html>
