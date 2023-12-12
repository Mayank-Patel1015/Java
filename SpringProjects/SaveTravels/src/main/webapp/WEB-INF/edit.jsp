<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="/processUpdate/${expense.id}" modelAttribute="expense" method="post">
		<input type="hidden" value="PATCH" name="_method"/>
	    <div>
	        <form:label path="expenseName" > Expense Name</form:label>
	        <form:input type="text" path="expenseName"/>
	        <form:errors path="expenseName"/>
	    </div>
	    <div>
	        <form:label path="vendor" > Vendor</form:label>
	        <form:input type="text" path="vendor"/>
	        <form:errors path="vendor"/>
	    </div>
	    <div>
	        <form:label path="amount" > Amount</form:label>
	        <form:input type="number" path="amount"/>
	        <form:errors path="amount"/>
	    </div>
	    <div>
	        <form:label path="description" > Description</form:label>
	        <form:input type="text" path="description"/>
	        <form:errors path="description"/>
	    </div>
	    <input type="submit" value="Submit" class="btn btn-primary"/>
	</form:form>
</body>
</html>