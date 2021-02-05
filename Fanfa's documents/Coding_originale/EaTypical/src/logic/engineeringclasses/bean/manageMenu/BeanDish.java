package logic.engineeringclasses.bean.manageMenu;

public class BeanDish {
	
	private String dish;
	private String restaurant;
	private String content;
	private boolean forVegan;
	private boolean forCeliac;
	private double price;
	private int typeChange;
	
	public BeanDish(String dish, String restaurant,String content,boolean forVegan, boolean forCeliac, double price,int typeChange) {
		this.dish = dish;
		this.restaurant = restaurant;
		this.content = content;
		this.forVegan = forVegan;
		this.forCeliac = forCeliac;
		this.price = price;
		this.typeChange = typeChange;
		
	}

	public String getDish() {
		return dish;
	}

	public void setDish(String piatto) {
		this.dish = piatto;
	}

	public String getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isVegano() {
		return forVegan;
	}

	public void setVegano(boolean forVegan) {
		this.forVegan = forVegan;
	}

	public boolean isCeliac() {
		return forCeliac;
	}

	public void setCeliac(boolean forCeliac) {
		this.forCeliac = forCeliac;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getTypeChange() {
		return typeChange;
	}

	public void setTypeChange(int typeChange) {
		this.typeChange = typeChange;
	}
	
	

}
