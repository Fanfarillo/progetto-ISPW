package logic.model;


import java.util.List;

public class Tourist extends User {

	private List<Restaurant> favouriteRestaurants = null; 
	
	public Tourist(String name, String surname, boolean notifications,String username, List<Restaurant> favourite) {
		super(name, surname, notifications, username);
		this.favouriteRestaurants = favourite;
	}

	public List<Restaurant> getFavouriteRestaurants() {
		return favouriteRestaurants;
	}

	public void setFavouriteRestaurants(List<Restaurant> favouriteRestaurants) {
		this.favouriteRestaurants = favouriteRestaurants;
	}

	
}
