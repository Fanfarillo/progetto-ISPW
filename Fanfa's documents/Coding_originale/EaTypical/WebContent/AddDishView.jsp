<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="logic.engineeringclasses.others.SizedStack" %>

<%
	if(request.getParameter("home1")!=null) {
		SizedStack.getSizedStack(true).clearStack();
		%>
		<jsp:forward page="HomePageOwner.jsp"></jsp:forward>
		<%
	}
%>

<%
	if(request.getParameter("manageMenu1")!=null) {
		SizedStack.getSizedStack(true).push("RestaurantMenuview.jsp");
		%>
		<jsp:forward page="RestaurantMenuview.jsp"></jsp:forward>
		<%
	}
%>

<%
	if(request.getParameter("sponsorRestaurant1")!=null) {
		SizedStack.getSizedStack(true).push("CreatingRestaurantView.jsp");
		%>
		<jsp:forward page="CreatingRestaurantView.jsp"></jsp:forward>
		<%
	}
%>

<%
	if(request.getParameter("continue1")!=null) {
		SizedStack.getSizedStack(true).push("ConfirmMessage.jsp");
		%>
		<jsp:forward page="ConfirmMessage.jsp"></jsp:forward>
		<%
	}
%>

<%
	if(request.getParameter("back1")!=null) {		
		%>
		<jsp:forward page="RestaurantMenuview.jsp"></jsp:forward>
		<%		
	}
%>

<!-- INIZIO CODICE HTML -->

<!DOCTYPE html>

<html>
<head>

<link rel="stylesheet" type="text/css" href="prova.css">
<meta charset="ISO-8859-1">
<title>Add Dish</title>
</head>
<body>

	<div class="container">
		<form action="AddDishView.jsp" name="myform" method="get">
		
			<input id="home" type="submit" name="home1" value="Home">
			<input id="manageMenu" type="submit" name="manageMenu1" value="Manage Menu">
			<input id="sponsorRestaurant" type="submit" name="sponsorRestaurant1" value="Sponsor Restaurant">
			<input id="back" type="submit" name="back1" value="Back">
			
			<img id="fotoUtente" alt="fotoUtente" src="utente.jpg"/>
			<label id="nomeUtente">NomeUtente</label>  
			
			
			
			<div id="informazioni">
				<p>Please, select the dish you would add into menu:</p>							
			</div>
			
			<div id="containerSelect">
				<select id="select" name="piatto">
					<option>opzione 1</option>
					<option>opzione 2</option>
				</select>				
			</div>	
			
			<div id="cont">
				<select id="sel" name="ristorante">
					<option>opzione 1</option>
					<option>opzione 2</option>
				</select>				
			</div>
			
			
			
			
			
			<div id="price">
				<input type="text" id="priceInput" name="prezzo" value="Insert new Price">
			</div>
			
			<div id="check">
				<input type="checkbox"  id="c1" name="c1" value="Vegan" >
  				<label for="c1" id="l1"> Vegan</label><br>
  				<input type="checkbox" id="c2" name="c2" value="Celiac">
  				<label for="c2" id="l2"> Celiac</label><br>			
			</div>
			
			<div>
				<textarea id = "area" rows="15" cols="76" name="ricetta">Scrivi ricetta...</textarea>
			</div>
			
			<div>
				<input type="submit" id="continue" value="OK" name="continue1">
			</div>
			
			
			
		</form>
	</div>
	
</body>
</html>