<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.customer.profileDTO.ProfileDTO"%>
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
<script type="text/javascript">
	function ccBcc() {
		document.getElementById("ccAndBcc").innerHTML = "<br /> <label>CC</label><br />	<input type=text name=sendCc id=sendCc class=form-control> 	<br /> <label>Bcc</label><br /> <input type=text name=sendBcc id=sendBcc class=form-control> <br />"
	}
</script>

<style>
.zoom {
	transition: transform .2s;
	margin: 0 auto;
}

.zoom:hover {
	transform: scale(3.0);
}
</style>
<title>Wall</title>
</head>
<body>

	<%@include file="header.jsp"%>
	<br>

	<div class="container">
		<form action="search" method=post>
			<h4>${success }</h4>
			<div class="form-group">
				<label> To</label> <input type="text" name="sendTo" id="sendTo"
					class="form-control">
			</div>
			<a onClick="ccBcc()">Show CC and BCC</a> <span id="ccAndBcc">
			</span> <br /> <label> Subject</label> <input type="text" name="subject"
				id="Subject" class="form-control">
			<div class="form-group">
				<label>Message</label>
				<textarea class="form-control rounded-0" id="message" name="message"
					rows="10"></textarea>
			</div>
			<input type="file" class="form-control" name="attachment">
			<input type="checkbox" name="sendToMe" value="sendToMe">Send to Me<br>
			<button type="submit" class="btn btn-primary btn-sm float-left">Send</button>
		</form>
	</div>

</body>
</html>