<%@page import="logic.engineeringclasses.bean.managerestaurant.BeanAdvice"%>
<%@page import="logic.engineeringclasses.others.Session"%>
<%@page import="logic.engineeringclasses.bean.login.BeanUser" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    


<%
	Session s;
	s = (Session)session.getAttribute("session");
	BeanAdvice beanAdvice =  (BeanAdvice)session.getAttribute("beanAdvice");
	
	if(request.getParameter("home2")!=null) {
		session.setAttribute("session", s);
		%>
		<jsp:forward page="HomePageOwner.jsp"></jsp:forward>
		<%
	}
%>

<%
	if(request.getParameter("manageMenu2")!=null) {
		session.setAttribute("session", s);
		%>
		<jsp:forward page="RestaurantMenuview.jsp"></jsp:forward>
		<%
	}
%>

<%
	if(request.getParameter("sponsorRestaurant2")!=null) {
		session.setAttribute("session", s);
		%>
		<jsp:forward page="CreatingRestaurantView.jsp"></jsp:forward>
		<%
	}
%>

<%
	if(request.getParameter("continue2")!=null) {
		session.setAttribute("session", s);
		%>
		<jsp:forward page="RestaurantMenuview.jsp"></jsp:forward>
		<%
	}
%>




    
    
<!DOCTYPE html>
<html lang="en">
<head>

<link rel="stylesheet" type="text/css" href="styleAdviceView.css">
<meta charset="ISO-8859-1">
<title>Get Advice</title>
</head>
<body>

<div class="container">
		<form action="AdviceView.jsp" name="myform" method="get">
		
			<input id="home" type="submit" name="home2" value="Home">
			<input id="manageMenu" type="submit" name="manageMenu2" value="Manage Menu">
			<input id="sponsorRestaurant" type="submit" name="sponsorRestaurant2" value="Sponsor Restaurant">
			
			<img id="fotoUtente" alt="foto_utente" src="utente.jpg"/>
			<label id="nomeUtente" style="font-size:20px"><%out.print(s.getUser().getUsername()); %></label>  
			
			
			<div>
				<textarea id="area" rows="20" cols="80" readonly><%StringBuilder bld = new StringBuilder();
		        bld.append("Minimum prices:");
		        for(int i = 0; i < beanAdvice.getDishes().size();i++) {        	
		        	bld.append("\nDish " + i + ": " + beanAdvice.getDishes().get(i)+"\u0009Minimum price: "+beanAdvice.getPrices().get(i));
		        } 
		        out.print(bld);%></textarea>
			</div>
			
			
			<div>
				<input type="submit" id="continue" value="DONE" name="continue2">
			</div>
			
			
			
		</form>
	</div>
</body>
</html>