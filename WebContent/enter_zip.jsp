<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Asthma Watch</title>
</head>
<body>
	<p>Please enter your zip code for the current asthma information
		and then click the submit button.</p>
		<p>
			<i>${message}</i>
		</p>
	<form action="asthmawatch" method="post">
		<label class="pad_top">Zip Code</label> 
		<input type="text" name="zip" placeholder = "enter zip code" required>
		<input type="submit" value="Submit">
	</form>
</body>
</html>
