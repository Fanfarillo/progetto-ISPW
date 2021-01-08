<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Restaurant creation</title>
	<link rel="stylesheet" type="text/css" href="CreatingRestaurantCSS.css">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<script src="js/jquery-3.5.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</head>

<body>
<div class="container">
	<form action="CreatingRestaurantView" name="myform" method="get">
		<input id="home" type="submit" name="Home" value="Home">
		<input id="sponsorRestaurant" type="submit" name="Sponsor Restaurant" value="Sponsor Restaurant">
		<input id="manageMenu" type="submit" name="Manage Menu" value="Manage Menu">
		<input id="back" type="submit" name="Back" value="Back">
		<img id="fotoUtente" src="utente.jpg"/>
		<label id="nomeUtente">nomeUtente</label>
		<div class="box-1">
			<p>Please, insert name and address of your restaurant:</p>
		</div>
		<div class="box-2">
			<p>Click here to add a dish into your menu:</p>
		</div>
		<input id="restName" class="textbox" type="text" placeholder="Restaurant name">
		<input id="restAddress" class="textbox" type="text" placeholder="Restaurant address">
		<input id="addDish" class="buttonbelow" type="submit" name="Add Dish" value="Add Dish">
		<input id="done" class="buttonbelow" type="submit" name="Done" value="Done">
	</form>
</div>
</body>
</html>