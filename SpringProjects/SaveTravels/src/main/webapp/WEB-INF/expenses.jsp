<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Save Travels</title>
</head>
<body>
<h1>
	Save Travels
</h1>
<table>
  <tr>
    <th>Expense</th>
    <th>Vendor</th> 
    <th>Amount</th>
    <th>Actions</th>
  </tr>
  <c:forEach items="${allExpenses}" var="expense">
  <tr>
    <td><c:out value="${expense.expenseName}"/></td>
    <td><c:out value="${expense.vendor}"/></td> 
    <td><c:out value="${expense.amount}"/></td>
    <td><a href="/expenses/edit/${expense.id}"><c:out value="edit"/></a>
    	<form action="/delete/${expense.id}" method="post">
			<input type="hidden" name="_method" value="DELETE"/>
			<input type="submit" value="delete" class="btn btn-outline-danger"/>
		</form>
    </td>
  </tr>
  </c:forEach>
</table>

<h2>Add an Expense</h2>
<form:form action="/process" modelAttribute="expense" method="post">
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