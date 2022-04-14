<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
<title>正在退出</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<body>
<%
session.invalidate();
response.sendRedirect("index.jsp");
%>
</body>
</html>
