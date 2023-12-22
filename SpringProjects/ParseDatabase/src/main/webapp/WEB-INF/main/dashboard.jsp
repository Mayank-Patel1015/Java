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
      <title>Dashboard</title>
    </head>

    <body>
      <h1>Namaste, ${user.userName}
            <a href="/logout" class="btn btn-outline-danger">Logout</a>
      </h1>
      <table class="table table-light">
        <thead>
          <tr>
            <th scope="col">Class Name</th>
            <th scope="col">Instructor</th>
            <th scope="col">Weekday</th>
            <th scope="col">Price</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${allCourses}" var="course">
            <tr>
              <td>
              	<a href="/courses/display/${course.id}">
                 <c:out value="${course.courseName}" />
                </a>
       			<c:if test="${course.instructor.id == user_id }">
				 <a href="/courses/edit/${course.id}" class="btn btn-outline-primary">Edit</a>
				</c:if>
              </td>
              <td>
                <c:out value="${course.instructor.userName}" />
              </td>
              <td>
                <c:out value="${course.day}" />
              </td>
              <td>
              	<fmt:setLocale value = "en_US"/>
         		<fmt:formatNumber value = "${course.price}" type = "currency"/>
              </td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
      <a href="/courses/create" class="btn btn-outline-success">+ new course</a>
    </body>

    </html>