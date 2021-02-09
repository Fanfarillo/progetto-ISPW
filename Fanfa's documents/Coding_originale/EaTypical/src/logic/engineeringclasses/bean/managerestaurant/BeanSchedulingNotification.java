package logic.engineeringclasses.bean.managerestaurant;

/**
 * 
 * @author Luca Capotombolo
 *
 */
public class BeanSchedulingNotification {
	private String username;
	private String restaurant;
	private String data;
	private String pranzoVsCena;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRistorante() {
		return restaurant;
	}

	public void setRistorante(String restaurant) {
		this.restaurant = restaurant;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String isPranzoVsCena() {
		return pranzoVsCena;
	}

	public void setPranzoVsCena(String pranzoVsCena) {
		this.pranzoVsCena=pranzoVsCena;
	}
	
	
}



