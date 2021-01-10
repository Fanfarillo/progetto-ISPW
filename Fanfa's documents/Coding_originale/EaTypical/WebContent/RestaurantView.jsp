<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Select Restaurant</title>
<link rel="stylesheet" type="text/css" href="RestaurantViewCSS.css">
</head>
<body>
	<div class="container">
		<form action="RestaurantView" class="button" name="myform" method="get">
			<input id="home" class="button" type="submit" name="Home" value="Home">
			<input id="scheduleTrip" class="button" type="submit" name="Schedule Trip" value="Schedule Trip">
			<input id="chooseRestaurant" class="button" type="submit" name="Choose Restaurant" value="Choose Restaurant">
			<input id="back" class="button" type="submit" name="Back" value="Back">
			<input id="saveFavourite" class="button" type="submit" name="Save Restaurant into Favourite" value="Save Restaurant into Favourite">
			<input id="readReviews" class="button" type="submit" name="Read Reviews" value="Read Reviews">
			<input id="writeReview" class="button" type="submit" name="Write Review" value="Write Review">
			<img id="fotoUtente" src="utente.jpg"/>
			<label id="nomeUtente">nomeUtente</label>
			<table id="table1">
				 <colgroup>
					<col width="45%">
					<col width="55%">
				</colgroup> 
			  <tr>
			    <th><b>Restaurant Name</b></th>
			    <th><b>Address</b></th>
			  </tr>		  
			</table>
		</form>
	</div>

</body>
</html>