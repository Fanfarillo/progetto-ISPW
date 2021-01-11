<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Home page tourist</title>
	<link rel="stylesheet" type="text/css" href="HomePageOwner.css">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<script src="js/jquery-3.5.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</head>

<body>
<div class="container">
	<form action="HomePageOwner" name="myform" method="get">
		<img id="fotoUtente" src="utente.jpg"/>
		<label id="nomeUtente">nomeUtente</label>
		<div class="box">
			<p>Hi!</p>
		</div>
		<input id="Manage" class="button" type="submit" name="manage" value="Manage Menu">
		<input id="Sponsor" class="button" type="submit" name="sponsor" value="Sponsor Restaurant">
		
		<input id="logout" class="button" type="submit" name="logout" value="Logout">
	</form>
</div>
</body>
</html>