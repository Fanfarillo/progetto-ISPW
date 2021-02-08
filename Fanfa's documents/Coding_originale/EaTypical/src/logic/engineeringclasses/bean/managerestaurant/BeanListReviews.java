package logic.engineeringclasses.bean.managemenu;

import java.util.ArrayList;
import java.util.List;

public class BeanListReviews {

	List<String> tourists;
	List<String> restaurants;
	List<String> contents;
	List<String> votes;
	
	public BeanListReviews() {
		tourists = new ArrayList<>();
		restaurants = new ArrayList<>();
		contents = new ArrayList<>();
		votes = new ArrayList<>();
	}

	public List<String> getTourists() {
		return tourists;
	}

	public void setTourists(List<String> tourists) {
		this.tourists = tourists;
	}

	public List<String> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(List<String> restaurants) {
		this.restaurants = restaurants;
	}

	public List<String> getContents() {
		return contents;
	}

	public void setContents(List<String> contents) {
		this.contents = contents;
	}

	public List<String> getVotes() {
		return votes;
	}

	public void setVotes(List<String> votes) {
		this.votes = votes;
	}
	
	
	
}
