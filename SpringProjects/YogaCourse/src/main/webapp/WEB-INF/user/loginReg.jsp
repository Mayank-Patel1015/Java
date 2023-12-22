<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
		<!DOCTYPE html>
		<html>

		<head>
			<!-- for Bootstrap CSS -->
			<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
			<!-- YOUR own local CSS -->
			<link rel="stylesheet" href="/css/main.css" />
			<!-- For any Bootstrap that uses JS -->
			<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
			<meta charset="ISO-8859-1">
			<title>Login and Register</title>
		</head>

		<body>
			<h1>Course Platform - Instructors</h1>
			<div class="container">
				<div class="row">
					<div class="col">
						<h1>New Instructor</h1>
						<form:form action="/process/register" method="post" modelAttribute="user">
							<div class="form-group">
								<label>User Name</label>
								<form:input path="userName" class="form-control" />
								<form:errors path="userName" class="text-danger" />
							</div>
							<div class="form-group">
								<label>Email</label>
								<form:input path="email" class="form-control" />
								<form:errors path="email" class="text-danger" />
							</div>
							<div class="form-group">
								<label>Password</label>
								<form:input path="password" class="form-control" />
								<form:errors path="password" class="text-danger" />
							</div>
							<div class="form-group">
								<label>Confirm Password</label>
								<form:input path="confirm" class="form-control" />
								<form:errors path="confirm" class="text-danger" />
							</div>
							<input type="submit" value="Register User" class="btn btn-primary" />
						</form:form>
					</div>
					<div class="col">
						<h1>Log In</h1>
						<form:form action="/process/login" method="post" modelAttribute="loginUser">
							<div class="form-group">
								<label>Email</label>
								<form:input path="email" class="form-control" />
								<form:errors path="email" class="text-danger" />
							</div>
							<div class="form-group">
								<label>Password</label>
								<form:input path="password" class="form-control" />
								<form:errors path="password" class="text-danger" />
							</div>
							<input type="submit" value="Login" class="btn btn-primary" />
						</form:form>
					</div>
				</div>
			</div>
		</body>

		</html>