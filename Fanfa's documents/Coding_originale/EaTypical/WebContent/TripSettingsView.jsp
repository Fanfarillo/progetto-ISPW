<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="logic.engineeringclasses.others.SizedStack" %>
<%@page import="logic.engineeringclasses.others.Session" %>
<%@page import="logic.engineeringclasses.exceptions.EmptyFieldException" %>
<%@page import="logic.engineeringclasses.bean.scheduletrip.BeanSyntacticCheck" %>
<%@page import="logic.engineeringclasses.bean.scheduletrip.BeanRestaurantSchedule" %>
<%@page import="logic.controller.applicationcontroller.ScheduleTrip" %>
<%@page import="logic.engineeringclasses.bean.scheduletrip.BeanOutputSchedule" %>
<%@page import="logic.engineeringclasses.exceptions.InvalidDateException" %>
<%@page import="logic.engineeringclasses.exceptions.NoResultException" %>
<%@page import="java.text.ParseException" %>

<%
	Session bs = (Session)session.getAttribute("session");
	String city = (String)session.getAttribute("city");
	String errorString = "Budget and rating may not be satisfied if there are too few\nrestaurants that meet all the requirements.";
%>

<%    	
    	if(request.getParameter("Home ST2")!=null) {
    		session.setAttribute("session", bs);
%>
			<jsp:forward page="HomePageTouristView.jsp"/>
<%
    	}
    	if(request.getParameter("Schedule Trip ST2")!=null) {
    		session.setAttribute("session", bs);
%>
			<jsp:forward page="ItalianViewCity.jsp"/>
<%
    	}
    	if(request.getParameter("Choose Restaurant ST2")!=null) {
    		session.setAttribute("session", bs);
%>
			<jsp:forward page="ItalianViewCity2.jsp"/>
<%
    	}
    	if(request.getParameter("Back ST2")!=null) {
    		session.setAttribute("session", bs);
%>
			<jsp:forward page="ItalianViewCity.jsp"/>
<%    		
    	}
    	if(request.getParameter("Generate Scheduling")!=null) {
    		try {
    			String[] meal1 = new String[3];
    			meal1[0] = request.getParameter("FirstDay");
    			meal1[1] = request.getParameter("FirstMonth");
    			meal1[2] = request.getParameter("FirstYear");
    			
    			String[] meal2 = new String[3];
    			meal2[0] = request.getParameter("LastDay");
    			meal2[1] = request.getParameter("LastMonth");
    			meal2[2] = request.getParameter("LastYear");
    			
    			boolean[] foodRequirement = new boolean[2];
    			String veganString = request.getParameter("CheckboxVegan");
    			String celiacString = request.getParameter("CheckboxCeliac");
    			
    			if(veganString==null) foodRequirement[0]=false;
    			else foodRequirement[0]=true;
    			
    			if(celiacString==null) foodRequirement[1]=false;
    			else foodRequirement[1]=true;
    			
    			String radio1 = request.getParameter("radio1");
    			String radio2 = request.getParameter("radio2");    			
    			boolean atLunch1 = ("lunch1".equals(radio1));
    			boolean atLunch2 = ("lunch2".equals(radio2));
    			
    			String[] budgetAndQuality = new String[2];
    			budgetAndQuality[0] = request.getParameter("budget");
    			
    			if(request.getParameter("ScrollVoto")==null) budgetAndQuality[1] = null;
    			else budgetAndQuality[1] = request.getParameter("ScrollVoto");
    			
    			for(int i=0; i<3; i++) {
    				if(meal1[i]==null || meal2[i]==null) {
    					throw new EmptyFieldException("You need to specify both the first day of your trip and the last day of your trip.");
    				}
    			}
    			
    			BeanSyntacticCheck beanSyntCheck = new BeanSyntacticCheck();
    			BeanRestaurantSchedule beanRestSched = beanSyntCheck.syntacticCheck(meal1, atLunch1, meal2, atLunch2, foodRequirement, budgetAndQuality, city);
    			ScheduleTrip scheduleTrip = new ScheduleTrip();
    			BeanOutputSchedule[] scheduling = scheduleTrip.generateScheduling(beanRestSched);
    			
    			session.setAttribute("session", bs);
    			session.setAttribute("city", city);
    			session.setAttribute("trip", scheduling);
%>
				<jsp:forward page="SchedulingView.jsp"/>
<%
    		}
    		catch(EmptyFieldException e) {
    			errorString = "You need to specify both the first day of your trip and the last day of your trip.";
    		}
    		catch(NumberFormatException e) {
    			errorString = "Sorry, you entered an invalid budget.";
    		}
    		catch(InvalidDateException e) {
    			errorString = "Last meal cannot be before first meal; you cannot schedule trips which last more than 30 days;\nyou cannot schedule trips in the past.";
    		}    		
    		catch(ParseException e) {
    			errorString = "Sorry, you entered a nonexistent date.";
    		}
    		catch(NoResultException e) {
    			errorString = "No restaurant has been found.";
    		}
    		catch(Exception e) {
    			e.printStackTrace();
    			errorString = "An unknown error occurred. Please, try again later.";
    		}
    		
    	}
%>
    
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="ISO-8859-1">
	<title>Trip settings</title>
	<link rel="stylesheet" type="text/css" href="TripSettingsCSS.css">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<script src="js/jquery-3.5.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</head>

