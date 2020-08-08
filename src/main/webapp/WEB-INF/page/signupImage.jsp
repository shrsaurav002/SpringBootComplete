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
<title>Register</title>
</head>
<body>
	<form action="signupImage" method="post" enctype="multipart/form-data">
		<header style="background-color: #55b4ff;">
			<h1>Create an Account</h1>
		</header>
		<br>
		<div class="container">
		<marquee direction="right">Sign Up</marquee>
			<img src="Image/2.png">
					
			<h3>
				Email<br> <input name="email" type="text" style="width: 500px">
			</h3>
			<h3>
				Name<br> <input name="name" type="text" style="width: 500px">
			</h3>
			<h3>
				Qualification<br> <select name="qualification" style="width: 400px">
					<option disabled selected >Choose one</option>
					<option>High School</option>
					<option>Bachelors</option>
					<option> Masters </option>
					<option>Doctorate </option>
				</select>
			</h3>
			
			<h3>
				Mobile<br> <input name="mobile" type="number"
					style="width: 500px">
			</h3>
			<h3>
				Photo<br> <input name="image" type="file" style="width: 500px">
			</h3>
<h3>
				Gender<br> <select name="gender" style="width: 100px">
					<option>Male</option>
					<option>Female</option>
					</select>
			</h3>



			<button type="submit" class="btn btn-primary">Register</button>
<a href=login.jsp><button type="button" class="btn btn-success">Login</button></a>
		</div>
	</form>
</body>
</html>