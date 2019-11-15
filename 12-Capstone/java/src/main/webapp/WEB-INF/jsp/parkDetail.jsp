<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />
<c:set var="parkCode" value="${param.parkCode}" />

<body class="detail-container">
	<div class="detail-head">
		<h1>
			<c:out value="${park.name}" />
		</h1>

		<h5>
			<c:out value="${park.inspQuote}" />
		</h5>
		<h6>
			-
			<c:out value="${park.inspQuoteSource}" />
		</h6>
	</div>
	<div class="col-md-12 park-info-img">
		<div class="col-md-6">
			<img src="img/parks/${parkCode.toLowerCase()}.jpg"
				class="img-thumbnail" />
		</div>

		<div class="park-detail-info col-md-6">
			<p>
				Entry Fee: $
				<c:out value="${park.entryFee}" />
			</p>

			<p>
				Total Number of Camp Sites:
				<c:out value="${park.numOfCampsites}" />
			</p>
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
			<br>
		</div>
	</div>
	<div class="park-desc col-md-12">
		<p>
			<c:out value="${park.parkDescription}" />
		</p>
	</div>

	<c:import url="/WEB-INF/jsp/weather.jsp" />

</body>
</html>
