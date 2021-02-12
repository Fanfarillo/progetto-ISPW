package logic.engineeringclasses.bean.login;

import java.util.List;

import logic.model.Restaurant;
import logic.model.Scheduling;
import logic.model.TouristNotification;

public class BeanLoggedUser {
	private String username;
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private List<Restaurant> favouriteRestaurants = null; 
	private List<TouristNotification> notifications;
	private List<Scheduling> trip;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<Restaurant> getFavouriteRestaurants() {
		return favouriteRestaurants;
	}
	public void setFavouriteRestaurants(List<Restaurant> favouriteRestaurants) {
		this.favouriteRestaurants = favouriteRestaurants;
	}
	public List<TouristNotification> getNotifications() {
		return notifications;
	}
	public void setNotifications(List<TouristNotification> notifications) {
		this.notifications = notifications;
	}
	public List<Scheduling> getTrip() {
		return trip;
	}
	public void setTrip(List<Scheduling> trip) {
		this.trip = trip;
	}

}
