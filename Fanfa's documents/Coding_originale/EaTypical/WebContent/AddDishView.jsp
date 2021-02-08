<%@page import="logic.engineeringclasses.others.Session"%>
<%@page import="logic.engineeringclasses.bean.managerestaurant.BeanDishWeb"%>
<%@page import="java.util.ArrayList"%>
<%@page import="logic.engineeringclasses.bean.managerestaurant.BeanDish"%>
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
	
	if(request.getParameter("home1")!=null) {
		//SizedStack.getSizedStack(true).clearStack();
		%>
		<jsp:forward page="HomePageOwner.jsp"></jsp:forward>
		<%
	}
%>

<%
	if(request.getParameter("manageMenu1")!=null) {
		//SizedStack.getSizedStack(true).push("RestaurantMenuview.jsp");
		//mi porto a spasso l'utente e le altre informazioni sulla sessione
		%>
		<jsp:forward page="RestaurantMenuview.jsp"></jsp:forward>
		<%
	}
%>

<%
	if(request.getParameter("sponsorRestaurant1")!=null) {
		//SizedStack.getSizedStack(true).push("CreatingRestaurantView.jsp");
		//mi porto a spasso l'utente e le altre informazioni sulla sessione
		%>
		<jsp:forward page="CreatingRestaurantView.jsp"></jsp:forward>
		<%
	}
%>

<%
	boolean refresh = false;
	
	if(request.getParameter("continue1")!=null) {
		boolean ricettaVuota = false;
		//int count=0;
		boolean prezzoVuoto = false;
		//SizedStack.getSizedStack(true).push("ConfirmMessage.jsp");
		//mi porto appresso le informazioni per l'inserimento del piatto
		
		/*-----------------------------------------------*/
		String veganoString = request.getParameter("c1");
		String celiacoString = request.getParameter("c2");
		String ristorante = request.getParameter("ristorante");
		String piatto = request.getParameter("piatto");
		boolean vegano;
		boolean celiaco;
		if(veganoString ==null){
			vegano=false;
		}else{
			vegano=true;
		}
		if(celiacoString ==null){
			celiaco=false;
		}else{
			celiaco=true;
		}
		if(request.getParameter("prezzo").equals("")){
			//se ÃÂÃÂÃÂÃÂ¨ la stringa vuota significa che non ho inserito il prezzo
			prezzoVuoto = true;
		}else{
			//setto a stringa vuota
		}
		if(request.getParameter("ricetta").equals("")){
			// se la stringa vuota allora non ha inserito nessuna ricetta
			ricettaVuota = true;
		}
		
		
		if(ricettaVuota==false && prezzoVuoto ==false){
			BeanDishWeb beanWebDish = new BeanDishWeb(piatto,ristorante,(String)request.getParameter("ricetta"),vegano,celiaco,Double.parseDouble(request.getParameter("prezzo")),0);
			request.setAttribute("bean", beanWebDish);
		%>
		<jsp:forward page="ConfirmMessage.jsp"></jsp:forward>
		<%
		
		}
		
		refresh = true;
	}
%>



<!-- INIZIO CODICE HTML -->

<!DOCTYPE html>

<html lang="en">
<head>

<link rel="stylesheet" type="text/css" href="StyleAddDish.css">
<meta charset="ISO-8859-1">
<title>Add Dish</title>
</head>
<body>
	
	<div class="container">
		<form action="AddDishView.jsp" name="myform" method="get">
		
			<input id="home" type="submit" name="home1" value="Home">
			<input id="manageMenu" type="submit" name="manageMenu1" value="Manage Menu">
			<input id="sponsorRestaurant" type="submit" name="sponsorRestaurant1" value="Sponsor Restaurant">
			
			<img id="fotoUtente" alt="fotoUtente" src="utente.jpg"/>
			<label id="nomeUtente" style="font-size:20px"><%out.print(s.getUser().getUsername()); %></label>  
			
			
			
			<div id="informazioni">
				<p>Please, select the dish you would add into menu:</p>							
			</div>
			
			<div id="containerSelect">
				<select id="select" name="piatto">
<%
		
		
		
		
			 //session.setAttribute("listaPiattiR",obs1); 
		
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
				<select id="sel" name="ristorante">
				
<%
					
						
		
			//ArrayList<String> obs2 = (ArrayList<String>)request.getAttribute("listaRistoranti");
			String value2;
			for(String elem : obs2){
				%>
				<option><%=elem%></option>
				<%
			}
			
			
		
%>
				</select>				
			</div>
	
			
			<label id="campovuoto"><%if(refresh){
										out.print("Mancante");
									}
									if(refresh==false && errore.equals("S")){
										out.print("Il piatto da modificare giÃ  appartiene al ristorante selezionato.");
									}
									%></label>
			<label id="prezzovuoto"><%if(refresh) out.print("Mancante"); %></label>
			<label id="piattomancante"><%if(refresh) out.print("Mancante"); %></label>
			<label id="ristorantemancante"><%if(refresh) out.print("Mancante"); %></label>
			
			<div id="price">
				<input type="text" id="priceInput" name="prezzo" value="">
			</div>
			
			<div id="check">
				<input type="checkbox"  id="c1" name="c1" value="Vegan" >
  				<label for="c1" id="l1"> Vegan</label><br>
  				<input type="checkbox" id="c2" name="c2" value="Celiac">
  				<label for="c2" id="l2"> Celiac</label><br>			
			</div>
			
			<div>
				<textarea id = "area" rows="15" cols="76" name="ricetta" placeholder="Scrivi ricetta..."></textarea>
			</div>
			
			<div>
				<input type="submit" id="continue" value="OK" name="continue1">
			</div>
			
			
			
		</form>
	</div>
	
</body>
</html>