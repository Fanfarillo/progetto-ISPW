<%@page import="logic.engineeringclasses.others.Session"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="logic.engineeringclasses.exceptions.DishAlreadyExists"%>
<%@page import="logic.engineeringclasses.bean.managerestaurant.BeanDishWeb"%>
<%@page import="com.mysql.cj.Session.SessionEventListener"%>
<%@page import="logic.engineeringclasses.bean.managerestaurant.BeanDish"%>


<%	ArrayList<String> obs1;
	obs1=(ArrayList<String>) session.getAttribute("listaPiatti");
	ArrayList<String> obs2;
	Session s;
	s = (Session)session.getAttribute("session");
	obs2=(ArrayList<String>) session.getAttribute("listaRistoranti"); 
	String errore = "N";
	errore = (String)session.getAttribute("errore");%>
	
<%
	if(request.getParameter("home4")!=null) {
		%>
		<jsp:forward page="HomePageOwner.jsp"></jsp:forward>
		<%
	}
%>

<%
	if(request.getParameter("manageMenu4")!=null) {
		%>
		<jsp:forward page="RestaurantMenuview.jsp"></jsp:forward>
		<%
	}
%>

<%
	if(request.getParameter("sponsorRestaurant4")!=null) {
		%>
		<jsp:forward page="CreatingRestaurantView.jsp"></jsp:forward>
		<%
	}
%>

<%
	boolean refresh = false;
	if(request.getParameter("continue4")!=null) {
		boolean ricettaNonInserita = false;
		//int count=0;
		boolean prezzoNonInserito = false;
		if(request.getParameter("continue4")!=null) {
			//mi porto appresso le informazioni per l'inserimento del piatto
			
			/*-----------------------------------------------*/
			String stringVegano = request.getParameter("c1");
			String stringCeliaco = request.getParameter("c2");
			String ristorante = request.getParameter("ristorante");
			String piatto = request.getParameter("piatto");
			boolean perVegano;
			boolean perCeliaco;
			if(stringVegano ==null){
				perVegano=false;
			}else{
				perVegano=true;
			}
			if(stringCeliaco ==null){
				perCeliaco=false;
			}else{
				perCeliaco=true;
			}
			if(request.getParameter("priceInput").equals("")){
				//se ÃÂÃÂÃÂÃÂ¨ la stringa vuota significa che non ho inserito il prezzo
				prezzoNonInserito = true;
			}else{
				//setto a stringa vuota
			}
			if(request.getParameter("ricetta").equals("")){
				// se la stringa vuota allora non ha inserito nessuna ricetta
				ricettaNonInserita = true;
			}
			
			
			if(ricettaNonInserita==false && prezzoNonInserito ==false){
				BeanDishWeb beanWebDish = new BeanDishWeb(piatto,ristorante,(String)request.getParameter("ricetta"),perVegano,perCeliaco,Double.parseDouble(request.getParameter("priceInput")),1);
				request.setAttribute("bean", beanWebDish);
			%>
			<jsp:forward page="ConfirmMessage.jsp"></jsp:forward>
			<%
			}
		refresh=true;
		}
	}
%>

    
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" type="text/css" href="StyleModifyDish.css">
<meta charset="ISO-8859-1">
<title>Modify Dish</title>
</head>
<body>
	<div class="container">
		<form action="ModifyDishView.jsp" name="myform" method="get">
		
			<input id="home" type="submit" name="home4" value="Home">
			<input id="manageMenu" type="submit" name="manageMenu4" value="Manage Menu">
			<input id="sponsorRestaurant" type="submit" name="sponsorRestaurant4" value="Sponsor Restaurant">
			
			<img id="fotoUtente" alt="fotoUtente" src="utente.jpg"/>
			<label id="nomeUtente" style="font-size:20px" ><%out.print(s.getUser().getUsername()); %></label>  
			
			
			
			<div id="informazioni">
				<p>Please, select the dish you would like to modify:</p>							
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
			
			<div id="contR">
				<select id="sel" name="ristorante">
				<%
		
			
			String value2;
			for(String elem:obs2){
				%>
				<option><%=elem%></option>
				<%
			}
%>
				</select>
			</div>
			
			<div id="price">
				<input type="text" id="priceInput" name="priceInput" >
			</div>
			
			<div>
				<textarea id = "area" rows="15" cols="76" name="ricetta" placeholder="Scrivi la nuova ricetta..."></textarea>	
			</div>
			
			<div id="check">
				<input type="checkbox"  id="c1" name="c1" value="Vegan" >
  				<label for="c1" id="l1"> Vegan</label><br>
  				<input type="checkbox" id="c2" name="c2" value="Celiac">
  				<label for="c2" id="l2"> Celiac</label><br>			
			</div>
			
			<div>
				<input type="submit" id="continue" value="CONTINUE" name="continue4">
			</div>
			
			<label id="campovuoto"><%if(refresh){
										out.print("Mancante");
									}
									if(refresh!=true && errore.equals("S")){
										out.print("Il piatto da modificare non appartiene al ristorante selezionato.");
									}
									%></label>
			}
			<label id="prezzovuoto"><%if(refresh) out.print("Mancante"); %></label>
			<label id="piattomancante"><%if(refresh) out.print("Mancante"); %></label>
			<label id="ristorantemancante"><%if(refresh) out.print("Mancante"); %></label>
			
		</form>
		
	</div>
</body>
</html>