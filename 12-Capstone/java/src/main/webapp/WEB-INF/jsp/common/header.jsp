<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>National Park Weather Service</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Lato&display=swap"
	rel="stylesheet">	
<c:url value="/css/style.css" var="cssHref" />
<link rel="stylesheet" href="${cssHref}">
<link href="https://fonts.googleapis.com/css?family=Open+Sans&display=swap" rel="stylesheet">		
</head>
<body>

	<header>
			<c:url value="/" var="homePageHref" />
			<c:url value="/img/logo.png" var="logoSrc" />


			<div class="navbar navbar-default">
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
	
	</header>