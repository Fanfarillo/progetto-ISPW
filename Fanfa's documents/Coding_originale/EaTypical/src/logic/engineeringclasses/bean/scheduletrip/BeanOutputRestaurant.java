package logic.engineeringclasses.bean.scheduletrip;

import logic.engineeringclasses.bean.AbstractBeanRestaurant;

public class BeanOutputRestaurant extends AbstractBeanRestaurant {

	private double avgPrice;
	private double avgVote;
	
	public BeanOutputRestaurant(String usernameOwner, String name, String address, String city, double avgPrice, double avgVote, boolean[][] openingHours) {
		super(name, address, city, usernameOwner);
		this.avgPrice=avgPrice;
		this.avgVote=avgVote;
		this.openingHours=openingHours;
	}

	/**
	 * @return the avgPrice
	 */
	public double getAvgPrice() {
		return avgPrice;
	}

	/**
	 * @param avgPrice the avgPrice to set
	 */
	public void setAvgPrice(double avgPrice) {
		this.avgPrice = avgPrice;
	}

	/**
	 * @return the avgVote
	 */
	public double getAvgVote() {
		return avgVote;
	}

	/**
	 * @param avgVote the avgVote to set
	 */
	public void setAvgVote(double avgVote) {
		this.avgVote = avgVote;
	}
	
}
