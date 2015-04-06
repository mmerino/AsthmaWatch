<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="enter_zip.css">
<link href='http://fonts.googleapis.com/css?family=Lato:400,700' rel='stylesheet' type='text/css'>
<title>Asthma Watch</title>
</head>
<body>
	<div class="background">
		<div class="transbox">
			<p>Please enter your zip code for the current asthma information
				and then click the submit button.</p>
			<p>
				<i>${message}</i>
			</p>
			<form action="asthmawatch" method="post">
				<label class="pad_top">Zip Code</label> <input type="text"
					name="zip" placeholder="enter zip code" required> <input
					type="submit" value="Submit">
			</form>
			<div class="tile" id="asthma" style="background:url(‘Pic.jpg'); background-size:200px 200px" >

      <div class="caption" onclick=;>
            <p>Asthma</p>
            <p id="description">Some lengthy description that may potentially overflow into two lines</p>
       </div>    
</div>
	<div class="tile" id ="stargazing" style="background:url(‘Pic.jpg'); background-size:200px 200px" >
      <div class="caption" onclick="alert('Hi!');" >
            <p>Stargazing</p>
            <p id="description">Some lengthy description that may potentially overflow into two lines</p>
       </div>
       
       </div>
       <div class="tile" id ="cycling" style="background:url(‘Pic.jpg'); background-size:200px 200px" >
      <div class="caption" onclick="alert('Hi!');" >
            <p>Cycling</p>
            <p id="description">Some lengthy description that may potentially overflow into two lines</p>
       </div>
       </div>
       
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
		</div>
	</div>
</body>
</html>
