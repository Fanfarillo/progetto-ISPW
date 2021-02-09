package logic.engineeringclasses.bean.managerestaurant;

public class BeanDishWeb {

	private String dish;
	private String restaurant;
	private String recipe;
	private boolean vegan;
	private boolean celiac;
	private double price;
	private int typeModify; //0 -> aggiungo piatto		1 -> modifico piatto 		2 -> elimino piatto
	
	public BeanDishWeb(String dish, String restaurant,String recipe,boolean vegan, boolean celiac, double price,int typeModify) {
		this.dish = dish;
		this.restaurant= restaurant;
		this.recipe = recipe;
		this.vegan = vegan;
		this.celiac = celiac;
		this.price = price;
		this.typeModify = typeModify;
		
	}
	
	public String getDish() {
		return dish;
	}

	public void setDish(String dish) {
		this.dish= dish;
	}

	public String getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
	}

	public String getRecipe() {
		return recipe;
	}

	public void setRecipe(String recipe) {
		this.recipe = recipe;
	}

	public boolean isVegan() {
		return vegan;
	}

	public void setVegan(boolean vegan) {
		this.vegan = vegan;
	}

	public boolean isCeliac() {
		return celiac;
	}

	public void setCeliac(boolean celiac) {
		this.celiac = celiac;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getTypeModify() {
		return typeModify;
	}

	public void setTypeModify(int typeModify) {
		this.typeModify = typeModify;
	}
}
