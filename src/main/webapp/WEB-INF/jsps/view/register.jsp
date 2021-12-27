<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<div>
		<h2>Registration Form</h2>
		
		<form action="login" method="POST">
		<input type="text" name="firstName" placeholder="First Name"><br>
		<input type="text" name="lastName" placeholder="Last Name"><br>
		<input type="email" name="email" palceholder="Email"><br>
		<input type="password" name="password" placeholder="Password"><br>
		<input type="submit" name="submit"><br>
		</form>
		
		<div>
			Already have an acount? <a href="login?action=login">Login</a>
		</div>
	</div>
</body>
</html>