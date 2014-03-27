<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<SCRIPT LANGUAGE="JavaScript"> 
function check() { 
	var username  = document.getElementById("username").value;
	var password = document.getElementById("password").value;
	var password2 = document.getElementById("password2").value;
	if(username == "" || username == null){
		alert("Username should not be empty.");
		return false;
	}
	if(password == "" || password == null){
		alett("Password should not be empty.");
		return false;
	}
	if(password != password2){
		alert("Passwords are not the same.");
		return false; 
	}
	return true;
} 
</SCRIPT>
<body>
	<h1>Register an account</h1>
	<form method="post" action="RegisterOperations" onSubmit="return check()">
		<table>
			<tr>
				<td><label>username: </label></td>
				<td><input type="text" name="username" id="username" /></td>
			</tr>
			<tr>
				<td><label>password: </label></td>
				<td><input type="password" name="password" id="password" /></td>
			</tr>
			<tr>
				<td><label>re password: </label></td>
				<td><input type="password" name="password2" id="password2" /></td>
			</tr>
			<tr>
				<input type="submit" value="submit" />
			</tr>
		</table>
	</form>
</body>
</html>