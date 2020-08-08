<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
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
<title>Manager User</title>
</head>
<body>
	<form action=change>
		 <%@include file="header.jsp" %>
		<br>

		<div class="container">
			
				<h2>Manage</h2>
		<button type="submit" class="btn btn" name="buttonName" value="password">Reset Password</button>
			<br><br>
			<button type="submit" class="btn btn" name="buttonName" value="photo">Change Photo</button>
		<br><br>
			<button type="submit" class="btn btn" name="buttonName" value="mobile">Change Number</button><br><br>
			<a href="profiles"><button type="button" class="btn btn">Go back</button></a>
			
		</div>
		</form>
</body>
</html>