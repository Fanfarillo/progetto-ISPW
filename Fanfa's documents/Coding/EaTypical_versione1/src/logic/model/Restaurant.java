package logic.model;

import java.util.ArrayList;

public class Restaurant {
	
	private Owner owner;
	private String city;
	private Menu menu;
	private String address;
	private String name;
	private ArrayList<Review> reviews = null;
	private ArrayList<User> clients = null;
	
	public Restaurant(Owner owner, String city, Menu menu, String address, String name, ArrayList<Review> reviews, ArrayList<User> clients) {
		this.owner = owner;
		this.city = city;
		this.menu = menu;
		this.address =address;
		this.name = name;
		this.reviews = reviews;
		this.clients = clients;
		
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Review> getReviews() {
		return reviews;
	}

	public void setReviews(ArrayList<Review> reviews) {
		this.reviews = reviews;
	}

	public ArrayList<User> getClients() {
		return clients;
	}

	public void setClients(ArrayList<User> clients) {
		this.clients = clients;
	}
	
	
	
}
