<%@ page language="java" contentType="text/html"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>

<style>
html
{
	font-size: 10px;
}
.form
{
	border: 5px solid purple;
	width: 50%;
	margin: 0px auto;
}

h2
{
	width: 30%;
	margin: 0px auto;
	font-size: 2.3em;
}

form
{
	margin: 20px 10px;
	font-size: 1.5rem;
}

input
{
	display: inline-block;
	width: 70%;
	font-size: 2rem;
	margin: 10px;
	padding: 2px;
}

.part
{
	font-size: 1.5rem;
}

.btn
{
	width: 50%;
	margin: auto;
}
.btn input
{
	width: 30%;
}

</style>
</head>
<body>
	<div class="form">
		<h2>Registration Form</h2>
		
		<form action="login" method="POST">
		<label>First Name: </label><br>
		<input type="text" name="firstName"><br>
		<label>Last Name: </label><br>
		<input type="text" name="lastName"><br>
		<label>Email: </label><br>
		<input type="email" name="email"><br>
		<label>Password: </label><br>
		<input type="password" name="password"><br>
		
		<div class="btn">
			<input type="submit" name="submit"><br>
		</div>
		</form>
		
		<div class="part">
			Already have an acount? <a href="login?action=login">Login</a>
		</div>
	</div>
</body>
</html>