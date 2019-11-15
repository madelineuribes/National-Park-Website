<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<c:url var="parkDetailPost" value="/parkDetail">
	<c:param name="parkCode" value="${park.parkCode}" />
</c:url>

<form action="${parkDetailPost}" method="POST">
	<input type="hidden" name="parkCode" value="${park.parkCode}">
	<input type="submit" name="temp" value="Change to C"> 
	<input type="submit" name="temp" value="Change to F">
</form>

<div class="col-md-12 weather-container">
	<c:forEach var="weather" items="${allWeather}">
		<c:choose>
			<c:when test="${weather.dayValue == 1}">
				<div class="col-md-4 today-forecast">

					<c:if test="${weather.forecast == 'snow'}">
						<img src="img/weather/snow.png" />
						<p>Pack snow shoes</p>
					</c:if>

					<c:if test="${weather.forecast == 'cloudy'}">
						<img src="img/weather/cloudy.png" />

					</c:if>

					<c:if test="${weather.forecast == 'partly cloudy'}">
						<img src="img/weather/partlyCloudy.png" />

					</c:if>

					<c:if test="${weather.forecast == 'rain'}">
						<img src="img/weather/rain.png" />
						<p>Pack rain gear and wear waterproof shoes</p>
					</c:if>

					<c:if test="${weather.forecast == 'thunderstorms'}">
						<img src="img/weather/thunderstorms.png" />
						<p>Seek shelter and avoid hiking on exposed ridges</p>
					</c:if>

					<c:if test="${weather.forecast == 'sunny'}">
						<img src="img/weather/sunny.png" />
						<p>Pack Sun block</p>
					</c:if>

					<c:out value="${weather.forecast}" />

					<c:if test="${temp == 'Change to C'}">
						<c:out value="${weather.lowC}"></c:out>
						<c:out value="${weather.highC}"></c:out>
					</c:if>

					<c:if test="${temp == 'Change to F'}">
						<c:out value="${weather.lowF}"></c:out>
						<c:out value="${weather.highF}"></c:out>
					</c:if>

				</div>
			</c:when>

			<c:otherwise>
				<div class="col-md-8 four-forecast">
					<c:if test="${weather.forecast == 'snow'}">
						<img src="img/weather/snow.png" />
					</c:if>

					<c:if test="${weather.forecast == 'cloudy'}">
						<img src="img/weather/cloudy.png" />
					</c:if>

					<c:if test="${weather.forecast == 'partly cloudy'}">
						<img src="img/weather/partlyCloudy.png" />
					</c:if>

					<c:if test="${weather.forecast == 'rain'}">
						<img src="img/weather/rain.png" />
					</c:if>

					<c:if test="${weather.forecast == 'thunderstorms'}">
						<img src="img/weather/thunderstorms.png" />
					</c:if>

					<c:if test="${weather.forecast == 'sunny'}">
						<img src="img/weather/sunny.png" />

					</c:if>

					<c:if test="${temp == 'Change to C'}">
						<c:out value="${weather.lowC}"></c:out>
						<c:out value="${weather.highC}"></c:out>
					</c:if>

					<c:if test="${temp == 'Change to F'}">
						<c:out value="${weather.lowF}"></c:out>
						<c:out value="${weather.highF}"></c:out>
					</c:if>
				</div>
			</c:otherwise>
		</c:choose>
	</c:forEach>
</div>
