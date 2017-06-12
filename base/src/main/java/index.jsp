<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.net.InetAddress"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>优云测试</title>
</head>
<body>
	<%
		InetAddress address = InetAddress.getLocalHost();
		String ip = address.getHostAddress().toString();
		pageContext.setAttribute("ip", ip);
	%>
	<center>
		<div style="margin-top: 300px;">
			<font size="50"> 当前访问机器IP地址:<%=ip%></font>
		</div>
	</center>
</body>
</html>