package logic.engineeringclasses.bean.managerestaurant;

public class BeanReview {
	private String tourist;
	private String restaurant;
	private String content;
	private String voto;
	
	public BeanReview(String tourist, String restaurant, String content, String voto) {
		this.voto = voto;
		this.content = content;
		this.restaurant = restaurant;
		this.tourist = tourist;
	}

	public String getTourist() {
		return tourist;
	}

	public void setTourist(String tourist) {
		this.tourist = tourist;
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

	public String getVoto() {
		return voto;
	}

	public void setVoto(String voto) {
		this.voto = voto;
	}
	
	
	
}
