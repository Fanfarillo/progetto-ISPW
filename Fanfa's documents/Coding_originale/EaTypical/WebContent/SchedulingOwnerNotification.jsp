<%@page import="logic.engineeringclasses.bean.managerestaurant.BeanListNotificationsScheduling"%>
<%@page import="logic.engineeringclasses.bean.managerestaurant.BeanListReviews"%>
<%@page import="logic.engineeringclasses.bean.managerestaurant.BeanReview"%>
<%@page import="logic.engineeringclasses.others.Session" %>
<%@page import="logic.engineeringclasses.bean.login.BeanUser" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
	Session s;
	s = (Session)session.getAttribute("session");
%>

    <%
	if(request.getParameter("home11")!=null) {
		%>
		<jsp:forward page="HomePageOwner.jsp"></jsp:forward>
		<%
	}
%>
 <%
	if(request.getParameter("continue11")!=null) {
		%>
		<jsp:forward page="HomePageOwner.jsp"></jsp:forward>
		<%
	}
%>

<%
	if(request.getParameter("manageMenu11")!=null) {
		%>
		<jsp:forward page="RestaurantMenuview.jsp"></jsp:forward>
		<%
	}
%>

<%
	if(request.getParameter("sponsorRestaurant11")!=null) {
		%>
		<jsp:forward page="CreatingRestaurantView.jsp"></jsp:forward>
		<%
	}
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Scheduling Notifications</title>
</head>

<link rel="stylesheet" type="text/css" href="SchedulingOwnerNotificationsStyle.css">
<body>

<div class="container">
		<form action="SchedulingOwnerNotification.jsp" method="get">
		
			<input id="home" type="submit" name="home11" value="Home">
			<input id="manageMenu" type="submit" name="manageMenu11" value="Manage Menu">
			<input id="sponsorRestaurant" type="submit" name="sponsorRestaurant11" value="Sponsor Restaurant">
			
			
			
			<img id="fotoUtente" alt="image" src="utente.jpg"/>
			
			<label id="n"><%out.print(s.getUser().getUsername()); %></label>
			
<%BeanListNotificationsScheduling beanListNotificationsScheduling = (BeanListNotificationsScheduling)session.getAttribute("beanScheduling"); %>
			
			
			<table >
				<caption></caption>
				<tr>
					<th id="thturista">Tourist</th>
					<th id="thristorante">Restaurant</th>
					<th id="thdata">Data</th>
					<th id="thgiornata">Lunch or Dinner</th>
				</tr>
<%
			BeanReview beanReview;
			for(int i = 0; i<beanListNotificationsScheduling.getNotifications().size();i++) {
				        	

				%>
				<tr>
					<th id="riga4"><%=beanListNotificationsScheduling.getNotifications().get(i).getUsername() %></th>
					<th id="riga3"><%=beanListNotificationsScheduling.getNotifications().get(i).getRistorante() %></th>
					<th id="riga2"><%=beanListNotificationsScheduling.getNotifications().get(i).getData() %></th>
					<th id="riga1"><%=beanListNotificationsScheduling.getNotifications().get(i).isPranzoVsCena() %></th>
					
				</tr>
				<%
			}
%>
				
			</table>
			
			
		

			
			<input id="continue" name="continue11" value="CONTINUE" type="submit">
			
			
			
			
			
		</form>
	</div>
</body>
</html>