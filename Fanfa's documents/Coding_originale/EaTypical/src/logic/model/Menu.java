package logic.model;

import java.util.List;


public class Menu {

	private Restaurant restaurant;
	private List<Recipe> dishes;
	
	public Menu(List<Recipe> dishes) {
		this.dishes =dishes;
	}

	public List<Recipe> getDishes() {
		return dishes;
	}

	public void setDishes(List<Recipe> dishes) {
		this.dishes = dishes;
	}
	
	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	
	
}
