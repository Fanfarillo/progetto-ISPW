package logic.engineeringclasses.bean.sponsorrestaurant;

import logic.engineeringclasses.bean.AbstractBeanRestaurant;

public class BeanNewRestaurant extends AbstractBeanRestaurant {

	public BeanNewRestaurant(String name, String address, String city, String usernameOwner) {
		super(name, address, city, usernameOwner);
		this.openingHours=null;
	}
	
}