<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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

			<p>Here is your current asthma information:</p>
			<label>Pollen Type:</label> <i>${pollen.predominantPollen} </i><br>
			<label>Relative Humidity:</label> <i>${conditions.humidity} <br> 
			</i><label>Wind Speed(MPH):</label> <i>${conditions.windSpeed} </i><br> 
			<label>Heat Index:</label> <i>${conditions.temp} </i><br> 
			<label>Pressure Trend:</label> <i>${conditions.pressureTrend} </i><br>
			<label>Pollen Count:</label> <i>${pollen.pollenCount[0]} </i><br>
			<label>Pollution(Air Quality Index):</label> <i>${pollution.airQualityIndex} </i><br>
			<img src = "${forecast.forecastIcon[0]}" alt=  "forecast1">
			<img src = "${forecast.forecastIcon[1]}" alt = "forecast2">
			<img src = "${forecast.forecastIcon[2]}" alt = "forecast3">
			<img src = "${forecast.forecastIcon[3]}" alt = "forecast4">
			<div>
				<script type="text/javascript">
		google.load("visualization", "1.1", {
			packages : [ "corechart" ]
		});
		google.setOnLoadCallback(drawChart);

		function drawChart() {
			var data = new google.visualization.DataTable();
			data.addColumn('string', 'Name');
			data.addColumn('number', 'Danger Level');
			data.addColumn({
				type : 'string',
				role : 'annotation'
			});
			
			data.addRows([ [ 'Pollen', parseInt('${pollen.pollenBar[0]}') , '${pollen.pollenCount[0]}' ],
					[ 'Humidity', parseInt('${conditions.humidityBar}'), '${conditions.humidity} ' ], 
					[ 'Temp', parseInt('${conditions.tempBar}'), '${conditions.temp}' ],
					[ 'Pollution', parseInt('${pollution.airQualityBar}'), '${pollution.airQualityIndex}' ],
					[ 'Wind', parseInt('${conditions.windBar}'), '${conditions.windSpeed}' ], ]);
			
			
			var view = new google.visualization.DataView(data);
			view.setColumns([ 0, 1, 1, 2 ]);

			var chart = new google.visualization.ColumnChart(document
					.getElementById('chart_div'));

			chart.draw(view, {
				height : 400,
				width : 600,
				series : {
					0 : {
						type : 'bars'
					},
					1 : {
						type : 'line',
						color : 'grey',
						lineWidth : 0,
						pointSize : 0,
						visibleInLegend : false
					}
				},
				vAxis : {
					minValue: 0,
					maxValue : 3,
					ticks : [ {v : 1,f : "low"}, {v : 2,f : "medium"}, {v : 3,f : "high"} ]
				}
			});
		}
	</script>

	<div id="chart_div" style="width: 600px; height: 400px;"></div>
			</div>
		</div>
	</div>
	
</body>

<footer><a href="javascript:history.back()">Go Back</a><p>Powered By:</p> <img src="images/wundergroundLogo_4c.png"></footer>
</html>