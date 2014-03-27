<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="org.demo.user.bean.Userser"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%User user = (User)request.getSession().getAttribute("identity"); 
%>
<h1>欢迎登陆</h1>
用户名：<%= user.getUsername()%><br />
app_attribute_1: <%=user.getApp_attribute_1() %><br />
<a href="https://localhost:8443/cas/logout?service=http://localhost:8080/app
">logout</a><br />
</body>
</html>