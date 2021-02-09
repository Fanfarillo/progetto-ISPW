<%@page import="logic.engineeringclasses.others.Session"%>
<%@page import="logic.engineeringclasses.bean.managerestaurant.BeanDishWeb"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    


<%	ArrayList<String> obs1;
	obs1=(ArrayList<String>) session.getAttribute("listaPiatti");
	ArrayList<String> obs2;
	obs2=(ArrayList<String>) session.getAttribute("listaRistoranti"); 
	String errore = "N";
	errore = (String)session.getAttribute("errore");
	Session s;
	s = (Session)session.getAttribute("session");%>
	

<%
	if(request.getParameter("home7")!=null) {
		%>
		<jsp:forward page="HomePageOwner.jsp"></jsp:forward>
		<%
	}
%>

<%
	if(request.getParameter("manageMenu7")!=null) {
		%>
		<jsp:forward page="RestaurantMenuview.jsp"></jsp:forward>
		<%
	}
%>

<%
	if(request.getParameter("sponsorRestaurant7")!=null) {
		%>
		<jsp:forward page="CreatingRestaurantView.jsp"></jsp:forward>
		<%
	}
%>

<%
	if(request.getParameter("delete2")!=null) {
		
		
		String ristorante = request.getParameter("ristorante");
		String piatto = request.getParameter("piatto");
		
		
		
		
		BeanDishWeb beanWebDish = new BeanDishWeb(piatto,ristorante,(String)request.getParameter("ricetta"),false,false,-1,2);
		request.setAttribute("bean", beanWebDish);
		
		%>
		<jsp:forward page="ConfirmMessage.jsp"></jsp:forward>
		<%
		
	}
%>


<!DOCTYPE html>
<html lang="en">
<head>

<link rel="stylesheet" type="text/css" href="StyleDeleteDish.css">
<meta charset="ISO-8859-1">
<title>Delete Dish</title>
</head>
<body>

	<div class="container">
		<form action="DeleteDishView.jsp" method="get">
		
			<input id="home" type="submit" name="home7" value="Home">
			<input id="manageMenu" type="submit" name="manageMenu7" value="Manage Menu">
			<input id="sponsorRestaurant" type="submit" name="sponsorRestaurant7" value="Sponsor Restaurant">
			
			
			
			<img id="fotoUtente" alt="image" src="utente.jpg"/>
			
			<label id="n" style="font-size:20px"><%out.print(s.getUser().getUsername()); %></label>
			
			
			
			<div id="informazioni">
				<p>Select the dish you would like to delete:</p>
			</div>
			
			<div id="containerSelect">
				<select id="select" name="piatto">
				<%

		
		String value1;
		for(String elem: obs1){
			%>
			<option><%=elem%></option>
			<%
}
		
%>
				</select>
			</div>	
			
			<div id="cont">
				<select id="select" name="ristorante">
				<%
		
			
			String value2;
			for(String elem: obs2){
				%>
				<option><%=elem%></option>
				<%
			}
			
		
%>
				</select>
			</div>	
			
			<label id="errore" style="color:red"><% if(errore.equals("S"))out.print("the inserted dish does not belong to the selected restaurant");%></label>
			
			<input id="delete" name="delete2" value="DELETE" type="submit">
			
			
			
			
			
		</form>
	</div>
</body>
</html>