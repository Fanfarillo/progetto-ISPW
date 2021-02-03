package logic.engineeringclasses.bean.scheduletrip;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import logic.engineeringclasses.exceptions.InvalidDateException;

public class BeanSyntacticCheck {

	public BeanRestaurantSchedule syntacticCheck(String[] meal1, boolean atLunch1, String[] meal2, boolean atLunch2, boolean[] foodRequirement, String[] budgetAndQuality, String city) throws NumberFormatException, ParseException, InvalidDateException {		
		double doubleBudget;
		int intQuality;
		
		if(budgetAndQuality[0].equals("")) {
			doubleBudget = Double.POSITIVE_INFINITY;
		}
		else {
			doubleBudget = Double.parseDouble(budgetAndQuality[0]);
		}
		
		if(budgetAndQuality[1]==null) {
			intQuality=1;
		}
		else {
			String onlyNumQuality = "" + budgetAndQuality[1].charAt(0);
			intQuality = Integer.parseInt(onlyNumQuality);
		}

		String strDate1 = meal1[1] + " " + meal1[0] + ", " + meal1[2];
		String strDate2 = meal2[1] + " " + meal2[0] + ", " + meal2[2];
		
		DateFormat df = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
		df.setLenient(false);
		
		Date[] dateArray = new Date[2];
		dateArray[0] = df.parse(strDate1);
		dateArray[1] = df.parse(strDate2);
		Calendar cal = Calendar.getInstance();
		
		cal.setTime(dateArray[0]);
		if(atLunch1) cal.add(Calendar.HOUR_OF_DAY, 15);
		else cal.add(Calendar.HOUR_OF_DAY, 22);
		dateArray[0] = cal.getTime();
		
		cal.setTime(dateArray[1]);
		if(atLunch2) cal.add(Calendar.HOUR_OF_DAY, 15);
		else cal.add(Calendar.HOUR_OF_DAY, 22);
		dateArray[1] = cal.getTime();
		
		if(dateArray[1].compareTo(dateArray[0])<0) {
			throw new InvalidDateException("Last meal cannot be before first meal.");
		}	
		
		Date d;		
		cal.setTime(dateArray[1]);
		cal.add(Calendar.DATE, -30);
		d=cal.getTime();
		if(dateArray[0].compareTo(d)<0) {
			throw new InvalidDateException("You cannot schedule trips which last more than 30 days.");
		}
		
		Date today = Calendar.getInstance().getTime();
		if(dateArray[0].compareTo(today)<0) {
			throw new InvalidDateException("You cannot schedule trips in the past.");
		}
		
		boolean[] atLunchArray = new boolean[2];
		atLunchArray[0]=atLunch1;
		atLunchArray[1]=atLunch2;
		
		return new BeanRestaurantSchedule(dateArray, atLunchArray, city, foodRequirement, doubleBudget, intQuality);	
		
	}
	
}
