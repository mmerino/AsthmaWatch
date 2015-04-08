<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Weather Watch</title>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<link rel="stylesheet" type="text/css" href="displayResults.css">
<link href='http://fonts.googleapis.com/css?family=Lato:400,700' rel='stylesheet' type='text/css'>
</head>
<body>
<div class="background">
		<div class="transbox" class="double">

			<h1>Thank you for using Weather Watch</h1>
			<div id="background-wrap">
				<div class="x1">
					<div class="cloud"></div>
				</div>


				<div class="x2">
					<div class="cloud"></div>
				</div>

				<div class="x3">
					<div class="cloud"></div>
				</div>

				<div class="x4">
					<div class="cloud"></div>
				</div>

				<div class="x5">
					<div class="cloud"></div>
				</div>
			</div>
<p>Here is your current stargazing information:</p>
			<label>Percentage of Moon Illuminated:</label>${astronomy.percentIlluminated}<br>
			<label>Phase of the Moon:</label>${astronomy.moonPhase}<br> 
			<label>Precipitation:</label>${conditions.oneHourPrecip}<br>
			<label>Pollution(Air Quality Index):</label>${pollution.airQualityIndex} <br>
			<img src = "${forecast.forecastIcon[0]}" alt=  "forecast1">
			<img src = "${forecast.forecastIcon[1]}" alt = "forecast2">
			<img src = "${forecast.forecastIcon[2]}" alt = "forecast3">
			<img src = "${forecast.forecastIcon[3]}" alt = "forecast4">
			<div>
</body>
</html>