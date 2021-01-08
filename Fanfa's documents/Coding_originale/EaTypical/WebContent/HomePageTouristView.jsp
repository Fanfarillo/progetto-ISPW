<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Home page tourist</title>
	<link rel="stylesheet" type="text/css" href="HomePageTouristCSS.css">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<script src="js/jquery-3.5.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</head>

<body>
<div class="container">
	<form action="HomePageTouristView" name="myform" method="get">
		<img id="fotoUtente" src="utente.jpg"/>
		<label id="nomeUtente">nomeUtente</label>
		<div class="box">
			<p>Hi!</p>
		</div>
		<input id="chooseRestaurant" class="button" type="submit" name="Choose Restaurant" value="Choose Restaurant">
		<input id="scheduleTrip" class="button" type="submit" name="Schedule Trip" value="Schedule Trip">
		<input id="seeFavRestaurants" class="button" type="submit" name="See Your Favourite Restaurants" value="See Your Favourite Restaurants">
		<input id="seeTrips" class="button" type="submit" name="See Your Trips" value="See Your Trips">
		<input id="logout" class="button" type="submit" name="Logout" value="Logout">
	</form>
</div>
</body>
</html>