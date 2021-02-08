package test;

import org.junit.Test;
import static org.junit.Assert.*;

import logic.controller.applicationcontroller.ScheduleTrip;
import logic.engineeringclasses.bean.scheduletrip.BeanRestaurantSchedule;
import logic.model.Restaurant;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/**
 * 
 * @author Matteo Fanfarillo
 *
 */

public class TestScheduleTrip {

	@Test
	public void testGetNumMeals() throws ParseException {
		boolean[] arrayAtLunch = new boolean[2];
		arrayAtLunch[0] = false;
		arrayAtLunch[1] = true;
		
		String strDate1 = "March 1, 2021";
		String strDate2 = "March 10, 2021";
		DateFormat df = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
		df.setLenient(false);
		
		Date[] arrayDate = new Date[2];
		arrayDate[0] = df.parse(strDate1);
		arrayDate[1] = df.parse(strDate2);
		Calendar cal = Calendar.getInstance();
		
		cal.setTime(arrayDate[0]);
		cal.add(Calendar.HOUR_OF_DAY, 22);
		arrayDate[0] = cal.getTime();
		
		cal.setTime(arrayDate[1]);
		cal.add(Calendar.HOUR_OF_DAY, 15);
		arrayDate[1] = cal.getTime();
		
		boolean[] foodRequirement = new boolean[2];
		foodRequirement[0] = true;
		foodRequirement[1] = false;
		
		String city = "Torino";
		double budget = 30.0;
		int quality = 2;
		
		BeanRestaurantSchedule beanRS = new BeanRestaurantSchedule(arrayDate, arrayAtLunch, city, foodRequirement, budget, quality);
		ScheduleTrip scheduleTrip = new ScheduleTrip();
		
		int output = scheduleTrip.getNumMeals(beanRS, 9);
		assertEquals(18, output);
		
	}
	
	@Test
	public void testCheckOpeningHours() {
		String city = "Milano";
		List<Restaurant> list = new ArrayList<>();
		
		String name1 = "Uno";
		String address1 = "AddressUno";
		double avgVote1 = 4.1;		
		Restaurant rest1 = new Restaurant(name1, address1, city, avgVote1);
		
		String name2 = "Due";
		String address2 = "Address2";
		double avgVote2 = 3.7;
		Restaurant rest2 = new Restaurant(name2, address2, city, avgVote2);
		
		String name3 = "Tre";
		String address3 = "AddressTre";
		double avgVote3 = 4.5;
		Restaurant rest3 = new Restaurant(name3, address3, city, avgVote3);
		
		String name4 = "Quattro";
		String address4 = "AddressQuattro";
		double avgVote4 = 4.0;
		Restaurant rest4 = new Restaurant(name4, address4, city, avgVote4);
		
		String name5 = "Cinque";
		String address5 = "AddressCinque";
		double avgVote5 = 3.6;
		Restaurant rest5 = new Restaurant(name5, address5, city, avgVote5);
		
		boolean[][] opHours1 = getOpHours1();
		rest1.setOpeningHours(opHours1);
		list.add(rest1);
		
		boolean[][] opHours2 = getOpHours2();
		rest2.setOpeningHours(opHours2);
		list.add(rest2);
		
		boolean[][] opHours3 = getOpHours3();
		rest3.setOpeningHours(opHours3);
		list.add(rest3);
		
		boolean[][] opHours4 = getOpHours4();
		rest4.setOpeningHours(opHours4);
		list.add(rest4);
		
		boolean[][] opHours5 = getOpHours5();
		rest5.setOpeningHours(opHours5);
		list.add(rest5);
		
		boolean[][] requiredMealsWeek = getRequiredMealsWeek();
		
		ScheduleTrip scheduleTrip = new ScheduleTrip();
		List<Restaurant> outputList = scheduleTrip.checkOpeningHours(list, requiredMealsWeek);
			
		Iterator<Restaurant> iter = outputList.iterator();
		
		boolean isOk;			// For each restaurant in outputList, isOk becomes true if the restaurant is open at least once in the portion of the week indicated by the array requiredMealsWeek.
		int okCount=0;			// Number of restaurants in outputList whose opening hours are compliant with the portion of week indicated by the array requiredMealsWeek.
		
		while(iter.hasNext()) {
			Restaurant r = iter.next();
			isOk=false;
			
			for(int i=0; i<3; i++) {
				for(int j=0; j<2; j++) {
					if(r.getOpeningHours()[i][j]) isOk=true;
				}
			}			
			if(isOk) okCount++;			
		}
		
		assertEquals(4, okCount);
		
	}
	
