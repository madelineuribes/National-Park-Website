<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>National Park Weather Service</title>

<c:url value="/css/style.css" var="cssHref" />
<link rel="stylesheet" href="${cssHref}">
</head>
<body>

	<header>
		<c:url value="/" var="homePageHref" />
		<c:url value="/img/logo.png" var="logoSrc" />

		<a href="${homePageHref}"> <img src="${logoSrc}"
			alt="National Park Weather logo" />
		</a>

		<nav>
			<ul> 
				<li><c:url value="/" var="homeHref" /><a
					href="${homeHref}">Home</a></li>
			</ul>
			
			<ul>
				<li><c:url value="/survey" var="surveyHref" /><a
					href="${surveyHref}">Survey</a></li>
			</ul>

			<ul>
				<li><c:url value="/favoriteParks" var="favoriteParksHref" /><a
					href="${favoriteParksHref}">Favorite Parks</a></li>
			</ul>

		</nav>
	</header>

