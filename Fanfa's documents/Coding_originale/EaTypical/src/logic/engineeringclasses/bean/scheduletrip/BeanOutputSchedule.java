package logic.engineeringclasses.bean.scheduletrip;

import java.util.Date;
import java.util.List;

public class BeanOutputSchedule {

	private int dayOfWeek;
	private Date date;
	private boolean atLunch;
	private List<BeanOutputRestaurant> listOfBeans;
	private BeanOutputRestaurant rest;
	
	public BeanOutputSchedule(int dayOfWeek, Date date, boolean atLunch, List<BeanOutputRestaurant> listOfBeans) {
		this.dayOfWeek=dayOfWeek;
		this.date=date;
		this.atLunch=atLunch;
		this.listOfBeans=listOfBeans;
		// Missing rest with random() function
	}

	/**
	 * @return the dayOfWeek
	 */
	public int getDayOfWeek() {
		return dayOfWeek;
	}

	/**
	 * @param dayOfWeek the dayOfWeek to set
	 */
	public void setDayOfWeek(int dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the atLunch
	 */
	public boolean isAtLunch() {
		return atLunch;
	}

	/**
	 * @param atLunch the atLunch to set
	 */
	public void setAtLunch(boolean atLunch) {
		this.atLunch = atLunch;
	}

	/**
	 * @return the rest
	 */
	public BeanOutputRestaurant getRest() {
		return rest;
	}

	/**
	 * @param rest the rest to set
	 */
	public void setRest(BeanOutputRestaurant rest) {
		this.rest = rest;
	}
	
}
