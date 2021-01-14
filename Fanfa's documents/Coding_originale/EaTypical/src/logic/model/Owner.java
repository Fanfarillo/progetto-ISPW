package logic.model;


import java.util.List;

public class Owner extends User{

	private List<Restaurant> ownRestaurant = null;
	
	public Owner(String name, String surname, boolean notifications, List<Restaurant> restaurants, String username) {
		super(name, surname, notifications, username);
		this.ownRestaurant = restaurants;
	}

	public List<Restaurant> getOwnRestaurant() {
		return ownRestaurant;
	}

	public void setOwnRestaurant(List<Restaurant> ownRestaurant) {
		this.ownRestaurant = ownRestaurant;
	}
	
	

}
