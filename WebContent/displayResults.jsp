<!DOCTYPE html
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Asthma Watch</title>
<script type="text/javascript" src="scripts/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="scripts/jqBarGraph.1.1.min.js"></script>
</head>
<body>
<h1>Thanks for using AsthmaWatch</h1>
<p>Here is your current asthma information:</p>
<label>Asthma Condition:</label><br>
<label>Relative Humidity:</label><br>
<label>Wind Speed(MPH):</label><br>
<label>Heat Index:</label><br>
<label>Pressure Trend:</label><br>
<label>Pollen Count:</label><br>
<div id="divForGraph" style="width:100%; height:100%; border:1px solid black;">
   </div>
   <script type="text/javascript">

 arrayOfData = new Array(
     [10.3,'Jan','#f3f3f3'],
     [15.2,'Feb','#f4f4f4'],
     [13.1,'Mar','#cccccc'],
     [16.3,'Apr','#333333'],
     [14.5,'May','#666666']
);
   $('#divForGraph').jqBarGraph({ data: arrayOfData });

   </script>one
</body>
</html>