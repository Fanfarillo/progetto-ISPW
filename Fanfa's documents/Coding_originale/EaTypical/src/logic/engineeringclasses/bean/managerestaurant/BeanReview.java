package logic.engineeringclasses.bean.managerestaurant;

public class BeanReview {
	private String tourist;
	private String restaurant;
	private String content;
	private String vote;
	
	public BeanReview(String tourist, String restaurant, String content, String vote) {
		this.vote = vote;
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

	public String getVote() {
		return vote;
	}

	public void setVote(String vote) {
		this.vote = vote;
	}
	
	
	
}
