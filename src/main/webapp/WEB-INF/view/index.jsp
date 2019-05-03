<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
</head>
<body>
	<form  action="/weather" method="get">
		<ul class="form-style-1">
		    <li>
		        <h2>Weather Portal</h2>
		    </li>
		    <li>
		        <hr>
		    </li>
		    <li>
		        <label>Select you city:</label>
		        <select name="city" class="field-select">
		        <option value="London">London</option>
				<option value="Hong+Kong">Hong Kong</option>
		        </select>
		    </li>
		    <li>
		        <br>
		    </li>
		    <li>
		        <input type="submit" value="Submit" />
		    </li>
		</ul>
	</form>
</body>
</html>
