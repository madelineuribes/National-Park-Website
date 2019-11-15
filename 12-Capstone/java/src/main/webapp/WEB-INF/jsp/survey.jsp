<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:import url="/WEB-INF/jsp/common/header.jsp" />

<body>
	<c:url value="/survey" var="surveyResultUrl" />
	<div class="col-sm-6 offset-sm-3 text-center">
		<form:form modelAttribute="survey" action="${surveyResultUrl}"
			method="POST">

			<label for="parkCode">Please Vote On Your Favorite Park:</label>
			<select name="parkCode">
				<c:forEach var="park" items="${allParks}">
					<option value="${park.parkCode}"><c:out
							value="${park.name }" />


					</option>
				</c:forEach>

			</select>


			<br>
			<br>

			<label for="email">Your Email:</label>
			<form:input path="email" class="form-control" />
			<form:errors path="email" cssClass="error" />
			<br>
			<br>
			<label for="state">Your State:</label>
			<form:input path="state" class="form-control" />
			<form:errors path="state" cssClass="error" />
			<br>
			<br>

			<label for="activityLevel">Your Daily Activity Level:</label>
			<select name="activityLevel">
				<option value="inactive">Inactive</option>
				<option value="sedentary">Sedentary</option>
				<option value="active">Active</option>
				<option value="extremelyActive">Extremely Active</option>
			</select>

			<br>
			<br>
			<input type="submit" value="Submit" />

		</form:form>
	</div>
</body>
</html>