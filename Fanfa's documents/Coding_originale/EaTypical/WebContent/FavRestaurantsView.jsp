<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="logic.engineeringclasses.others.Session" %>
<%@page import="logic.engineeringclasses.bean.BeanFavRestaurant" %>
<%@page import="logic.engineeringclasses.dao.FavouriteRestDAO" %>

<%
	Session bs = (Session)session.getAttribute("session");
	BeanFavRestaurant[] favRest = (BeanFavRestaurant[])session.getAttribute("favRest");
	String errorString = "";
	
	if(favRest==null) {
		favRest = new BeanFavRestaurant[1];
		favRest[0] = new BeanFavRestaurant("There is no restaurant", "", "", "");
	}
	
	String userString;
	if(bs.getUser()!=null) {
		userString = bs.getUser().getUsername();
	}
	else {
		userString = "Not logged";
	}
%>

<%    	
    	if(request.getParameter("Home Fav")!=null) {
    		session.setAttribute("session", bs);
%>
			<jsp:forward page="HomePageTouristView.jsp"/>
<%
    	}
    	if(request.getParameter("Schedule Trip Fav")!=null) {
    		session.setAttribute("session", bs);
%>
			<jsp:forward page="ItalianViewCity.jsp"/>
<%
    	}
    	if(request.getParameter("Choose Restaurant Fav")!=null) {
    		session.setAttribute("session", bs);
%>
			<jsp:forward page="ItalianViewCity2.jsp"/>
<%
    	}
    	if(request.getParameter("Delete All")!=null) {
    		try {
    			FavouriteRestDAO.delete(bs.getUser().getUsername());
    			session.setAttribute("session", bs);
    			session.setAttribute("favRest", null);
    		}
    		catch(Exception e) {
    			errorString="An unknown error occurred. Please, try again later.";
    		}
    	}
%>
    
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="ISO-8859-1">
	<title>Your favorite restaurants</title>
	<link rel="stylesheet" type="text/css" href="FavRestaurantsCSS.css">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<script src="js/jquery-3.5.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</head>

<body>
<div class="container">
	<form action="FavRestaurantsView.jsp" name="myform" method="get">
		<input id="home" type="submit" name="Home Fav" value="Home">
		<input id="scheduleTrip" type="submit" name="Schedule Trip Fav" value="Schedule Trip">
		<input id="chooseRestaurant" type="submit" name="Choose Restaurant Fav" value="Choose Restaurant">
		<img id="fotoUtente" src="utente.jpg" alt="Photo"/>
		<label id="nomeUtente"><%=userString%></label>
		<label id="errorMsg"><%=errorString%></label>
		
		<div class="box">
			<table>
			<caption>Your favorite restaurants</caption>
				<tr>
					<th class="city" scope="col">City</th>
					<th class="restName" scope="col">Restaurant</th>
					<th class="address" scope="col">Address</th>
					<th class="avgVote" scope="col">Avg Vote</th>
				</tr>
<%
				for(int i=0; i<favRest.length; i++) {
%>
					<tr>
						<td class="city"><%=favRest[i].getCity() %></td>
						<td class="restName"><%=favRest[i].getName() %></td>
						<td class="address"><%=favRest[i].getAddress() %></td>
						<td class="avgVote"><%=favRest[i].getStrAvgVote() %></td>
					</tr>
<%					
				}
%>								
			</table>
		</div>
		
		<input id="deleteAll" type="submit" name="Delete All" value="Delete All">
	</form>
</div>
</body>
</html>