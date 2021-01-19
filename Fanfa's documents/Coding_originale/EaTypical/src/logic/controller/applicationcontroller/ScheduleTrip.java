package logic.controller.applicationcontroller;

import java.util.ArrayList;
//import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import logic.engineeringclasses.bean.scheduletrip.BeanCheckedRestaurantSchedule;
import logic.engineeringclasses.bean.scheduletrip.BeanOutputRestaurant;
import logic.engineeringclasses.bean.scheduletrip.BeanOutputSchedule;
import logic.engineeringclasses.dao.FanfaAbstractDAO;
import logic.engineeringclasses.exceptions.NoResultException;
import logic.engineeringclasses.factory.Factory;
import logic.model.Restaurant;

public class ScheduleTrip {
	
	public BeanOutputSchedule[] generateScheduling(BeanCheckedRestaurantSchedule beanCRS) throws NoResultException, Exception {
		
		// Query of the restaurants that are in the selected city and satisfy tourist's eventual food requirements
		Factory f = Factory.getFactory();
		FanfaAbstractDAO dao = f.createRestaurantDAO();
		List<Restaurant> listOfRestaurants = dao.select1(beanCRS.getCity(), beanCRS.isVegan(), beanCRS.isCeliac());		// List of restaurants that satisfy the most important conditions given by the tourist.
		
		//if(listOfRestaurants.isEmpty()) {
		//	NoResultException e = new NoResultException("No restaurant has been found.");
		//	throw e;
		//}
		
		//SimpleDateFormat sdf = new SimpleDateFormat("EE");
		//String firstDayOfWeek = sdf.format(this.beanCRS.getDate1());
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(beanCRS.getDate1());
		int firstDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);		// Integer that indicates the first day of week of the trip
		
		int numDays=0;
		Date d;
		cal.setTime(beanCRS.getDate2());
		
		do {													// Computation of number of days of the trip
			cal.add(Calendar.DATE, -1);
			d=cal.getTime();
			numDays++;
		} while(beanCRS.getDate1().compareTo(d)<=0);
		
		int numMeals;											// Computation of number of meals of the trip
		if(beanCRS.isAtLunch1() && !beanCRS.isAtLunch2()) {
			numMeals=2*numDays;
		}
		else if(!beanCRS.isAtLunch1() && beanCRS.isAtLunch2()) {
			numMeals=2*numDays-2;
		}
		else {
			numMeals=2*numDays-1;
		}
		
		boolean[][] requiredMealsWeek = new boolean[7][2];		// Array that indicates which meals, form sunday to saturday, are required for the trip
		if(numMeals>=14) {										// Case 1: the trip is composed of more than 13 meals -> all the meals in a week are required.
			for(int i=0; i<7; i++) {
				for(int j=0; j<2; j++) {
					requiredMealsWeek[i][j]=true;
				}
			}
		}
		else {													// Case 2: the trip is composed of 13 meals or less.
			for(int i=0; i<7; i++) {
				for(int j=0; j<2; j++) {
					requiredMealsWeek[i][j]=false;
				}
			}
			for(int i=firstDayOfWeek; i<firstDayOfWeek+numDays; i++) {
				for(int j=0; j<2; j++) {
					if(!(i==firstDayOfWeek && j==0 && beanCRS.isAtLunch1()==false) && !(i==firstDayOfWeek+numDays-1 && j==1 && beanCRS.isAtLunch2()==true)) {		// Check if the first day comprehends lunch and if the last day comprehends dinner
						requiredMealsWeek[(i-1)%7][j]=true;
					}
				}
			}			
		}
		
		// Check if the extracted restaurants are open at least for one meal of the trip
		
		Iterator<Restaurant> iter = listOfRestaurants.iterator();
		boolean isOk;
		
		while(iter.hasNext()) {
			Restaurant r = iter.next();
			isOk=false;
			
			for(int i=0; i<7; i++) {
				for(int j=0; j<2; j++) {
					if(requiredMealsWeek[i][j]==true && r.getOpeningHours()[i][j]==true) {
						isOk=true;
						break;
					}
				}
				if(isOk==true) {
					break;
				}
			}
			if(isOk==false) {
				listOfRestaurants.remove(r);	// If an extracted restaurant is never open for the trip, remove it from the array-list.
			}
			
		}
		
		if(listOfRestaurants.isEmpty()) {
			NoResultException e = new NoResultException("No restaurant has been found.");
			throw e;
		}
		
		int numRestaurants = listOfRestaurants.size();
		List<Restaurant> validRestaurants;		// List of restaurants that actually can be part of the schedule.
		
