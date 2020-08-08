<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Login</title>
</head>
<body>
	<form action="auth" method="post">
		<header style="background-color: #55b4ff;">
			<h1>Welcome</h1>
		</header>
		<br>
		<div class="container">
			<h3>Error! Please Log In </h3>
			<img src="Image/No.png" height="300px">

			<h4>
				<label>Username</label><br> <input name="username" type="text"
					style="width: 500px">
			</h4>
			<h4>
				<label>Password</label><br> <input name="password"
					type="password" style="width: 500px">
			</h4>
			<hr>
			<br>
			<button type="submit" class="btn btn-primary"
				style="margin-right: 36px" name="buttonName" value="login">Login</button>
			<button type="reset" class="btn btn-secondary"
				style="margin-right: 36px" name="buttonName" value="reset">Reset</button>
			<a href="register.jsp"><button type="button" class="btn btn-success" name="buttonName"
				value="signup" style="margin-right: 36px">Signup</button></a>
				<button type="submit" class="btn btn-danger" name="buttonName"
				value="reset" style="margin-right: 36px"name="buttonName" value="recover">Forgot Password</button>
		
		<br><br><br><br><br><br><br>
		<h3> ${reset}</h3>
		</div>
	</form>
</body>
</html>