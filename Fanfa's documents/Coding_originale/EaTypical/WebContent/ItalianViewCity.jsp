<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="logic.engineeringclasses.others.Session" %>
<%@page import="logic.engineeringclasses.exceptions.EmptyFieldException" %>

<%
	Session bs = (Session)session.getAttribute("session");
	String errorString = "";
%>

<%    	
    	if(request.getParameter("Home ST1")!=null) {
    		session.setAttribute("session", bs);
%>
			<jsp:forward page="HomePageTouristView.jsp"/>
<%
    	}
    	if(request.getParameter("Choose Restaurant ST1")!=null) {
    		session.setAttribute("session", bs);
%>
			<jsp:forward page="ItalianViewCity2.jsp"/>
<%
    	}	
    	if(request.getParameter("Continue")!=null) {
    		try {	
    			String city = request.getParameter("Scroll");
        		if(city==null) {
    				throw new EmptyFieldException("There is no city selected.");
        		}
    			session.setAttribute("session", bs);
    			session.setAttribute("city", city);
%>
				<jsp:forward page="TripSettingsView.jsp"/>
<%
    		}
    		catch(EmptyFieldException e) {
    			errorString = "There is no city selected.";
    		}
    	}
%>    
    	
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="ISO-8859-1">
	<title>City selection</title>
	<link rel="stylesheet" type="text/css" href="ItalianCSScity.css">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</head>

<body>
<div class="container">
	<form action="ItalianViewCity.jsp" name="myform" method="get">
		<input id="home" type="submit" name="Home ST1" value="Home">
		<input id="scheduleTrip" type="submit" name="Schedule Trip ST1" value="Schedule Trip" disabled>
		<input id="chooseRestaurant" type="submit" name="Choose Restaurant ST1" value="Choose Restaurant">
		<img id="fotoUtente" src="utente.jpg" alt="Photo"/>
		<label id="nomeUtente"><%=bs.getUser().getUsername()%></label>
		<div class="box-1">
			<p>Click on the map or select a city from the drop-down menu:</p>
		</div>
		
		<select id="scrollbar" name="Scroll">
			<option disabled selected>City</option>
			<option value="Aosta">Aosta</option>
			<option value="Torino">Torino</option>
			<option value="Genova">Genova</option>
			<option value="Milano">Milano</option>
			<option value="Trento">Trento</option>
			<option value="Venezia">Venezia</option>
			<option value="Trieste">Trieste</option>
			<option value="Bologna">Bologna</option>
			<option value="Firenze">Firenze</option>
			<option value="Ancona">Ancona</option>
			<option value="Perugia">Perugia</option>
			<option value="Roma">Roma</option>
			<option value="LAquila">L'Aquila</option>
			<option value="Campobasso">Campobasso</option>
			<option value="Napoli">Napoli</option>
			<option value="Potenza">Potenza</option>
			<option value="Bari">Bari</option>
			<option value="Catanzaro">Catanzaro</option>
			<option value="Palermo">Palermo</option>
			<option value="Cagliari">Cagliari</option>
		</select>
		
		<div class="box-2">
			<img id="fotoItalia" src="Cartina.jpg" alt="Italian cities"/>
		    <img id="AostaImg" class="city" src="placeicon.png" alt=".">
			<img id="TorinoImg" class="city" src="placeicon.png" alt=".">
			<img id="GenovaImg" class="city" src="placeicon.png" alt=".">
			<img id="MilanoImg" class="city" src="placeicon.png" alt=".">
			<img id="TrentoImg" class="city" src="placeicon.png" alt=".">
			<img id="VeneziaImg" class="city" src="placeicon.png" alt=".">
			<img id="TriesteImg" class="city" src="placeicon.png" alt=".">
			<img id="BolognaImg" class="city" src="placeicon.png" alt=".">
			<img id="FirenzeImg" class="city" src="placeicon.png" alt=".">
			<img id="AnconaImg" class="city" src="placeicon.png" alt=".">
			<img id="PerugiaImg" class="city" src="placeicon.png" alt=".">
			<img id="RomaImg" class="city" src="placeicon.png" alt=".">
			<img id="LAquilaImg" class="city" src="placeicon.png" alt=".">
			<img id="CampobassoImg" class="city" src="placeicon.png" alt=".">
			<img id="NapoliImg" class="city" src="placeicon.png" alt=".">
			<img id="PotenzaImg" class="city" src="placeicon.png" alt=".">
			<img id="BariImg" class="city" src="placeicon.png" alt=".">
			<img id="CatanzaroImg" class="city" src="placeicon.png" alt=".">
			<img id="PalermoImg" class="city" src="placeicon.png" alt=".">
			<img id="CagliariImg" class="city" src="placeicon.png" alt=".">
		</div>
		
		<label id="errorMsg"><%=errorString%></label>
		<input id="continue" type="submit" name="Continue" value="Continue">
	</form>
</div>


<script>
	$(".city").click(function(e){
	$("#scrollbar").val(e.currentTarget.id.replace("Img","")).change();
	});
</script>


</body>
</html>