		// Here, it is established which is the minimum threshold (mt) of number of restaurants that will be part of the schedule.
		// We assume that mt is equals to the minimum value between the number of restaurants in listOfRestaurants and the number of meals of the trip divided by 3.
		if(numRestaurants <= numMeals/3) {
			validRestaurants=listOfRestaurants;					// If mt == number of restaurants in listOfRestaurants, then any restaurant in listOfRestaurants actually can be part of the schedule.
		}
		
		else {													// If mt == number of meals of the trip divided by 3, then we will do a selection of restaurants in listOfRestaurants based on their budget and their average vote.
			validRestaurants = new ArrayList<Restaurant>();
			int mt = numMeals/3;
			iter = listOfRestaurants.iterator();
			
			while(iter.hasNext()) {
				Restaurant r = iter.next();
				if(r.getMenu().getTotalPrice() <= beanCRS.getBudget() && r.getAvgVote() >= (double)beanCRS.getQuality()) {
					validRestaurants.add(r);					// Restaurant which satisfy both requested budget and requested quality
					//listOfRestaurants.remove(r);
				}
			}
			listOfRestaurants.removeAll(validRestaurants);
			
			// If number of restaurants in validRestaurants is not lower than mt, then we are already satisfied for this array-list.
			// Else, we have to add some other restaurant in validRestaurants to reach the minimum threshold.
			if(validRestaurants.size() < mt) {
				int remainingRestaurants = mt-validRestaurants.size();
				iter = listOfRestaurants.iterator();
				List<Restaurant> temporaryList = new ArrayList<Restaurant>();
				
				while(iter.hasNext()) {
					Restaurant r = iter.next();
					if(r.getMenu().getTotalPrice() <= beanCRS.getBudget()) {
						temporaryList.add(r);					//Restaurant which is potentially valid for the scheduling (its budget but not its quality is compliant with tourist's request)
					}
				}
				listOfRestaurants.removeAll(temporaryList);
				
				// If minimum threshold is reached, then we will accept only a part of restaurant whose budget (but not quality) is compliant with tourist's request.
				// Else, we will accept all of these restaurants and we will look for restaurants whose quality (but not budget) is compliant with tourist's request.
				if(temporaryList.size() >= remainingRestaurants) {
					iter = temporaryList.iterator();
					List<Double> listOfVotes = new ArrayList<Double>();
					
					while(iter.hasNext()) {
						Restaurant r = iter.next();
						listOfVotes.add(r.getAvgVote());
					}
					Collections.reverse(listOfVotes);
					
					double minVote = listOfVotes.get(remainingRestaurants-1);		// Lower bound of the range of quality of valid restaurants					
					iter = temporaryList.iterator();
					
					while(iter.hasNext()) {
						Restaurant r = iter.next();
						if(r.getAvgVote() < minVote) {
							iter.remove();											// Invalid restaurant (it has a too low vote)
						}
						
						validRestaurants.addAll(temporaryList);						
					}
					
				}
				
				else {
					validRestaurants.addAll(temporaryList);
					remainingRestaurants = mt-validRestaurants.size();
					
					iter = listOfRestaurants.iterator();
					temporaryList.removeAll(temporaryList);							// Clear of temporaryList
					
					while(iter.hasNext()) {
						Restaurant r = iter.next();
						if(r.getAvgVote() >= (double)beanCRS.getQuality()) {
							temporaryList.add(r);									// Restaurant which is potentially valid for the scheduling (its quality but not its budget is compliant with tourist's request)
						}
					}
					listOfRestaurants.removeAll(temporaryList);
					
					// If minimum threshold is reached, then we will accept only a part of restaurant whose quality (but not budget) is compliant with tourist's request.
					// Else, we will accept all of these restaurants and we will look for restaurants whose quality and budget are NOT compliant with tourist's request.
					if(temporaryList.size() >= remainingRestaurants) {
						iter = temporaryList.iterator();
						List<Double> listOfPrices = new ArrayList<Double>();
						
						while(iter.hasNext()) {
							Restaurant r = iter.next();
							listOfPrices.add(r.getMenu().getTotalPrice());
						}
						Collections.sort(listOfPrices);
						
						double maxPrice = listOfPrices.get(remainingRestaurants-1);		// Upper bound of the budget of a meal in valid restaurants
						iter = temporaryList.iterator();
						
						while(iter.hasNext()) {
							Restaurant r = iter.next();
							if(r.getMenu().getTotalPrice() > maxPrice) {
								iter.remove();											// Invalid restaurant (it has too high prices)
							}
							
							validRestaurants.addAll(temporaryList);
						}
						
					}
					
					else {
						validRestaurants.addAll(temporaryList);
						remainingRestaurants = mt-validRestaurants.size();
						
						temporaryList.removeAll(temporaryList);							// Clear of temporaryList
						iter = listOfRestaurants.iterator();
						List<Double> listOfPrices = new ArrayList<Double>();
						
						while(iter.hasNext()) {
							Restaurant r = iter.next();
							listOfPrices.add(r.getMenu().getTotalPrice());
						}
						Collections.sort(listOfPrices);
						
						double maxPrice = listOfPrices.get(remainingRestaurants-1);		// Upper bound of the budget of a meal in valid restaurants
						iter = listOfRestaurants.iterator();
						
						while(iter.hasNext()) {
							Restaurant r = iter.next();
							if(r.getMenu().getTotalPrice() < maxPrice) {
								validRestaurants.add(r);								// Restaurants whose prices do not reach the established upper bound are added in validRestaurants.
							}							
							else if(r.getMenu().getTotalPrice() == maxPrice) {
								temporaryList.add(r);									// Now temporaryList contains restaurants whose budget is equal to maxPrice.
							}
							
						}
						
						// Now, we have to select restaurants whose prices are equal to the established upper bound and whose quality is equal or greater than a lower bound.
						// NB: Our goal is always to reach the minimum threshold of number of restaurants in validRestaurants array-list.
						remainingRestaurants = mt-validRestaurants.size();
						iter = temporaryList.iterator();
						List<Double> listOfVotes = new ArrayList<Double>();
						
						while(iter.hasNext()) {
							Restaurant r = iter.next();
							listOfVotes.add(r.getAvgVote());
						}
						Collections.reverse(listOfVotes);
						
						double minVote = listOfVotes.get(remainingRestaurants-1);		// Lower bound of the range of quality of valid restaurants
						iter = temporaryList.iterator();
						
						while(iter.hasNext()) {
							Restaurant r = iter.next();
							if(r.getAvgVote() >= minVote) {
								validRestaurants.add(r);								// Restaurant whose quality is equal or greater than lower bound.
							}
							
						}
						
					}
					
				}
				
			}
			
		}
		
