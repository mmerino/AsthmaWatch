<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Weather Watch</title>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<link rel="stylesheet" type="text/css" href="StargazingResults.css">
<link href='http://fonts.googleapis.com/css?family=Lato:400,700' rel='stylesheet' type='text/css'>
</head>
<body>
<div class="background">
		<div class="transbox" class="double">
			<h1>Thank you for using Weather Watch</h1>
			<div id="background-wrap">
			<div class="stars"></div>
			<div class="twinkling"></div>
			<div class="clouds"></div>
		</div>
<p>Here is your current stargazing information:</p>
			<label>Percentage of Moon Illuminated:</label><i>${astronomy.percentIlluminated}</i><br>
			<label>Phase of the Moon:</label><i>${astronomy.moonPhase}</i><br> 
			<label>Precipitation:</label><i>${conditions.oneHourPrecip}</i><br>
			<label>Pollution(Air Quality Index):</label><i>${pollution.airQualityIndex}</i><br>
			<label>Sunrise:</label><i>${astronomy.sunrise}</i><br>
			<label>Sunset:</label><i>${astronomy.sunset}</i><br>
			<img src = "${forecast.forecastIcon[0]}" alt=  "forecast1">
			<img src = "${forecast.forecastIcon[1]}" alt = "forecast2">
			<img src = "${forecast.forecastIcon[2]}" alt = "forecast3">
			<img src = "${forecast.forecastIcon[3]}" alt = "forecast4"><br>
			<label>Current Phase:</label><br>
			<img src="${astronomy.moonPic}"><br>
			
			<a href="javascript:history.back()">Go Back</a>
			
		</div>
	</div>
	
</body>
<footer><img src="images/wundergroundLogo_4c.png"></footer>
</html>
