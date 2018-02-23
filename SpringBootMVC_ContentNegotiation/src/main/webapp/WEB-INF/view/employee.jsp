<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head></head>
<body>
	<h1>List of employees</h1>
	<c:forEach items="${empList}" var="item">
    <c:out value="${item.id}"/>
    <c:out value="${item.firstName}"/><br>
	</c:forEach>
</body>
</html>