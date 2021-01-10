<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Scheduling result</title>
	<link rel="stylesheet" type="text/css" href="SchedulingCSS.css">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<script src="js/jquery-3.5.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</head>

<body>
<div class="container">
	<form action="SchedulingView" name="myform" method="get">
		<input id="home" type="submit" name="Home" value="Home">
		<input id="scheduleTrip" type="submit" name="Schedule Trip" value="Schedule Trip">
		<input id="chooseRestaurant" type="submit" name="Choose Restaurant" value="Choose Restaurant">
		<input id="back" type="submit" name="Back" value="Back">
		<img id="fotoUtente" src="utente.jpg"/>
		<label id="nomeUtente">nomeUtente</label>
		
		<input id="changeSettings" class="buttonBelow" type="submit" name="Change Settings" value="Change Settings">
		<input id="generateNewScheduling" class="buttonBelow" type="submit" name="Generate New Scheduling" value="Generate New Scheduling">
		<input id="saveScheduling" class="buttonBelow" type="submit" name="Save Scheduling" value="Save Scheduling">
	</form>
</div>
</body>
</html>