<%@page import="logic.engineeringclasses.others.Session"%>
<%@page import="logic.engineeringclasses.dao.RestaurantDAO"%>
<%@page import="logic.engineeringclasses.dao.RecipeDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="logic.engineeringclasses.exceptions.InvalidDishDelete"%>
<%@page import="logic.engineeringclasses.bean.managerestaurant.BeanDeleteDish"%>
<%@page import="logic.engineeringclasses.exceptions.InvalidDishModify"%>
<%@page import="logic.engineeringclasses.exceptions.DishAlreadyExists"%>
<%@page import="logic.controller.applicationcontroller.ManageMenu"%>
<%@page import="logic.engineeringclasses.bean.managerestaurant.BeanDishWeb"%>
<%@page import="com.mysql.cj.Session.SessionEventListener"%>
<%@page import="logic.engineeringclasses.bean.managerestaurant.BeanDish"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    



<%

	Session s;
	s = (Session)session.getAttribute("session");
	
	if(request.getParameter("home3")!=null) {
		%>
		<jsp:forward page="HomePageOwner.jsp"></jsp:forward>
		<%
	}
%>

<%
	if(request.getParameter("manageMenu3")!=null) {
		%>
		<jsp:forward page="RestaurantMenuview.jsp"></jsp:forward>
		<%
	}
%>

<%
	if(request.getParameter("sponsorRestaurant3")!=null) {
		%>
		<jsp:forward page="CreatingRestaurantView.jsp"></jsp:forward>
		<%
	}
%>

<%
	if(request.getParameter("Discard")!=null) {
		//SizedStack.getSizedStack(true).push("RestaurantMenuview.jsp");
		%>
		<jsp:forward page="RestaurantMenuview.jsp"></jsp:forward>
		<%
	}
%>



<%
	if(request.getParameter("Done")!=null) {
		ManageMenu m = new ManageMenu();
		BeanDishWeb b = (BeanDishWeb)session.getAttribute("beanrefresh");
		System.out.print(b.getTipoModifica());
		if(b.getTipoModifica() == 0){
			BeanDish beanAddDish = new BeanDish(b.getPiatto(),b.getRistorante(),b.getContenuto(),b.isVegano(),b.isCeliaco(),b.getPrezzo(),0);
			
			try{
				m.addDish(beanAddDish);
			}catch(DishAlreadyExists e){
				//System.out.print("Gia esiste\n");
				RestaurantDAO restaurantDAO = new RestaurantDAO();		
				ArrayList<String> obs2 = (ArrayList<String>)restaurantDAO.selectOwnRestaurant(s.getUser().getUsername());
				//setto i ristoranti
				session.setAttribute("listaRistoranti", obs2);
				RecipeDAO recipeDAO = new RecipeDAO();
				ArrayList<String> obs1 = (ArrayList<String>)recipeDAO.selectOwnRecipe(s.getUser().getUsername()); //setto le ricette
				session.setAttribute("listaPiatti", obs1);
				session.setAttribute("errore", "S");
				session.setAttribute("session", s);
				%>
				<jsp:forward page="AddDishView.jsp"></jsp:forward>
				<%
				
			}
		}else if(b.getTipoModifica() == 1){
			BeanDish beanAddDish = new BeanDish(b.getPiatto(),b.getRistorante(),b.getContenuto(),b.isVegano(),b.isCeliaco(),b.getPrezzo(),1);
			System.out.println(b.getPiatto()+b.getContenuto()+b.getRistorante());
			try{
				m.modifyDishes(beanAddDish);
			}catch(InvalidDishModify e2){
				session.setAttribute("session", s);
				RecipeDAO recipeDAO = new RecipeDAO(); 
				ArrayList<String> obs1 = (ArrayList<String>)recipeDAO.selectOwnRecipe(s.getUser().getUsername());
				session.setAttribute("listaPiatti", obs1); //setto le ricette
				session.setAttribute("errore", "S");	//comunico l'errore
				RestaurantDAO restaurantDAO = new RestaurantDAO();		
				ArrayList<String> obs2 = (ArrayList<String>)restaurantDAO.selectOwnRestaurant(s.getUser().getUsername());
				session.setAttribute("listaRistoranti", obs2); //setto i ristoranti
				%>
				<jsp:forward page="ModifyDishView.jsp"></jsp:forward>
				<%
			}
		}else if(b.getTipoModifica() == 2){
			BeanDeleteDish beanDeleteDish = new BeanDeleteDish(b.getRistorante(),b.getPiatto(),2);
			
			try{
				m.deleteDish(beanDeleteDish);
			}catch(InvalidDishDelete e3){
				session.setAttribute("errore", "S");	//comunico l'errore
				RestaurantDAO restaurantDAO = new RestaurantDAO();		
				ArrayList<String> obs2 = (ArrayList<String>)restaurantDAO.selectOwnRestaurant(s.getUser().getUsername());
				session.setAttribute("listaRistoranti", obs2); //setto i ristoranti
				session.setAttribute("session", s);
				RecipeDAO recipeDAO = new RecipeDAO();
				ArrayList<String> obs1 = (ArrayList<String>)recipeDAO.selectOwnRecipe(s.getUser().getUsername()); //setto le ricette
				session.setAttribute("listaPiatti", obs1);
				%>
				<jsp:forward page="DeleteDishView.jsp"></jsp:forward>
				<%
			}
		}
		%>
		<jsp:forward page="RestaurantMenuview.jsp"></jsp:forward>
		<%
	}
%>

<%
	if(request.getParameter("keep")!=null) {	
		session.setAttribute("session", s);
		%>
		<jsp:forward page="RestaurantMenuview.jsp"></jsp:forward>
		<%		
	}
%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="ISO-8859-1">
	<title>Confirm action</title>
	<link rel="stylesheet" type="text/css" href="confirmMessage.css">
	
</head>

<body>

<div class="container">

	
	<form action="ConfirmMessage.jsp" name="myform" method="get">
	
		<input id="home" type="submit" name="home3" value="Home">
		<input id="manageMenu" type="submit" name="manageMenu3" value="Manage Menu">
		<input id="sponsorRestaurant" type="submit" name="sponsorRestaurant3" value="Sponsor Restaurant">
			
		<img id="fotoUtente" alt="fotoUtente" src="utente.jpg"/>
		
		<label id="nomeUtente" style="font-size:20px"><%out.print(s.getUser().getUsername()); %></label>
<%
session.setAttribute("beanrefresh", request.getAttribute("bean"));

%>
		<div id="informazioni">
			<p>What would you like to do?</p>
		</div>
		
		<div id="doneBut">
			<input id="Done" class="button" type="submit" name="Done" value="Done">
		</div>
		<div id="DiscardBut">
			<input id="Discard" class="button" type="submit" name="Discard" value="Discard All The Changes">
		</div>
		<div id="keepBut">
			<input id="keep" class="button" type="submit" name="keep" value="Keep Managing Menu">
		</div>
		
		
	</form>
</div>
</body>
</html>