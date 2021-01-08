<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>City selection</title>
	<link rel="stylesheet" type="text/css" href="ItalianCSScity.css">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<script src="js/jquery-3.5.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</head>

<body>
<div class="container">
	<form action="ItalianViewCity.jsp" name="myform" method="get">
		<input id="home" type="submit" name="Home" value="Home">
		<input id="scheduleTrip" type="submit" name="Schedule Trip" value="Schedule Trip">
		<input id="chooseRestaurant" type="submit" name="Choose Restaurant" value="Choose Restaurant">
		<input id="back" type="submit" name="Back" value="Back">
		<img id="fotoUtente" src="utente.jpg"/>
		<label id="nomeUtente">NomeUtente</label>
		<div class="box">
			<p>Click on the map or select a city from the drop-down menu</p>
		</div>
<!--  	<div class="input-group">
			<button class="btn btn-outline-secondary dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">City</button>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="#">Boh</a>
				<a class="dropdown-item" href="#">Mah</a>
			</div>
		</div>		-->
		<select id="scrollbar">
			<option disabled selected>City</option>
			<option>Boh</option>
			<option>Mah</option>
		</select>
		<img id="fotoItalia" src="Cartina.jpg"/>
		<input id="search" type="submit" name="Search" value="Search">
	</form>
</div>
</body>
</html>