<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>City selection</title>
	<link rel="stylesheet" type="text/css" href="ItalianCitySponsorCSS.css">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<script src="js/jquery-3.5.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</head>

<body>
<div class="container">
	<form action="ItalianCitySponsorView" name="myform" method="get">
		<input id="home" type="submit" name="Home" value="Home">
		<input id="sponsorRestaurant" type="submit" name="Sponsor Restaurant" value="Sponsor Restaurant">
		<input id="manageMenu" type="submit" name="Manage Menu" value="Manage Menu">
		<input id="back" type="submit" name="Back" value="Back">
		<img id="fotoUtente" src="utente.jpg"/>
		<label id="nomeUtente">nomeUtente</label>
		<div class="box-1">
			<p>Click on the map or select a city from the drop-down menu:</p>
		</div>
<!--  	<div class="input-group">
			<button class="btn btn-outline-secondary dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">City</button>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="#">Boh</a>
				<a class="dropdown-item" href="#">Mah</a>
			</div>
		</div>		-->
		<select id="scrollbar" name="Scroll">
			<option disabled selected>City</option>
			<option value="AO">Aosta</option>
			<option value="TO">Torino</option>
			<option value="GE">Genova</option>
			<option value="MI">Milano</option>
			<option value="TN">Trento</option>
			<option value="VE">Venezia</option>
			<option value="TR">Trieste</option>
			<option value="BO">Bologna</option>
			<option value="FI">Firenze</option>
			<option value="AN">Ancona</option>
			<option value="PG">Perugia</option>
			<option value="RM">Roma</option>
			<option value="AQ">L'Aquila</option>
			<option value="CB">Campobasso</option>
			<option value="NA">Napoli</option>
			<option value="PZ">Potenza</option>
			<option value="BA">Bari</option>
			<option value="CZ">Catanzaro</option>
			<option value="PA">Palermo</option>
			<option value="CG">Cagliari</option>
		</select>
		
		<div class="box-2">
			<img id="fotoItalia" src="Cartina.jpg"/>
<!--		<input id="aosta" class="city" type="image" name="Aosta" value="Aosta" src="placeicon.png">
			<input id="torino" class="city" type="image" name="Torino" value="Torino" src="placeicon.png">
			<input id="genova" class="city" type="image" name="Genova" value="Genova" src="placeicon.png">
			<input id="milano" class="city" type="image" name="Milano" value="Milano" src="placeicon.png">
			<input id="trento" class="city" type="image" name="Trento" value="Trento" src="placeicon.png">
			<input id="venezia" class="city" type="image" name="Venezia" value="Venezia" src="placeicon.png">
			<input id="trieste" class="city" type="image" name="Trieste" value="Trieste" src="placeicon.png">
			<input id="bologna" class="city" type="image" name="Bologna" value="Bologna" src="placeicon.png">
			<input id="firenze" class="city" type="image" name="Firenze" value="Firenze" src="placeicon.png">
			<input id="ancona" class="city" type="image" name="Ancona" value="Ancona" src="placeicon.png">
			<input id="perugia" class="city" type="image" name="Perugia" value="Perugia" src="placeicon.png">
			<input id="roma" class="city" type="image" name="Roma" value="Roma" src="placeicon.png">
			<input id="laquila" class="city" type="image" name="L'Aquila" value="L'Aquila" src="placeicon.png">
			<input id="campobasso" class="city" type="image" name="Campobasso" value="Campobasso" src="placeicon.png">
			<input id="napoli" class="city" type="image" name="Napoli" value="Napoli" src="placeicon.png">
			<input id="potenza" class="city" type="image" name="Potenza" value="Potenza" src="placeicon.png">
			<input id="bari" class="city" type="image" name="Bari" value="Bari" src="placeicon.png">
			<input id="catanzaro" class="city" type="image" name="Catanzaro" value="Catanzaro" src="placeicon.png">
			<input id="palermo" class="city" type="image" name="Palermo" value="Palermo" src="placeicon.png">
			<input id="cagliari" class="city" type="image" name="Cagliari" value="Cagliari" src="placeicon.png">		-->
			<input id="aosta" class="city" type="submit" name="Aosta" value="-">
			<input id="torino" class="city" type="submit" name="Torino" value="-">
			<input id="genova" class="city" type="submit" name="Genova" value="-">
			<input id="milano" class="city" type="submit" name="Milano" value="-">
			<input id="trento" class="city" type="submit" name="Trento" value="-">
			<input id="venezia" class="city" type="submit" name="Venezia" value="-">
			<input id="trieste" class="city" type="submit" name="Trieste" value="-">
			<input id="bologna" class="city" type="submit" name="Bologna" value="-">
			<input id="firenze" class="city" type="submit" name="Firenze" value="-">
			<input id="ancona" class="city" type="submit" name="Ancona" value="-">
			<input id="perugia" class="city" type="submit" name="Perugia" value="-">
			<input id="roma" class="city" type="submit" name="Roma" value="-">
			<input id="laquila" class="city" type="submit" name="L'Aquila" value="-">
			<input id="campobasso" class="city" type="submit" name="Campobasso" value="-">
			<input id="napoli" class="city" type="submit" name="Napoli" value="-">
			<input id="potenza" class="city" type="submit" name="Potenza" value="-">
			<input id="bari" class="city" type="submit" name="Bari" value="-">
			<input id="catanzaro" class="city" type="submit" name="Catanzaro" value="-">
			<input id="palermo" class="city" type="submit" name="Palermo" value="-">
			<input id="cagliari" class="city" type="submit" name="Cagliari" value="-">
		</div>
		
		<input id="continue" type="submit" name="Continue" value="Continue">
	</form>
</div>
</body>
</html>