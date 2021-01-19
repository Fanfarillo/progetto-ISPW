package logic.engineeringclasses.bean.scheduletrip;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import logic.engineeringclasses.exceptions.InvalidDateException;

public class BeanRestaurantSchedule {

	private String day1;
	private String month1;
	private String year1;
	private boolean atLunch1;
	private String day2;
	private String month2;
	private String year2;
	private boolean atLunch2;
	private String city;
	private boolean vegan;
	private boolean celiac;
	private String budget;
	private String quality;
	
	public BeanRestaurantSchedule(String firstDay, String firstMonth, String firstYear, boolean atLunch1, String lastDay, String lastMonth, String lastYear, boolean atLunch2, String city, boolean vegan, boolean celiac, String strBudget, String strQuality) {
		this.day1=firstDay;
		this.month1=firstMonth;
		this.year1=firstYear;
		this.atLunch1=atLunch1;
		this.day2=lastDay;
		this.month2=lastMonth;
		this.year2=lastYear;
		this.atLunch2=atLunch2;
		this.city=city;
		this.vegan=vegan;
		this.celiac=celiac;
		this.budget=strBudget;
		this.quality=strQuality;
	}
	
	public BeanCheckedRestaurantSchedule syntacticCheck() throws NumberFormatException, ParseException, InvalidDateException {
		
		double doubleBudget;
		int intQuality;
		
		if(this.budget.equals("")) {
			doubleBudget = Double.POSITIVE_INFINITY;
		}
		else {
			doubleBudget = Double.parseDouble(this.budget);
		}
		
		if(this.quality==null) {
			intQuality=1;
		}
		else {
			intQuality = Integer.parseInt(this.quality);
		}
		
		String strDate1 = this.month1 + " " + this.day1 + ", " + this.year1;
		String strDate2 = this.month2 + " " + this.day2 + ", " + this.year2;
		
		DateFormat df = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
		df.setLenient(false);
		
		Date date1 = df.parse(strDate1);
		Date date2 = df.parse(strDate2);
		Calendar cal = Calendar.getInstance();
		
		cal.setTime(date1);
		if(this.atLunch1) cal.add(Calendar.HOUR_OF_DAY, 15);
		else cal.add(Calendar.HOUR_OF_DAY, 22);
		date1 = cal.getTime();
		
		cal.setTime(date2);
		if(this.atLunch2) cal.add(Calendar.HOUR_OF_DAY, 15);
		else cal.add(Calendar.HOUR_OF_DAY, 22);
		date2 = cal.getTime();
		
		if(date2.compareTo(date1)<0) {
			InvalidDateException e1 = new InvalidDateException("Last meal cannot be before first meal.");
			throw e1;
		}	
		
		Date d;		
		cal.setTime(date2);
		cal.add(Calendar.DATE, -30);
		d=cal.getTime();
		if(date1.compareTo(d)<0) {
			InvalidDateException e2 = new InvalidDateException("You cannot schedule trips which last more than 30 days.");
			throw e2;
		}
		
		Date today = GregorianCalendar.getInstance().getTime();
		if(date1.compareTo(today)<0) {
			InvalidDateException e3 = new InvalidDateException("You cannot schedule trips in the past.");
			throw e3;
		}
		
		BeanCheckedRestaurantSchedule beanCheckedRestSched = new BeanCheckedRestaurantSchedule(date1, this.atLunch1, date2, this.atLunch2, this.city, this.vegan, this.celiac, doubleBudget, intQuality);
		return beanCheckedRestSched;
		
	}

	/**
	 * @return the day1
	 */
	public String getDay1() {
		return day1;
	}

	/**
	 * @param day1 the day1 to set
	 */
	public void setDay1(String day1) {
		this.day1 = day1;
	}

	/**
	 * @return the month1
	 */
	public String getMonth1() {
		return month1;
	}

	/**
	 * @param month1 the month1 to set
	 */
	public void setMonth1(String month1) {
		this.month1 = month1;
	}

	/**
	 * @return the year1
	 */
	public String getYear1() {
		return year1;
	}

	/**
	 * @param year1 the year1 to set
	 */
	public void setYear1(String year1) {
		this.year1 = year1;
	}

	/**
	 * @return the atLunch1
	 */
	public boolean isAtLunch1() {
		return atLunch1;
	}

	/**
	 * @param atLunch1 the atLunch1 to set
	 */
	public void setAtLunch1(boolean atLunch1) {
		this.atLunch1 = atLunch1;
	}

	/**
	 * @return the day2
	 */
	public String getDay2() {
		return day2;
	}

	/**
	 * @param day2 the day2 to set
	 */
	public void setDay2(String day2) {
		this.day2 = day2;
	}

	/**
	 * @return the month2
	 */
	public String getMonth2() {
		return month2;
	}

	/**
	 * @param month2 the month2 to set
	 */
	public void setMonth2(String month2) {
		this.month2 = month2;
	}

	/**
	 * @return the year2
	 */
	public String getYear2() {
		return year2;
	}

	/**
	 * @param year2 the year2 to set
	 */
	public void setYear2(String year2) {
		this.year2 = year2;
	}

	/**
	 * @return the atLunch2
	 */
	public boolean isAtLunch2() {
		return atLunch2;
	}

	/**
	 * @param atLunch2 the atLunch2 to set
	 */
	public void setAtLunch2(boolean atLunch2) {
		this.atLunch2 = atLunch2;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the vegan
	 */
	public boolean isVegan() {
		return vegan;
	}

	/**
	 * @param vegan the vegan to set
	 */
	public void setVegan(boolean vegan) {
		this.vegan = vegan;
	}

	/**
	 * @return the celiac
	 */
	public boolean isCeliac() {
		return celiac;
	}

	/**
	 * @param celiac the celiac to set
	 */
	public void setCeliac(boolean celiac) {
		this.celiac = celiac;
	}

	/**
	 * @return the budget
	 */
	public String getBudget() {
		return budget;
	}

	/**
	 * @param budget the budget to set
	 */
	public void setBudget(String budget) {
		this.budget = budget;
	}

	/**
	 * @return the quality
	 */
	public String getQuality() {
		return quality;
	}

	/**
	 * @param quality the quality to set
	 */
	public void setQuality(String quality) {
		this.quality = quality;
	}
	
}
