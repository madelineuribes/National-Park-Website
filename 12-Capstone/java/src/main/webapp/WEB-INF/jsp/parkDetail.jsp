<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />
<c:set var="parkCode" value="${param.parkCode}" />
<c:set var="park" value="${param.park}" />

<body>
	<div class="park-detail-img">
		<img src="img/parks/${parkCode.toLowerCase()}.jpg" />
	</div>
	
	<div class="park-detail-info">
		<h3><c:out value="${park.name}"/></h3>
	</div>
</body>
</html>