<!DOCTYPE html
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Asthma Watch</title>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<link rel="stylesheet" type="text/css" href="displayResults.css">
</head>
<body>
<h1>Thanks for using AsthmaWatch</h1>
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
<label>Asthma Condition:</label><br>
<label>Relative Humidity:</label><br>
<label>Wind Speed(MPH):</label><br>
<label>Heat Index:</label><br>
<label>Pressure Trend:</label><br>
<label>Pollen Count:</label>${pollen.forecast[0]}<br>
</div>
    <script type="text/javascript">
      google.load('visualization', '1.1', {'packages':['bar']});
      google.setOnLoadCallback(drawChart);
      function drawChart() {
      
        //need name of variable, ie asthmaData, write ${asthmaData}, how to set that variable in javascript
        var data = new google.visualization.arrayToDataTable([
                    [ 'Relative Humidity', 'Wind Speed', 'Heat Index', 'Pressure Trend', 'Pollen Count' ],
                    [ '2014', 1000, 400, 200, 500 ], 
                    [ '2015', 1170, 460, 250, 500 ],
                    [ '2016', 660, 1120, 300, 500 ], 
                    [ '2017', 1030, 540, 350, 500 ] ]);

            var options = {
                'title' : 'Three Day Asthma Forecast',
                'width' : 400,
                'height' : 300,
                colors : [ '#e0440e', '#e6693e', '#ec8f6e', '#f3b49f',
                        '#f6c7b6' ],
                is3D : true
            };

            var chart = new google.charts.Bar(document
                    .getElementById('columnchart_material'));

            chart.draw(data, options);

        }
    </script>
  </head>

  <body>
<div id="columnchart_material" style="width: 900px; height: 500px;"></div>
</body>
</html>