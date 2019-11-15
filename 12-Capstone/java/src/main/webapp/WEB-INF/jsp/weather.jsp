<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:url var="parkDetailPost" value="/parkDetail">
	<c:param name="parkCode" value="${park.parkCode}" />
</c:url>

<h2>5 Day Forecast</h2>
<div class="col-md-12">

	<c:url var="formAction" value="/parkDetail" />
	<form method="POST" action="${formAction}">
		<div class="btn-fahrenheit">
			<input type="hidden" name="tempFC" value="Fahrenheit" /> <input
				type="hidden" name="parkCode" value="${park.parkCode}" /> <input
				class="btn btn-primary mb-2" type="submit" name="false"
				value="Fahrenheit" />
		</div>
	</form>
	<br>
	<form method="POST" action="${formAction}">
		<div class="btn-celsius">
			<input type="hidden" name="tempFC" value="Celsius" /> <input
				type="hidden" name="parkCode" value="${park.parkCode}" /> <input
				class="btn btn-primary mb-2" type="submit" name="true"
				value="Celsius" />
		</div>
	</form>
	<br>
</div>

<div class="col-md-12 weather-container ">

	<c:forEach var="weather" items="${allWeather}">

		<c:choose>

			<c:when test="${weather.dayValue == 1}">

				<div class="col-md-4 today-forecast">
					<h3>
						<c:out value="${weather.forecast}" />
					</h3>

					<c:if test="${weather.forecast == 'snow'}">
						<img src="img/weather/snow.png" />
						<p>Pack snow shoes.</p>
					</c:if>

					<c:if test="${weather.forecast == 'cloudy'}">
						<img src="img/weather/cloudy.png" />

					</c:if>

					<c:if test="${weather.forecast == 'partly cloudy'}">
						<img src="img/weather/partlyCloudy.png" />

					</c:if>

					<c:if test="${weather.forecast == 'rain'}">
						<img src="img/weather/rain.png" />
						<p>Pack rain gear and wear waterproof shoes.</p>
					</c:if>

					<c:if test="${weather.forecast == 'thunderstorms'}">
						<img src="img/weather/thunderstorms.png" />
						<p>Seek shelter and avoid hiking on exposed ridges.</p>
					</c:if>

					<c:if test="${weather.forecast == 'sunny'}">
						<img src="img/weather/sunny.png" />
						<p>Pack Sun block.</p>
					</c:if>

					<c:if test="${weather.highF > 75}">
						<p>Bring an extra gallon of water.</p>
					</c:if>

					<c:if test="${weather.highF - weather.lowF > 20}">
						<p>Wear breathable layers.</p>
					</c:if>

					<c:if test="${weather.lowF < 20}">
						<p>Long exposure to frigid temperatures can be dangerous.</p>
					</c:if>

					<c:choose>
						<c:when test="${celcius}">
							<p>
								High:
								<fmt:formatNumber maxFractionDigits="0">
									<c:out value="${(weather.highF - 32) * 5 / 9}" />
								</fmt:formatNumber>
								°C
							</p>
							<p>
								Low:
								<fmt:formatNumber maxFractionDigits="0">
									<c:out value="${(weather.lowF - 32) * 5 / 9}" />
								</fmt:formatNumber>
								°C
							</p>
						</c:when>

						<c:otherwise>
							<p>
								<c:out value="${weather.lowF}"></c:out>
								°F
							</p>
							<p>
								<c:out value="${weather.highF}"></c:out>
								°F
							</p>
						</c:otherwise>
					</c:choose>


				</div>
			</c:when>

			<c:otherwise>
				<div class="col-md-1.5 four-forecast ">
					<h6>
						<c:out value="${weather.forecast}" />
					</h6>
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

					<c:choose>
						<c:when test="${celcius}">
							<p>
								<fmt:formatNumber maxFractionDigits="0">
									<c:out value="${(weather.highF - 32) * 5 / 9}" />
								</fmt:formatNumber>
								°C
							</p>
							<p>
								<fmt:formatNumber maxFractionDigits="0">
									<c:out value="${(weather.lowF - 32) * 5 / 9}" />
								</fmt:formatNumber>
								°C
							</p>
						</c:when>

						<c:otherwise>
							<p>
								<c:out value="${weather.lowF}"></c:out>
								°F
							</p>
							<p>
								<c:out value="${weather.highF}"></c:out>
								°F
							</p>

						</c:otherwise>
					</c:choose>

				</div>
			</c:otherwise>
		</c:choose>
	</c:forEach>
</div>
