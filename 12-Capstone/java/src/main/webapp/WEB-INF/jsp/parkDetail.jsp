<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />
<c:set var="parkCode" value="${param.parkCode}" />

<body>
	<div class="col-md-12 detail-container">
		<div class="park-detail-img">
			<img src="img/parks/${parkCode.toLowerCase()}.jpg" />
		</div>

		<div class="park-detail-info">
			<h3>
				<c:out value="${park.name}" />
			</h3>
			<p>
				<c:out value="${park.inspQuote}" />
			</p>
			<p>
				-
				<c:out value="${park.inspQuoteSource}" />
			</p>
			<br>
			<p>
				Acreage:
				<c:out value="${park.acreage}" />
			</p>
			<p>
				Elevation:
				<c:out value="${park.elevation}" />
			</p>
			<p>
				Total Miles on Trail:
				<c:out value="${park.milesOfTrail}" />
			</p>
			<p>
				Total Number of Camp Sites:
				<c:out value="${park.numOfCampsites}" />
			</p>
			<p>
				Climate:
				<c:out value="${park.climate}" />
			</p>
			<p>
				Year Founded:
				<c:out value="${park.yearFounded}" />
			</p>
			<p>
				Annual Visitors:
				<c:out value="${park.annualVisitorCount}" />
			</p>
			<p>
				Number of Animal Species:
				<c:out value="${park.numOfAnimalSpecies}" />
			</p>
			<p>
				Entry Fee:
				<c:out value="${park.entryFee}" />
			</p>
			<br>
			<p>
				<c:out value="${park.parkDescription}" />
			</p>
		</div>
	</div>
	
	<c:import url="/WEB-INF/jsp/weather.jsp" />
	
</body>
</html>
