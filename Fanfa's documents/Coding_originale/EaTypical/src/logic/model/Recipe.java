package logic.model;

public class Recipe {

	private String dishName;
	private Restaurant restaurant;
	private boolean isVegan;
	private boolean isCeliac;
	private double price;
	
	public Recipe(String dishName,Restaurant restaurant,boolean isVegan,boolean isCeliac,double price) {
		this.dishName = dishName;
		this.restaurant = restaurant;
		this.isCeliac = isCeliac;
		this.isVegan = isVegan;
		this.price = price;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public boolean isVegan() {
		return isVegan;
	}

	public void setVegan(boolean isVegan) {
		this.isVegan = isVegan;
	}

	public boolean isCeliac() {
		return isCeliac;
	}

	public void setCeliac(boolean isCeliac) {
		this.isCeliac = isCeliac;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
}
