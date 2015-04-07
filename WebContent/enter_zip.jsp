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
					name="zip" placeholder="enter zip code" required> 
					
			<button>
			<div class="tile" id="asthma" >
            <p>Asthma</p>
            <img src="images/boyinhaler.png">
       </div>  
       </button> 
	<button>
	<div class="tile" id ="stargazing" >
            <p>Stargazing</p>
            <img src="images/hubble.png">
       </div>
       </button>
       <button>
       <div class="tile" id ="cycling" >
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
