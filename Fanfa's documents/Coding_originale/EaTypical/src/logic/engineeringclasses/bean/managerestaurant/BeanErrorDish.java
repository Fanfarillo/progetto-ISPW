package logic.engineeringclasses.bean.managerestaurant;

public class BeanErrorDish {
	
	private String dish;
	private String ristorante;
	
	public BeanErrorDish(String dish,String restaurant) {
		this.dish = dish;
		this.restaurant = restaurant;
	}
	
	public String getMess() {
		return "the selected dish ** "+dish+" ** is not in the restaurant selected ** " + restaurant + " **";
	}
}
