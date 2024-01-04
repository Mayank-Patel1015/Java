<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<meta charset="ISO-8859-1">
<title>Read Share</title>
</head>
<body>
	<h1><c:out value="${book.bookName}"/></h1>
	<p> ${book.postedBy.userName} read ${book.bookName} by ${book.author}.</p>
	<p> Here are ${book.postedBy.userName}'s thoughts: </p>
	<p>________________________________________</p>
	<p>${book.myThoughts} </p>
	
	<c:if test="${book.postedBy.id == user_id }">
		<a href="/books/edit/${book.id}" class="btn btn-outline-warning">Edit</a>
		<form action="/books/delete/${book.id}" method="post">
			<input type="hidden" name="_method" value="DELETE"/>
			<input type="submit" value="delete" class="btn btn-outline-danger"/>
		</form>
	</c:if>
	
</body>
</html>