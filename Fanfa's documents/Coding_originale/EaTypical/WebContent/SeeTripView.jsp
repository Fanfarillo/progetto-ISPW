<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="logic.engineeringclasses.others.SizedStack" %>
<%@page import="logic.engineeringclasses.others.Session" %>
<%@page import="logic.engineeringclasses.bean.scheduletrip.BeanOutputSchedule" %>
<%@page import="logic.engineeringclasses.others.BeanConverter" %>
<%@page import="logic.engineeringclasses.bean.scheduletrip.ConvertedBeanSchedule" %>
<%@page import="logic.engineeringclasses.dao.SchedulingDAO" %>

<%
	Session bs = (Session)session.getAttribute("session");
	String city = (String)session.getAttribute("city");
	BeanOutputSchedule[] scheduling = (BeanOutputSchedule[])session.getAttribute("scheduling");
	String errorString = "";
	
	BeanConverter converter = new BeanConverter();
	ConvertedBeanSchedule[] convertedScheduling;
	if(scheduling!=null) {
		convertedScheduling = converter.convertDataType(scheduling, city);
	}
	else {
		convertedScheduling = converter.emptyScheduling();
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
    	if(request.getParameter("Home See")!=null) {
    		session.setAttribute("session", bs);
%>
			<jsp:forward page="HomePageTouristView.jsp"/>
<%
    	}
    	if(request.getParameter("Schedule Trip See")!=null) {
    		session.setAttribute("session", bs);
%>
			<jsp:forward page="ItalianViewCity.jsp"/>
<%
    	}
    	if(request.getParameter("Choose Restaurant See")!=null) {
    		session.setAttribute("session", bs);
%>
			<jsp:forward page="ItalianViewCity2.jsp"/>
<%
    	}
    	if(request.getParameter("Back See")!=null) {
    		session.setAttribute("session", bs);
%>
			<jsp:forward page="HomePageTouristView.jsp"/>
<%    		
    	}
    	if(request.getParameter("Delete Scheduling")!=null) {
    		try {
    			SchedulingDAO dao = new SchedulingDAO();
    			dao.delete(bs.getUser().getUsername());
    			session.setAttribute("session", bs);
    			session.setAttribute("city", city);
    			session.setAttribute("scheduling", null);
%
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
	<title>Your scheduling</title>
	<link rel="stylesheet" type="text/css" href="SeeTripCSS.css">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<script src="js/jquery-3.5.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</head>

<body>
<div class="container">
	<form action="SeeTripView.jsp" name="myform" method="get">
		<input id="home" type="submit" name="Home See" value="Home">
		<input id="scheduleTrip" type="submit" name="Schedule Trip See" value="Schedule Trip">
		<input id="chooseRestaurant" type="submit" name="Choose Restaurant See" value="Choose Restaurant">
		<input id="back" type="submit" name="Back See" value="Back">
		<img id="fotoUtente" src="utente.jpg" alt="Photo"/>
		<label id="nomeUtente"><%=userString%></label>
		<label id="citta"><%=city%></label>
		<label id="errorMsg"><%=errorString%></label>
		
		<div class="box">
			<table>
				<tr>
					<th class="date">Date</th>
					<th class="hour">Hour</th>
					<th class="restName">Restaurant</th>
					<th class="address">Address</th>
					<th class="avgPrice">Avg Price</th>
					<th class="avgVote">Avg Vote</th>
				</tr>
<%
				for(int i=0; i<convertedScheduling.length; i++) {
%>
					<tr>
						<td class="date"><%=convertedScheduling[i].getStrDate() %></td>
						<td class="hour"><%=convertedScheduling[i].getStrHour() %></td>
						<td class="restName"><%=convertedScheduling[i].getName() %></td>
						<td class="address"><%=convertedScheduling[i].getAddress() %></td>
						<td class="avgPrice"><%=convertedScheduling[i].getStrAvgPrice() %></td>
						<td class="avgVote"><%=convertedScheduling[i].getStrAvgVote() %></td>
					</tr>
<%					
				}
%>								
			</table>
		</div>
		
		<input id="deleteScheduling" type="submit" name="Delete Scheduling" value="Delete Scheduling">
	</form>
</div>
</body>
</html>