		// Now, in validRestaurants we have the restaurants that can actually be part of trip scheduling.
		List<BeanOutputRestaurant> validBeanRestaurants = new ArrayList<BeanOutputRestaurant>();
		iter = validRestaurants.iterator();
		
		while(iter.hasNext()) {								// Conversion of valid restaurants in beans.
			Restaurant r = iter.next();
			BeanOutputRestaurant b = new BeanOutputRestaurant(r.getName(), r.getAddress(), r.getCity(), r.getMenu().getTotalPrice(), r.getAvgVote(), r.getOpeningHours());
			validBeanRestaurants.add(b);
		}
		Iterator<BeanOutputRestaurant> iter2;
		
		int dayOfWeek = firstDayOfWeek;
		Date date = beanCRS.getDate1();
		cal.setTime(date);
		boolean atLunch = beanCRS.isAtLunch1();
		BeanOutputSchedule[] scheduling = new BeanOutputSchedule[numMeals];				// Array that will contain the selected restaurant for each meal of the trip.
																						// Selection will be determined randomly between restaurants in validRestaurants which are open for that specific meal.
		for(int k=0; k<numMeals; k++) {
			int i,j;
			if(atLunch==true) j=0;
			else j=1;
			i=dayOfWeek-1;
			
			iter2=validBeanRestaurants.iterator();
			List<BeanOutputRestaurant> validRestForAMeal = new ArrayList<BeanOutputRestaurant>();		// Restaurants in validRestaurants which are open for a specific meal
			
			while(iter2.hasNext()) {
				BeanOutputRestaurant b = iter2.next();
				if(b.getOpeningHours()[i][j] == true) {
					validRestForAMeal.add(b);
				}
			}			
			BeanOutputSchedule beanSched = new BeanOutputSchedule(dayOfWeek, date, atLunch, validRestForAMeal);
			scheduling[k] = beanSched;
			
			if(atLunch) {
				atLunch=false;
			}
			else {
				atLunch=true;
				if(dayOfWeek!=6) {
					dayOfWeek = (dayOfWeek+1)%7;
				}
				else {
					dayOfWeek++;
				}
				cal.add(Calendar.DATE, 1);
				date=cal.getTime();
			}
			
		}
		
		return scheduling;
		
	}
	
}