<body>
<div class="container">
	<form action="TripSettingsView.jsp" name="myform" method="get">
		<input id="home" type="submit" name="Home ST2" value="Home">
		<input id="scheduleTrip" type="submit" name="Schedule Trip ST2" value="Schedule Trip">
		<input id="chooseRestaurant" type="submit" name="Choose Restaurant ST2" value="Choose Restaurant">
		<input id="back" type="submit" name="Back ST2" value="Back">
		<img id="fotoUtente" src="utente.jpg" alt="Photo"/>
		<label id="nomeUtente">Not logged</label>
		<div class="box-1">
			<p>Choose the first day of your trip:</p>
			<select class="scrollGiorni" name="FirstDay">
				<option disabled selected>Day</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
				<option value="10">10</option>
				<option value="11">11</option>
				<option value="12">12</option>
				<option value="13">13</option>
				<option value="14">14</option>
				<option value="15">15</option>
				<option value="16">16</option>
				<option value="17">17</option>
				<option value="18">18</option>
				<option value="19">19</option>
				<option value="20">20</option>
				<option value="21">21</option>
				<option value="22">22</option>
				<option value="23">23</option>
				<option value="24">24</option>
				<option value="25">25</option>
				<option value="26">26</option>
				<option value="27">27</option>
				<option value="28">28</option>
				<option value="29">29</option>
				<option value="30">30</option>
				<option value="31">31</option>
			</select>
			<select class="scrollMesi" name="FirstMonth">
				<option disabled selected>Month</option>
				<option value="January">January</option>
				<option value="February">February</option>
				<option value="March">March</option>
				<option value="April">April</option>
				<option value="May">May</option>
				<option value="June">June</option>
				<option value="July">July</option>
				<option value="August">August</option>
				<option value="September">September</option>
				<option value="October">October</option>
				<option value="November">November</option>
				<option value="December">December</option>				
			</select>
			<select class="scrollAnni" name="FirstYear">
				<option disabled selected>Year</option>
				<option value="2021">2021</option>
				<option value="2022">2022</option>
				<option value="2023">2023</option>
				<option value="2024">2024</option>
				<option value="2025">2025</option>
				<option value="2026">2026</option>
				<option value="2027">2027</option>
				<option value="2028">2028</option>
				<option value="2029">2029</option>
				<option value="2030">2030</option>
			</select>
			<input id="lunch1" class="lunch" type="radio" name="radio1" value="lunch1" checked>
			<label class="lunchLabel" for="lunch1">Lunch</label>
			<input id="dinner1" class="dinner" type="radio" name="radio1" value="dinner1">
			<label class="dinnerLabel" for="dinner1">Dinner</label>
		</div>
		<div class="box-2">
			<p>Choose the last day of your trip:</p>
			<select class="scrollGiorni" name="LastDay">
				<option disabled selected>Day</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
				<option value="10">10</option>
				<option value="11">11</option>
				<option value="12">12</option>
				<option value="13">13</option>
				<option value="14">14</option>
				<option value="15">15</option>
				<option value="16">16</option>
				<option value="17">17</option>
				<option value="18">18</option>
				<option value="19">19</option>
				<option value="20">20</option>
				<option value="21">21</option>
				<option value="22">22</option>
				<option value="23">23</option>
				<option value="24">24</option>
				<option value="25">25</option>
				<option value="26">26</option>
				<option value="27">27</option>
				<option value="28">28</option>
				<option value="29">29</option>
				<option value="30">30</option>
				<option value="31">31</option>
			</select>
			<select class="scrollMesi" name="LastMonth">
				<option disabled selected>Month</option>
				<option value="January">January</option>
				<option value="February">February</option>
				<option value="March">March</option>
				<option value="April">April</option>
				<option value="May">May</option>
				<option value="June">June</option>
				<option value="July">July</option>
				<option value="August">August</option>
				<option value="September">September</option>
				<option value="October">October</option>
				<option value="November">November</option>
				<option value="December">December</option>		
			</select>
			<select class="scrollAnni" name="LastYear">
				<option disabled selected>Year</option>
				<option value="2021">2021</option>
				<option value="2022">2022</option>
				<option value="2023">2023</option>
				<option value="2024">2024</option>
				<option value="2025">2025</option>
				<option value="2026">2026</option>
				<option value="2027">2027</option>
				<option value="2028">2028</option>
				<option value="2029">2029</option>
				<option value="2030">2030</option>
			</select>
			<input id="lunch2" class="lunch" type="radio" name="radio2" value="lunch2" checked>
			<label class="lunchLabel" for="lunch2">Lunch</label>
			<input id="dinner2" class="dinner" type="radio" name="radio2" value="dinner2">
			<label class="dinnerLabel" for="dinner2">Dinner</label>
		</div>
		<input id="checkboxVegan" type="checkbox" name="CheckboxVegan">
		<label id="labelVegan" for="checkboxVegan">I am vegan</label>
		<input id="checkboxCeliac" type="checkbox" name="CheckboxCeliac">
		<label id="labelCeliac" for="checkboxCeliac">I have celiac disease</label>
		<img id="euro" src="euro.png" alt="eur"/>
		<input id="budget" type="text" placeholder="Select your budget" name="budget">
		<label id="labelVoto">Select the minimum rating of restaurants</label>
		<select id="scrollVoto" name="ScrollVoto">
			<option disabled selected>Vote</option>
			<option value="1 star">1 star</option>
			<option value="2 stars">2 stars</option>
			<option value="3 stars">3 stars</option>
			<option value="4 stars">4 stars</option>
			<option value="5 stars">5 stars</option>
		</select>
		<label id="errorMsg"><%=errorString%></label>
		<input id="generate" type="submit" name="Generate Scheduling" value="Generate Scheduling">
	</form>
</div>
</body>
</html>