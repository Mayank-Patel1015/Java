<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
            <title>Create Course</title>
        </head>

        <body>
            <h1>Create a course</h1>
            <form:form action="/courses/process/create" modelAttribute="course" method="post">
                <form:input type="hidden" path="instructor" value="${user_id}" />
                <div>
                    <form:label path="courseName">Name</form:label>
                    <form:input type="text" path="courseName" />
                    <form:errors path="courseName" />
                </div>
                <div>
                    <form:label path="day"> Day of Week</form:label>
                    <form:input type="text" path="day" />
                    <form:errors path="day" />
                </div>
                <div>
                    <form:label path="price"> Drop-in Price</form:label>
                    <form:input type="number" path="price" />
                    <form:errors path="price" />
                </div>
                <div>
                    <form:label path="description"> Description</form:label>
                    <form:input type="text" path="description" />
                    <form:errors path="description" />
                </div>
                <a href="/home">
                <input type="button" value="Cancel" class="btn btn-primary" />
                </a>
                <input type="submit" value="Add Course" class="btn btn-primary" />
            </form:form>

        </body>

        </html>