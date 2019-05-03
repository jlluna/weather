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
		        <h2>Weather Error Page</h2>
		        <br></br>
		    </li>
		    <li>
		        <label>Something went wrong when consulting the weather service: </label>
		        <textarea name="json" class="field-long field-textarea">${message}</textarea>
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
