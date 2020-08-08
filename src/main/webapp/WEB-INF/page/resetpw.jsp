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

<title>Reset Password</title>
</head>
<body>
	<form name="resetpw" action="resetpw" method="post">
		<header style="background-color: #55b4ff;">

		<h1>Welcome</h1>
		</header>
		<br>
		<div class="container">
			<h3>${msg }</h3>
			<img src="Image/1.png" height="300px" id="studentImage"> <span
				id="emessage"
				style="color: blue; font-size: 16px; font-weight: bold;"> </span> <br>
			<label>Username/Email</label><br> <input name="username"
				type="text" style="width: 500px" id="username"><br> <br>

			<button type="submit" class="btn btn-primary"
				style="margin-right: 36px">Find Password</button>
			<a href="${pageContext.request.contextPath}/auth"><button
					type="button" class="btn btn-secondary" style="margin-right: 36px">Go
					Back</button></a> <a href="${pageContext.request.contextPath}/signup"><button
					type="button" class="btn btn-success" style="margin-right: 36px">Signup</button></a>
			<br> <br> <br> <br> <br> ${reset } <br>
		</div>
	</form>
</body>
</html>