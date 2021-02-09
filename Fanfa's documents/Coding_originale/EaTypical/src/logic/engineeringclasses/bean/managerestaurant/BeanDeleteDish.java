package logic.engineeringclasses.bean.managerestaurant;


/**
 * 
 * @author Luca Capotombolo
 *
 */

public class BeanDeleteDish {
	
	private String restaurant;
	private String dish;
	private int typeModify;
	
	public BeanDeleteDish(String restaurant, String dish,int typeModify) {
		this.restaurant = restaurant;
		this.dish = dish;
		this.typeModify = typeModify;
	}

	public int getTypeModify() {
		return typeModify;
	}

	public void setTypeModify(int typeModify) {
		this.typeModify = typeModify;
	}

	public String getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
	}

	public String getDish() {
		return dish;
	}

	public void setDish(String dish) {
		this.dish = dish;
	}
	
	
	
}
