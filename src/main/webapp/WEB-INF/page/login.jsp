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
<script>
	function clearMsg() {
		document.getElementById("emessage").innerHTML = "";
		document.getElementById("studentImage").src = "Image/1.png"
	}
	function validateLogin() {

		var uname = document.getElementById("username").value;
		if (uname.length == 0) {
			document.getElementById("emessage").innerHTML = "Username cant be empty";
			document.getElementById("studentImage").src = "Image/val.png"
			return;
		}
		var pass = document.getElementById("password").value;
		if (pass.length == 0) {
			document.getElementById("emessage").innerHTML = "Password cant be empty";
			document.getElementById("studentImage").src = "Image/val.png"
			return;
		}
		//submitting form manually using JS;
		document.authform.submit();

	}
</script>
<title>Login</title>
<!-- add icon link -->
<link rel="icon"
	href="https://imageog.flaticon.com/icons/png/512/55/55283.png?size=1200x630f&pad=10,10,10,10&ext=png&bg=FFFFFFFF"
	type="image/x-icon">
</head>
<body>
	<form name="authform" action="auth" method="post">
		<header style="background-color: #55b4ff;">

		<h1>Welcome</h1>
		</header>
		<br>
		<div class="container">
			<h3>${msg }</h3>
			<img src="Image/1.png" height="300px" id="studentImage"> <span
				id="emessage"
				style="color: blue; font-size: 16px; font-weight: bold;"> </span>
			<h4>
				<label>Username</label><br> <input name="username" type="text"
					style="width: 500px" id="username" onkeyup="clearMsg();">
			</h4>
			<h4>
				<label>Password</label><br> <input name="password"
					type="password" style="width: 500px" id="password"
					onkeyup="clearMsg();">
			</h4>
			<hr>
			<br>
			<button type="button" class="btn btn-primary"
				style="margin-right: 36px" onclick="validateLogin();">Login</button>
			<button type="reset" class="btn btn-secondary"
				style="margin-right: 36px">Reset</button>
			<a href="${pageContext.request.contextPath}/signup"><button
					type="button" class="btn btn-success" style="margin-right: 36px">Signup</button></a>
			<a href="${pageContext.request.contextPath}/signupImage">
				<button type="button" class="btn btn-warning"
					style="margin-right: 36px">SignupWith Image</button>
			</a> <a href="${pageContext.request.contextPath}/resetpw"><button
					type="button" class="btn btn-danger" style="margin-right: 36px">Forgot
					Password</button></a> <br> <br> <br> <br> <br> <br>
			<br>

		</div>
	</form>
</body>
</html>