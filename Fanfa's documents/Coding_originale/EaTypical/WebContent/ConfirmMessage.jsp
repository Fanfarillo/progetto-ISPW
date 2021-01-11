<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Home page tourist</title>
	<link rel="stylesheet" type="text/css" href="confirmMessage.css">
	
</head>

<body>
<div class="container">
	<form action="confirm" name="myform" method="get">
	
		<input id="home" type="submit" name="home" value="Home">
		<input id="manageMenu" type="submit" name="manageMenu" value="Manage Menu">
		<input id="sponsorRestaurant" type="submit" name="sponsorRestaurant" value="Sponsor Restaurant">
		<input id="back" type="submit" name="back" value="Back">
			
		<img id="fotoUtente" src="utente.jpg"/>
		
		<label id="nomeUtente">nomeUtente</label>
		
		<div id="informazioni">
			<p>What would you like to do?</p>
		</div>
		
		<div id="doneBut">
			<input id="Done" class="button" type="submit" name="Done" value="Done">
		</div>
		<div id="DiscardBut">
			<input id="Discard" class="button" type="submit" name="Discard" value="Discard All The Changes">
		</div>
		<div id="keepBut">
			<input id="keep" class="button" type="submit" name="keep" value="Keep Managing Menu">
		</div>
		
		
	</form>
</div>
</body>
</html>