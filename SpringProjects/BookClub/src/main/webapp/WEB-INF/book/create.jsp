<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
	<h1>Add book</h1>
	<form:form action="/books/process/create" modelAttribute="book" method="post">
        <form:input type="hidden" path="postedBy" value="${user_id}"/>
        <div>
            <form:label path="bookName" > Book Name</form:label>
            <form:input type="text" path="bookName"/>
            <form:errors path="bookName"/>
        </div>
        <div>
            <form:label path="author" > Author</form:label>
            <form:input type="text" path="author"/>
            <form:errors path="author"/>
        </div>
        <div>
            <form:label path="myThoughts" > My Thoughts</form:label>
            <form:input type="text" path="myThoughts"/>
            <form:errors path="myThoughts"/>
        </div>
        <input type="submit" value="Add Book" class="btn btn-primary"/>
     </form:form>
        
</body>
</html>