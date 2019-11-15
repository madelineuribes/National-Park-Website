<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/WEB-INF/jsp/common/header.jsp" />

<body id="favorite-parks-page">

	<h1>Favorite Parks</h1>

	<div class="col-md-12 fav-park">
		<c:forEach var="park" items="${favParks}">
			<div class="col-md-4">
				<h4>
					<c:out value="${park.name}" />
				</h4>
				
				<p>
					<c:out value="${park.state}" />
				</p>
				<p>
					Survey Count:
					<c:out value="${park.surveyCount}" />
				</p>
			</div>
		</c:forEach>
	</div>

</body>
</html>