	private boolean[][] getOpHours1() {
		boolean[][] opHours1 = new boolean[7][2];
		for(int i=0; i<7; i++) {
			for(int j=0; j<2; j++) {
				opHours1[i][j] = true;
			}
		}
		return opHours1;
	}
	
	private boolean[][] getOpHours2() {
		boolean[][] opHours2 = new boolean[7][2];
		for(int i=0; i<7; i++) {
			opHours2[i][0] = true;
			opHours2[i][1] = false;
		}
		return opHours2;
	}
	
	private boolean[][] getOpHours3() {
		boolean[][] opHours3 = new boolean[7][2];
		for(int i=3; i<7; i++) {
			for(int j=0; j<2; j++) {
				opHours3[i][j] = true;
			}
		}
		for(int i=0; i<3; i++) {
			for(int j=0; j<2; j++) {
				opHours3[i][j] = false;
			}
		}
		return opHours3;
	}
	
	private boolean[][] getOpHours4() {
		boolean[][] opHours4 = new boolean[7][2];
		for(int i=0; i<5; i++) {
			for(int j=0; j<2; j++) {
				opHours4[i][j] = true;
			}
		}
		for(int i=5; i<7; i++) {
			for(int j=0; j<2; j++) {
				opHours4[i][j] = false;
			}
		}
		return opHours4;
	}
	
	private boolean[][] getOpHours5() {
		boolean[][] opHours5 = new boolean[7][2];
		for(int i=3; i<7; i++) {
			opHours5[i][0] = false;
			opHours5[i][1] = true;
		}
		for(int i=0; i<3; i++) {
			opHours5[i][0] = true;
			opHours5[i][1] = false;
		}
		return opHours5;
	}
	
	private boolean[][] getRequiredMealsWeek() {
		boolean[][] requiredMealsWeek = new boolean[7][2];
		for(int i=0; i<3; i++) {
			for(int j=0; j<2; j++) {
				requiredMealsWeek[i][j] = true;
			}
		}
		for(int i=3; i<7; i++) {
			for(int j=0; j<2; j++) {
				requiredMealsWeek[i][j] = false;
			}
		}
		return requiredMealsWeek;
	}
	
	@Test
	public void testDeleteRestaurantsWithTooLowVote() {
		String city = "Venezia";
		List<Restaurant> list = new ArrayList<>();
		
		String name1 = "Sei";
		String address1 = "AddressSei";
		double avgVote1 = 3.7;
		list.add(new Restaurant(name1, address1, city, avgVote1));
		
		String name2 = "Sette";
		String address2 = "AddressSette";
		double avgVote2 = 4.2;
		list.add(new Restaurant(name2, address2, city, avgVote2));
		
		String name3 = "Otto";
		String address3 = "AddressOtto";
		double avgVote3 = 3.0;
		list.add(new Restaurant(name3, address3, city, avgVote3));
		
		String name4 = "Nove";
		String address4 = "AddressNove";
		double avgVote4 = 2.8;
		list.add(new Restaurant(name4, address4, city, avgVote4));
		
		String name5 = "Dieci";
		String address5 = "AddressDieci";
		double avgVote5 = 3.3;
		list.add(new Restaurant(name5, address5, city, avgVote5));
		
		ScheduleTrip scheduleTrip = new ScheduleTrip();
		List<Restaurant> outputList = scheduleTrip.deleteRestaurantsWithTooLowVote(list, 3.3);
		
		Iterator<Restaurant> iter = outputList.iterator();
		
		int okCount=0;		// Number of restaurants in outputList whose average vote is equal or greater than 3.3
		
		while(iter.hasNext()) {
			Restaurant r = iter.next();
			if(r.getAvgVote() >= 3.3) okCount++;			
		}
		
		assertEquals(3, okCount);
		
	}
	
}
