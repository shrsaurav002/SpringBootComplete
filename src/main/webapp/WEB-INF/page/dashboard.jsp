<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@page import="java.util.Map"%>
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
<title>Details</title>
</head>
<body>
	<form method=post>
		<header style="background-color: #55b4ff;">
		<h1>Welcome to your Wall</h1>
		</header>
		<br>
		<div class="container">
			<img src="${sessionScope.userData.photo }" height=250px> <br>
			<br>
			<table style="width: 100%" class="table table-bordered">
				<tr>
					<th align="center" colspan=2>User Details</th>
				</tr>
				<tr>

					<td>Name</td>
					<td>${sessionScope.userData.name }</td>

				</tr>
				<tr>
					<td>Username</td>
					<td>${sessionScope.userData.username}</td>
				</tr>
				<tr>
					<td>Password</td>
					<td>${sessionScope.userData.password}</td>
				</tr>
				<tr>
					<td>Email</td>
					<td>${sessionScope.userData.email}</td>
				</tr>
				<tr>
					<td>Gender</td>
					<td>${sessionScope.userData.gender}</td>
				</tr>
				<tr>
					<td>Phone Number</td>
					<td>${sessionScope.userData.mobile}</td>
				</tr>
				<tr>
					<td>Qualification</td>
					<td>${sessionScope.userData.qualification}</td>
				</tr>

			</table>
			<a href="${pageContext.request.contextPath}/displayprofile"><button type="button"
					class="btn btn-primary" style="margin-right: 36px"
					name="buttonName" value="next">Next</button></a> <a href="${pageContext.request.contextPath}/logout"><button
					type="button" class="btn btn-danger" style="margin-right: 36px"
					name="buttonName" value="logout">LogOut</button></a>

		</div>
	</form>
</body>
</html>