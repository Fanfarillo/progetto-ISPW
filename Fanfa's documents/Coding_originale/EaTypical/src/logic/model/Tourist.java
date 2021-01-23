package logic.model;


import java.util.List;

public class Tourist extends User {

	private List<Restaurant> favouriteRestaurants = null; 
	private List<TouristNotification> notifications;
	
	public Tourist(String name, String surname,String username, List<Restaurant> favourite, List<TouristNotification> notifications) {
		super(name, surname, username);
		this.favouriteRestaurants = favourite;
		this.notifications=notifications;
	}

	public List<TouristNotification> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<TouristNotification> notifications) {
		this.notifications = notifications;
	}

	public List<Restaurant> getFavouriteRestaurants() {
		return favouriteRestaurants;
	}

	public void setFavouriteRestaurants(List<Restaurant> favouriteRestaurants) {
		this.favouriteRestaurants = favouriteRestaurants;
	}

	
}
