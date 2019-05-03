<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
</head>
<body>
	<div>
		<ul class="form-style-1">
		    <li>
		        <h2>Weather Details</h2>
		    </li>
		    <li>
		        <hr>
		    </li>
		    <li>
		    	<label>Date</label>
		    	<input type="text" name="date" class="field-text" readOnly=true value="${response.date}" />
		    </li>
		    <li>
		        <label>City</label>
		        <input type="text" name="city" class="field-text" readOnly=true value="${response.city}" />
		    </li>
		    <li>
		        <label>Weather description</label>
		        <input type="text" name="weather" class="field-text" readOnly=true value="${response.weather}" /> 
		        <input type="text" name="weatherDesc" class="field-divided" readOnly=true value="${response.weatherDesc}" />
		    </li>
		    <li>
		        <label>Temperature in F°</label>
		        <input type="text" name="tempFa" class="field-text" readOnly=true value="${response.tempFa}" />
		    </li>
		    <li>
		        <label>Temperature in C°</label>
		        <input type="text" name="tempCe" class="field-text" readOnly=true value="${response.tempCe}" />
		    </li>
		    <li>
		        <label>Sunrise</label>
		        <input type="text" name="sunrise" class="field-text" readOnly=true value="${response.sunrise}" />
		    </li>
		    <li>
		        <label>Sunset</label>
		        <input type="text" name="sunset" class="field-text" readOnly=true value="${response.sunset}" />
		    </li>
<!-- 		    <li> -->
<!-- 		        <label>JSON Response</label> -->
<%-- 		        <textarea name="json" class="field-long field-textarea">${response.json}</textarea> --%>
<!-- 		    </li> -->
			<li>
		        <br>
		    </li>
		    <li>
		        <form action="/">
				    <input type="submit" value="home" />
				</form>
		    </li>
		</ul>
	</div>
</body>
</html>
