<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div id="park-container">

	<c:forEach var="park" items="${allParks}">
		<div class="col-md-12">
			<div class="col-md-6 park-img">
				<c:url value="/parkDetail" var="parkDetail" />

				<a class="park" href="${parkDetail}?parkCode=${park.parkCode}">
					<img src="img/parks/${park.parkCode.toLowerCase()}.jpg" />
				</a>
			</div>

			<div class="col-md-6">
				<h3><c:out value="${park.name}" /></h3>

				<p><c:out value="${park.state}" /></p>

				<p><c:out value="${park.parkDescription}" /></p>
			</div>
		</div>
	</c:forEach>
</div>

</body>
</html>
