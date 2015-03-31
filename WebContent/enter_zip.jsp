<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Asthma Watch</title>
</head>
<body>
	<p>Please enter your zip code for the current asthma information
		and then click the submit button.</p>
	<c:if test="${message != null}">
		<p>
			<i>${message}</i>
		</p>
	</c:if>
	<form action="enter" method="post">
		<label class="pad_top">Zip Code</label> <input type="text"
			name="query" placeholder="48235" value="${user.zipCode}"> <label>&nbsp;</label>
		<input type="submit" value="Submit" class="margin_left">
	</form>
</body>
</html>