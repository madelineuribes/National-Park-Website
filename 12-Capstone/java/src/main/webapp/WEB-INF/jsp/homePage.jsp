<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<section class="park-container">

	<c:forEach var="park" items="${allParks}">
		<div class="park-img">
			<c:url value ="/parkDetail" var="parkDetail"/>
			
			<a class="park"
			href="${parkDetail}?parkCode=${park.parkCode}">
			<img src="img/parks/${park.parkCode.toLowerCase()}.jpg"/>
			</a>
		</div>

		<div class="park-info">
			<h2>
				<c:out value="${park.name}" />
			</h2>
			
			<p><c:out value="${park.state}" /></p>
		
			<p><c:out value="${park.parkDescription}" /></p>
		</div>
	</c:forEach>
</section>

</body>
</html>
