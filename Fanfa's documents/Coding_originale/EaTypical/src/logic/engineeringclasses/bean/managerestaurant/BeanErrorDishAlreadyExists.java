package logic.engineeringclasses.bean.managerestaurant;

public class BeanErrorDishAlreadyExists {

	private String dish;
	
	public BeanErrorDishAlreadyExists(String dish) {
		this.dish = dish;
	}

	public String getMess() {
		return "Il piatto ** "+dish+" ** già è stato inserito";
	}

	
	
}
