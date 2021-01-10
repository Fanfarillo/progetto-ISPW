<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Read Reviews</title>
<link rel="stylesheet" type="text/css" href="ReadReviewsCSS.css">
</head>
<body>
	<div class="container">
		<form action="TripSettingsView" name="myform" method="get">
			<input id="home" type="submit" name="Home" value="Home">
			<input id="scheduleTrip" type="submit" name="Schedule Trip" value="Schedule Trip">
			<input id="chooseRestaurant" type="submit" name="Choose Restaurant" value="Choose Restaurant">
			<input id="back" type="submit" name="Back" value="Back">
			<img id="fotoUtente" src="utente.jpg"/>
			<label id="nomeUtente">nomeUtente</label>
		</form>
	</div>

</body>
</html>