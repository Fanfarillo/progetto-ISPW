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
	
	public void generateScheduling(BeanCheckedRestaurantSchedule beanCRS) throws NoResultException, Exception {
		// Maybe this method has to return an array of bean
		
		Factory f = Factory.getFactory();
		FanfaAbstractDAO dao = f.createRestaurantDAO();
		List<Restaurant> listOfRestaurants = dao.select1(beanCRS.getCity(), beanCRS.isVegan(), beanCRS.isCeliac());
		
		//if(listOfRestaurants.isEmpty()) {
		//	NoResultException e = new NoResultException("No restaurant has been found.");
		//	throw e;
		//}
		
		//SimpleDateFormat sdf = new SimpleDateFormat("EE");
		//String firstDayOfWeek = sdf.format(this.beanCRS.getDate1());
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(beanCRS.getDate1());
		int firstDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		
		int numDays=0;
		Date d;
		cal.setTime(beanCRS.getDate2());
		
		do {
			cal.add(Calendar.DATE, -1);
			d=cal.getTime();
			numDays++;
		} while(beanCRS.getDate1().compareTo(d)<=0);
		
		int numMeals;
		if(beanCRS.isAtLunch1() && !beanCRS.isAtLunch2()) {
			numMeals=2*numDays;
		}
		else if(!beanCRS.isAtLunch1() && beanCRS.isAtLunch2()) {
			numMeals=2*numDays-2;
		}
		else {
			numMeals=2*numDays-1;
		}
		
		// To check:
		
		boolean[][] requiredMealsWeek = new boolean[7][2];
		if(numMeals>=14) {
			for(int i=0; i<7; i++) {
				for(int j=0; j<2; j++) {
					requiredMealsWeek[i][j]=true;
				}
			}
		}
		else {
			for(int i=0; i<7; i++) {
				for(int j=0; j<2; j++) {
					requiredMealsWeek[i][j]=false;
				}
			}
			for(int i=firstDayOfWeek; i<firstDayOfWeek+numDays; i++) {
				for(int j=0; j<2; j++) {
					if(!(i==firstDayOfWeek && j==0 && beanCRS.isAtLunch1()==false) && !(i==firstDayOfWeek+numDays-1 && j==1 && beanCRS.isAtLunch2()==true)) {
						requiredMealsWeek[(i-1)%7][j]=true;
					}
				}
			}			
		}
		
		Iterator<Restaurant> iter = listOfRestaurants.iterator();
		//List<Restaurant> validRestaurants = new ArrayList<Restaurant>();
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
				listOfRestaurants.remove(r);
			}
			
		}
		
		if(listOfRestaurants.isEmpty()) {
			NoResultException e = new NoResultException("No restaurant has been found.");
			throw e;
		}
		
		int numRestaurants = listOfRestaurants.size();
		List<Restaurant> validRestaurants;
		
		if(numRestaurants <= numMeals/3) {
			validRestaurants=listOfRestaurants;
		}
		
		else {
			validRestaurants = new ArrayList<Restaurant>();
			int mt = numMeals/3;								// Minimum threshold of restaurants in the scheduling
			iter = listOfRestaurants.iterator();
			
			while(iter.hasNext()) {
				Restaurant r = iter.next();
				if(r.getMenu().getTotalPrice() <= beanCRS.getBudget() && r.getAvgVote() >= (double)beanCRS.getQuality()) {
					validRestaurants.add(r);					// Restaurant which satisfy also requested budget and requested quality
					//listOfRestaurants.remove(r);
				}
			}
			listOfRestaurants.removeAll(validRestaurants);
			
			if(validRestaurants.size() < mt) {
				int remainingRestaurants = mt-validRestaurants.size();
				iter = listOfRestaurants.iterator();
				List<Restaurant> temporaryList = new ArrayList<Restaurant>();
				
				while(iter.hasNext()) {
					Restaurant r = iter.next();
					if(r.getMenu().getTotalPrice() <= beanCRS.getBudget()) {
						temporaryList.add(r);						
					}
				}
				listOfRestaurants.removeAll(temporaryList);
																			// temporaryList.size() = number of restaurants which are potentially valid for the scheduling (their budget but not their quality is compliant with tourist's request)
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
							iter.remove();						// Invalid restaurant
						}
						
						validRestaurants.addAll(temporaryList);						
					}
					
				}
				
				else {
					validRestaurants.addAll(temporaryList);
					remainingRestaurants = mt-validRestaurants.size();
					
					iter = listOfRestaurants.iterator();
					temporaryList.removeAll(temporaryList);		// Clear of temporaryList
					
					while(iter.hasNext()) {
						Restaurant r = iter.next();
						if(r.getAvgVote() >= (double)beanCRS.getQuality()) {
							temporaryList.add(r);
						}
					}
					listOfRestaurants.removeAll(temporaryList);
																				// temporaryList.size() = number of restaurants which are potentially valid for the scheduling (their quality but not their budget is compliant with tourist's request)
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
								iter.remove();											// Invalid restaurant
							}
							
							validRestaurants.addAll(temporaryList);
						}
						
					}
					
					else {
						validRestaurants.addAll(temporaryList);
						remainingRestaurants = mt-validRestaurants.size();
						
						temporaryList.removeAll(temporaryList);		// Clear of temporaryList
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
								validRestaurants.add(r);
							}							
							else if(r.getMenu().getTotalPrice() == maxPrice) {
								temporaryList.add(r);				// Now temporaryList contains restaurants whose budget is equal to maxPrice.
							}
							
						}
						
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
								validRestaurants.add(r);
							}
							
						}
						
					}
					
				}
				
			}
			
		}
		
		// Now, in validRestaurants, we have the restaurants that can actually be part of trip scheduling.
		List<BeanOutputRestaurant> validBeanRestaurants = new ArrayList<BeanOutputRestaurant>();
		iter = validRestaurants.iterator();
		
		while(iter.hasNext()) {
			Restaurant r = iter.next();
			BeanOutputRestaurant b = new BeanOutputRestaurant(r.getName(), r.getAddress(), r.getCity(), r.getMenu().getTotalPrice(), r.getAvgVote(), r.getOpeningHours());
			validBeanRestaurants.add(b);
		}
		
		int dayOfWeek = firstDayOfWeek;
		Date date = beanCRS.getDate1();
		BeanOutputSchedule[] sched = new BeanOutputSchedule[numMeals];
		
	}
	
}
