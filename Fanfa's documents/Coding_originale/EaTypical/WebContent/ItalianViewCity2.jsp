<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<%@page import="logic.engineeringclasses.others.Session" %>
 <%Session bs;
  bs=(Session)session.getAttribute("session"); 
  String userString;
  boolean loginError=false;
  if(bs!=null&&bs.getUser()!=null) {
  	userString=bs.getUser().getUsername();
  }
  else {
  	userString = "Not logged";
  }
  
  %>


<% boolean notSelectedCity=false; %>
<%    	
    	if(request.getParameter("Home ivc2")!=null) {
%> 
			<jsp:forward page="HomePageTouristView.jsp"/>
<%
    	}
    	if(request.getParameter("Schedule Trip ivc2")!=null) {
    		if(bs==null||bs.getUser()==null) loginError=true;
    		else{
%>
			<jsp:forward page="ItalianViewCity.jsp"/>
<%
    		}
    	}
    	
    	if(request.getParameter("Continue ivc2")!=null) {
    		String city=request.getParameter("Scroll");    		
    		if(city!=null)
    		{
    			if(city.equals("AO"))
    				city="Aosta";
    			else if(city.equals("TO")){
    				city="Torino";}
    			else if(city.equals("GE")){
    				city="Genova";}
    			else if(city.equals("MI")){
    				city="Milano";}
    			else if(city.equals("TN")){
    				city="Trento";}
    			else if(city.equals("VE")){
    				city="Venezia";}
    			else if(city.equals("TR")){
    				city="trento";}
    			else if(city.equals("BO")){
    				city="Bologna";}
    			else if(city.equals("FI")){
    				city="Firenze";}
    			else if(city.equals("AN")){
    				city="Ancona";}
    			else if(city.equals("PG")){
    				city="Perugia";}
    			else if(city.equals("RM")){
    				city="Roma";}
    			else if(city.equals("AQ")){
    				city="L Aquila";}
    			else if(city.equals("CB")){
    				city="Campobasso";}
    			else if(city.equals("NA")){
    				city="Napoli";}
    			else if(city.equals("PZ")){
    				city="Potenza";}
    			else if(city.equals("BA")){
    				city="Bari";}
    			else if(city.equals("CZ")){
    				city="Catanzaro";}
    			else if(city.equals("PA")){
    				city="Palermo";}
    			else{
    				city="Cagliari";}
    			
    			session.setAttribute("city",city);
    			%>
    				 <jsp:forward page="RestaurantView.jsp"/> 
    			<%
    		}
    		else{
    			notSelectedCity=true;
    		}     		    		   		     		
    	}
%>    

    
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="ISO-8859-1">
	<title>City selection</title>
	<link rel="stylesheet" type="text/css" href="ItalianCityViewCSS.css">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</head>

<body>

<div class="container">
	<form action="ItalianViewCity2.jsp" name="myform" method="get">
		<input id="home" type="submit" name="Home ivc2" value="Home">
		<input id="scheduleTrip" type="submit" name="Schedule Trip ivc2" value="Schedule Trip">
		<input id="chooseRestaurant" type="submit" name="Choose Restaurant ivc2" value="Choose Restaurant" disabled>
		<img id="fotoUtente" src="utente.jpg" alt="userphoto"/>
		
		<label id="nomeUtente"><%=userString %></label>
		<label id="selectCity">Click on the map or select a city from the drop-down menu:</label>
		<% if(loginError){ %><label id="loginError">you must be logged to use this function.</label><% } %>
		
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
			<option value="AQ">L Aquila</option>
			<option value="CB">Campobasso</option>
			<option value="NA">Napoli</option>
			<option value="PZ">Potenza</option>
			<option value="BA">Bari</option>
			<option value="CZ">Catanzaro</option>
			<option value="PA">Palermo</option>
			<option value="CG">Cagliari</option>
		</select>
		
		
		
		
		
		<div class="box-2">
			<img id="fotoItalia" src="Cartina.jpg" alt="cartina"/>
		    <img id="AO_img" class="city" src="placeicon.png" alt="city">
			<img id="TO_img" class="city"  src="placeicon.png" alt="city">
			<img id="GE_img" class="city"  src="placeicon.png" alt="city">
			<img id="MI_img" class="city"  src="placeicon.png" alt="city">
			<img id="TN_img" class="city"    src="placeicon.png" alt="city">
			<img id="VE_img" class="city"  src="placeicon.png" alt="city">
			<img id="TR_img" class="city"  src="placeicon.png" alt="city">
			<img id="BO_img" class="city"  src="placeicon.png" alt="city">
			<img id="FI_img" class="city"  src="placeicon.png" alt="city">
			<img id="AN_img" class="city"  src="placeicon.png" alt="city">
			<img id="PG_img" class="city"  src="placeicon.png" alt="city">
			<img id="RM_img" class="city"  src="placeicon.png" alt="city">
			<img id="AQ_img" class="city"  src="placeicon.png" alt="city">
			<img id="CB_img" class="city"  src="placeicon.png" alt="city">
			<img id="NA_img" class="city" src="placeicon.png" alt="city">
			<img id="PZ_img" class="city"  src="placeicon.png" alt="city">
			<img id="BA_img" class="city"  src="placeicon.png" alt="city">
			<img id="CZ_img" class="city"  src="placeicon.png" alt="city">
			<img id="PA_img" class="city"  src="placeicon.png" alt="city">
			<img id="CG_img" class="city"  src="placeicon.png" alt="city">		

		</div>
		
		<% if(notSelectedCity){
			
			%><label id="noCity">You must select a city!</label><%
		}%>
		
		<input id="continue" type="submit" name="Continue ivc2" value="Continue">
	</form>
</div>


<script>

	$(".city").click(function(e){
		$("#scrollbar").val(e.currentTarget.id.replace("_img","")).change();
	});

</script>


</body>
</html>