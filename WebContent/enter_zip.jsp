<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="enter_zip.css">
		<link href='http://fonts.googleapis.com/css?family=Lato:400,700' rel='stylesheet' type='text/css'>
		<title>Weather Watch</title>
	</head>
	
	<body>
		<div class="background">
			<div class="transbox">
			<h1> Welcome To Weather Watch!</h1>
				<h2>
					Please enter your zip code and choose a condition button.
				</h2>
				<p>
					<i>${message}</i>
				</p>
				<form action="asthmawatch" method="post">
					<input type="hidden" name="type" value="asthma">

					<label class="pad_top">Zip Code</label> <input type="text"
						name="zip" placeholder="enter zip code" required> <br>
					<button id="stargazing" onClick="document.forms[0].elements['type'].value='asthma'">
						<div class="tile" >
							<p>Asthma</p>
							<img src="images/boyinhaler.png">
						</div>
					</button>
					<button id="stargazing" onClick="document.forms[0].elements['type'].value='stargazing'">
						<div class="tile"  >
							<p>Stargazing</p>
							<img src="images/hubble.png">
						</div>
					</button>
					<button id="cycling" onClick="document.forms[0].elements['type'].value='cycling'">
						<div class="tile" >
							<p>Cycling</p>
							<img src="images/oldbike.png">
						</div>
					</button>
				</form>
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