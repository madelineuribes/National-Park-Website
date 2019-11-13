<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Your Survey Results!</title>
<link rel="stylesheet" href="style.css"></link>
</head>
<body>

	<c:forEach var="park" items="${favParks}">
		<c:out value="${park.name}" />
		<c:out value="${park.state}" />
		<c:out value="${park.surveyCount}" />
	</c:forEach>

</body>
</html>
