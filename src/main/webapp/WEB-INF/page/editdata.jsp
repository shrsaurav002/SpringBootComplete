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
<title>Edit Data</title>
</head>
<body>
	<form action="update1" method="post">
	 <%@include file="header.jsp" %>
		
		
		<div class="container">
			<h3>Update Data</h3>
		
		<br>
		<marquee direction="right">Edit the following</marquee>
			
			<input type="hidden" name="username" value=${user.username }>		
			<h3>
				Email<br> <input name="email" type="text" value=${user.email } style="width: 500px">
			</h3>
			<h3>
				Password<br> <input name="password" type="text" value=${user.password } style="width: 500px">
			</h3>
			<h3>
				Name<br> <input name="name" type="text" value=${user.name } style="width: 500px">
			</h3>
			<h3>
				Qualification<br> <select name="qualification" style="width: 400px">
					<option ${user.qualification=='High School'?'selected':'' }>High School</option>
					<option ${user.qualification=='Bachelors'?'selected':''}>Bachelors</option>
					<option ${user.qualification=='Masters'?'selected':''}> Masters </option>
					<option ${user.qualification=='Doctorate'?'selected':''}>Doctorate </option>
				</select>
			</h3>
			
			<h3>
				Mobile<br> <input name="mobile" type="number" value=${user.mobile }
					style="width: 500px">
			</h3>
			<h3>
				Photo<br> <input name="photo" type="text" style="width: 500px" value="${user.photo }">
			</h3>
<h3>
				Gender<br> <select name="gender" style="width: 100px">
					<option ${user.gender=='Male'?'selected':'' }>Male</option>
					<option ${user.gender=='Female'?'selected':''}>Female</option>
					</select>
			</h3>



			<button type="submit" class="btn btn-primary">Submit</button>

		</div>
	</form>
</body>
</html>