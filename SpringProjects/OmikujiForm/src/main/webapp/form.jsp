<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form</title>
</head>
<body>
	<h1> what's popping </h1>
	<form action="/process" method="post">
		<h3>
			Enter a number from 5 to 25:
			<input type="number" name="number"/>
		</h3>
		<h3>
			City:
			<input type="text" name="city"/>
		</h3>
		<h3>
			Name of a person:
			<input type="text" name="name"/>
		</h3>
		<h3>
			Enter a professional endeavor or hobby:
			<input type="text" name="hobby"/>
		</h3>
		<h3>
			Animal:
			<input type="text" name="animal"/>
		</h3>
		<h3>
			Say something nice to someone:
			<input type="text" name="comment"/>
		</h3>
		<button type="submit" value="Submit">Send</button>
	</form>
</body>
</html>