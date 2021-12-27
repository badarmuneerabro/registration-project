<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<h2>Log In</h2>
<%
	Boolean isLoginFailed = (Boolean) request.getAttribute("loginFailed");
	if(isLoginFailed)
		out.println("<h3>Entered credentails are not correct. please try again.</h2>");
%>
<form action="login" method="POST">
	<input type="text" name="username"><br>
	<input type="password" name="password"><br>
	<input type="submit" name="submit"><br>
</form>
</body>
</html>