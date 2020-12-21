package logic.model;

public class Review {
	
	private String text;
	private Tourist tourist;
	private int vote;
	
	public Review(String text,Tourist tourist,int vote) {
		this.vote = vote;
		this.text = text;
		this.tourist = tourist;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Tourist getTourist() {
		return tourist;
	}

	public void setTourist(Tourist tourist) {
		this.tourist = tourist;
	}

	public int getVote() {
		return vote;
	}

	public void setVote(int vote) {
		this.vote = vote;
	}
	
	
}
