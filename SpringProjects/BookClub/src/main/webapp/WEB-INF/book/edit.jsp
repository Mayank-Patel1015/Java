<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Edit book</h1>
	<form:form action="/books/process/edit/${book.id }" modelAttribute="book" method="post">
		<input type="hidden" value="PATCH" name="_method"/>
        <form:hidden  path="postedBy"/>
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
            <form:label path="myThoughts" > My thoughts: </form:label>
            <form:input type="text" path="myThoughts"/>
            <form:errors path="myThoughts"/>
        </div>
        <input type="submit" value="Edit Book" class="btn btn-primary"/>
     </form:form>
</body>
</html>