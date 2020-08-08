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
	function sendMail(email) {
		$("#sendMailModal").modal("show");
		$("#sendMsgEmail").val(email);
		
		$("#showImage").attr(
				"src",
				"${pageContext.request.contextPath }/load/image?username="
						+ email)
	}

	$(document).ready(function() {
		$("#newImage").change(function() {
			readURL(this);
		});
	});

	//Code which is used to preview the image 
	function readURL(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();
			reader.onload = function(e) {
				$('#showNewImage').attr('src', e.target.result);
			}
			reader.readAsDataURL(input.files[0]); // convert to base64 string
		}
	}

	function openModal(username, email) {
		$("#imageModal").modal("show")
		$("#username").val(username);
		$("#email").val(email);
		$("#showOldImage").attr(
				"src",
				"${pageContext.request.contextPath }/load/image?username="
						+ username);

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
			<h4>${success }
				<br>

				<center>
					<label> Search</label> <input name="search" type="text">
					<button type="submit" class="btn btn-success"
						style="margin-right: 36px">Search</button>
					<a href="displayprofile"><button type="button"
							class="btn btn-danger" style="margin-right: 36px">Clear</button></a>
				</center>

			</h4>
		</form>
		<marquee behavior="alternate">
			<h2>Profiles</h2>
		</marquee>
		${pageContext.request.contextPath}
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>S.No.</th>
					<th>Name</th>
					<th>Email
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="sort?order=asc"><img src="Image/des.jpg" height=20px></a>
						<a href="sort?order=desc"><img src="Image/asc.png" height=20px></a>

					</th>
					<th>Username</th>
					<th>Password</th>
					<th style="row-width: 200%">Qualification
						<form action="qualfilter" method="post">
							<select name="qualification">
								<option disabled selected>Choose one</option>
								<c:forEach items="${qual}" var="qual">
									<option>${qual}</option>
								</c:forEach>

							</select><br>
							<button type="submit" class="btn btn-success">Go</button>
							<a href=displayprofile><img src="Image/No.png" height=20px></a>
						</form>

					</th>
					<th>Mobile</th>
					<th>Gender</th>
					<th>Created Date</th>
					<th>Photo</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${data}" var="ans" varStatus="sno">
					<tr>
						<td>${sno.count }</td>
						<td>${ans.name }<img src="Image/mail.png" height=30px
							onclick="javascript:sendMail('${ans.email }')">
						</td>
						<td>${ans.email }</td>
						<td>${ans.username }</td>
						<td>${ans.password }</td>
						<td>${ans.qualification }</td>
						<td>${ans.mobile }</td>
						<td>${ans.gender }</td>
						<td>${ans.createddate }</td>
						<td><img
							src="${pageContext.request.contextPath }/load/image?username=${ans.username }"
							height=100px class=zoom> <img src="Image/ed.png"
							height=30px
							onclick="javascript:openModal('${ans.username }','${ans.email }')"></td>

						<td><a
							href="${pageContext.request.contextPath}/editData?email=${ans.email }"><img
								src="Image/edit.png" height=30px></a> &nbsp;&nbsp;&nbsp; <a
							href="${pageContext.request.contextPath}/delete?email=${ans.email }"><img
								src="Image/delete.png" height=30px></a></td>
					</tr>
				</c:forEach>


			</tbody>
		</table>
	</div>

	<!-- Modal -->
	<form action="changeImage" method=post enctype="multipart/form-data">
		<div id="imageModal" class="modal fade">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Change Image</h4>
					</div>
					<div class="modal-body">
						<input id="username" name="username" type="hidden"> <input
							id="email" name="email" type="hidden"> <img src=""
							id="showOldImage" height=150px> <img src=""
							id="showNewImage" height=150px>
						<hr />
						<input type="file" name="file" id="newImage" class="form-control">

					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-primary">Change</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>

					</div>
				</div>

			</div>
		</div>
	</form>

	<!--  Send Email -->
	<form action="sendMail" method=post>
		<div id="sendMailModal" class="modal fade">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Send Email</h4>
					</div>
					<div class="modal-body">
						<input id="sendMsgEmail" name="sendMsgEmail" type="hidden"> 
						<img src=""
							id="showImage" height=150px>
						<hr />
						<label> Subject</label>
						 <input type="text" name="subject"
							id="Subject" class="form-control"> 
						<div class="form-group">
							<label >Message</label>
							<textarea class="form-control rounded-0"
								id="message" name="message" rows="10"></textarea>
						</div>
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-primary">Send</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>

					</div>
				</div>

			</div>
		</div>
	</form>

</body>
</html>