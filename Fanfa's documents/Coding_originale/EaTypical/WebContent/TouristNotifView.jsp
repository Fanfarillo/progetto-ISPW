<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="logic.engineeringclasses.others.Session" %>
<%@page import="logic.engineeringclasses.bean.BeanStringNotif" %>
<%@page import="logic.engineeringclasses.dao.NotificationsDAO" %>

<%
	Session bs = (Session)session.getAttribute("session");
	BeanStringNotif[] notifications = (BeanStringNotif[])session.getAttribute("notif");
	String errorString = "";
	
	if(notifications==null) {
		notifications = new BeanStringNotif[1];
		notifications[0] = new BeanStringNotif("There is no notification");
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
    	if(request.getParameter("Home TN")!=null) {
    		session.setAttribute("session", bs);
%>
			<jsp:forward page="HomePageTouristView.jsp"/>
<%
    	}
    	if(request.getParameter("Schedule Trip TN")!=null) {
    		session.setAttribute("session", bs);
%>
			<jsp:forward page="ItalianViewCity.jsp"/>
<%
    	}
    	if(request.getParameter("Choose Restaurant TN")!=null) {
    		session.setAttribute("session", bs);
%>
			<jsp:forward page="ItalianViewCity2.jsp"/>
<%
    	}
    	if(request.getParameter("Continue")!=null) {
    		try {
    			NotificationsDAO.deleteTouristNotification(bs.getUser().getUsername());
    			session.setAttribute("session", bs);
%>
    			<jsp:forward page="HomePageTouristView.jsp"/>
<%
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
	<title>Your notifications</title>
	<link rel="stylesheet" type="text/css" href="TouristNotifCSS.css">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<script src="js/jquery-3.5.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</head>

<body>
<div class="container">
	<form action="TouristNotifView.jsp" name="myform" method="get">
		<input id="home" type="submit" name="Home TN" value="Home">
		<input id="scheduleTrip" type="submit" name="Schedule Trip TN" value="Schedule Trip">
		<input id="chooseRestaurant" type="submit" name="Choose Restaurant TN" value="Choose Restaurant">
		<img id="fotoUtente" src="utente.jpg" alt="Photo"/>
		<label id="nomeUtente"><%=userString%></label>
		<label id="errorMsg"><%=errorString%></label>
		
		<div class="box">
			<table>
			<caption>Your notifications</caption>
				<tr>
					<th class="notifications" scope="col">Notifications</th>
				</tr>
<%
				for(int i=0; i<notifications.length; i++) {
%>
					<tr>
						<td class="notifications"><%=notifications[i].getStrNotif() %></td>
					</tr>
<%					
				}
%>								
			</table>
		</div>
		
		<input id="continue" type="submit" name="Continue" value="Continue">
	</form>
</div>
</body>
</html>