<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
</script>
</head>
<body>
<%
String username = request.getRemoteUser();
%>
<h1>欢迎新用户: <%=username %></h1>
<p>这是您首次登陆本系统，请完善以下信息</p>
<form method="post" action="/app/user!addUser.action">
	<input type="hidden" name="user.username" id="username" value="<%=username %>" />
	<tr>
		<td><label>app_attribute_1: </label></td>
		<td><input type="text" name="user.app_attribute_1" id="app_attribute_1"/></td>
	</tr>
	<tr>
		<td>
			<input type="submit" value="提交" />
		</td>
	</tr>
</form>
</body>
</html>