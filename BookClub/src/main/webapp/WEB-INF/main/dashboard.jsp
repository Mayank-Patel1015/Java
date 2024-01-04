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
<title>Insert title here</title>
</head>
<body>
	<h1>Dashboard</h1>
	<a href="/logout" class="btn btn-outline-danger">Logout</a>
	<a href="/books/create" class="btn btn-outline-success">Add book</a>
	<h1>All Books</h1>
	<table class="table table-dark">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Title</th>
      <th scope="col">Author</th>
      <th scope="col">Posted By</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${allBooks}" var="book">
    <tr>
			<td><c:out value="${book.id}"/></td>
			<td><a href="/books/display/${book.id}"><c:out value="${book.bookName}"/></a></td>
			<td><c:out value="${book.author}"/></td>
			<td><c:out value="${book.postedBy.userName}"/></td>
    </tr>
	</c:forEach>
  </tbody>
</table>
</body>
</html>