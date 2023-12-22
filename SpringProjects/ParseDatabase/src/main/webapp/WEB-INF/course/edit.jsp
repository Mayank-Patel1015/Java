<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@ page isErrorPage="true" %>
            <!DOCTYPE html>
            <html>

            <head>
	            <!-- for Bootstrap CSS -->
	            <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
                <meta charset="ISO-8859-1">
                <title>Update Course</title>
            </head>

            <body>
                <h1>${course.courseName}</h1>
                <form:form action="/courses/process/edit/${course.id }" modelAttribute="course" method="post">
                    <input type="hidden" value="PATCH" name="_method" />
                    <form:hidden path="instructor" />
                    <div>
                        <form:label path="courseName"> Name</form:label>
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
                        <form:label path="description"> Description </form:label>
                        <form:input type="text" path="description" />
                        <form:errors path="description" />
                    </div>
                    <a href="/home">
	               		<input type="button" value="Cancel" class="btn btn-primary" />
	               	</a>
                    <input type="submit" value="Sumbit" class="btn btn-primary" />
                </form:form>
                    <form action="/courses/delete/${course.id}" method="post">
						<input type="hidden" name="_method" value="DELETE" />
						<input type="submit" value="delete" class="btn btn-outline-danger" />
					</form>
            </body>

            </html>