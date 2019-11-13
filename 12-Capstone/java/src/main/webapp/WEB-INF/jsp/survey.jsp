<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:import url="/WEB-INF/jsp/common/header.jsp" />

<body>
	<c:url value="/surveyResult" var="surveyResultUrl" />
	<form:form modelAttribute="surveyResult" action="${surveyResultUrl}" method="POST">

		<label for="email">Email:</label>
		<form:input path="email" class="form-control" />
		<form:errors path="email" cssClass="error" />

		<label for="state">State:</label>
		<form:input path="state" class="form-control" />
		<form:errors path="state" cssClass="error" />

		<label for="activityLevel">Activity Level:</label>
		<select name="activityChoice">
			<option value="inactive">Inactive</option>
			<option value="sedentary">Sedentary</option>
			<option value="active">Active</option>
			<option value="extremelyActive">Extremely Active</option>
		</select>

		<br>
		<br>
		<input type="submit" value="Submit" />

	</form:form>

</body>
</html>