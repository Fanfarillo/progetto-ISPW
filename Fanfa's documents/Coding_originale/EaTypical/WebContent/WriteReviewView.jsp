<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Select Restaurant</title>
<link rel="stylesheet" type="text/css" href="WriteReviewViewCSS.css">
</head>
<body>
	<div class="container">
		<form action="WriteReviewView" class="button" name="myform" method="get">
			<input id="home" class="button" type="submit" name="Home" value="Home">
			<input id="scheduleTrip" class="button" type="submit" name="Schedule Trip" value="Schedule Trip">
			<input id="chooseRestaurant" class="button" type="submit" name="Choose Restaurant" value="Choose Restaurant">
			<input id="back" class="button" type="submit" name="Back" value="Back">
			<input id="submitReview" class="button" type="submit" name="Submit Review" value="Submit Review">
			<img id="fotoUtente" src="utente.jpg"/>
			<label id="nomeUtente">nomeUtente</label>
			<textarea id="writeReview" name="Write Review" rows="15">Write here your review...
 			</textarea>
		</form>
	</div>

</body>
</html>