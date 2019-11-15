<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>National Park Weather Service</title>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Lato&display=swap"
	rel="stylesheet">
<c:url value="/css/style.css" var="cssHref" />
<link rel="stylesheet" href="${cssHref}">
</head>
<body>

	<header>
		<div class="header">
			<h1>Outdoors</h1>
			<h2>is where life happens</h2>

			<c:url value="/" var="homePageHref" />
			<c:url value="/img/logo.png" var="logoSrc" />

			<div class="navbar navbar-default navbar-fixed-top">
				<div class="container">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target=".navbar-collapse">
							<span class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a href="${homePageHref}" class="navbar-brand"> <img
							style="max-width: 105px; margin-top: -3px;" src="${logoSrc}"
							alt="National Park Weather logo" />
						</a>
					</div>
					<div class="navbar-collapse collapse">
						<ul class="nav navbar-nav">
							<li><c:url value="/survey" var="surveyHref" /><a
								href="${surveyHref}">Survey</a></li>
							<li><c:url value="/surveyResult" var="favoriteParksHref" /><a
								href="${favoriteParksHref}">Favorite Parks</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</header>


	<div id="park-container">
		<h1>National Parks</h1>
		<c:forEach var="park" items="${allParks}">
			<div class="col-md-12 individual-park">
				<div class="col-md-4 park-img">
					<c:url value="/parkDetail" var="parkDetail" />

					<a class="park" href="${parkDetail}?parkCode=${park.parkCode}">
						<img src="img/parks/${park.parkCode.toLowerCase()}.jpg" />
						</a>
				</div>

				<div class="col-md-8 park-info">
					<a class="park" href="${parkDetail}?parkCode=${park.parkCode}">
					<h3>
						<c:out value="${park.name}" />
					</h3>
					</a>
					<h4>
						<c:out value="${park.state}" />
					</h4>
					<p>
						<c:out value="${park.parkDescription}" />
					</p>
				</div>
			</div>
		</c:forEach>
	</div>

</body>
</html>
