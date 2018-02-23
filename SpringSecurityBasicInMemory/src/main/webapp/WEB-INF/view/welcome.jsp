<%@ page language="java" contentType="text/html;
charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;
charset=ISO-8859-1">
<title>HelloWorld page</title>
</head>
<body>
	Greeting : ${greeting} This is a welcome page.
	<br />
	<br />
	<br />
	<a href="<c:url value="/admin" />">Admin Page</a> ( Only Admin user can
	access this )
	<br />
	<br />
	<a href="<c:url value="/api" />">API Page</a> ( Admin or API user can
	access this )

</body>
</html>