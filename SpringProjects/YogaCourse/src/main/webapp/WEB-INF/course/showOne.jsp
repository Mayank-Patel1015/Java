<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 	<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
			<title>Read Share</title>
		</head>

		<body>
			<h1> ${course.courseName} with ${course.instructor.userName }</h1>
			<h3> Day: ${course.day}</h3>
			<h3>
				<fmt:setLocale value = "en_US"/>
         		<fmt:formatNumber value = "${course.price}" type = "currency"/>
			</h3>
			<p>${course.description}</p>
		</body>

		</html>