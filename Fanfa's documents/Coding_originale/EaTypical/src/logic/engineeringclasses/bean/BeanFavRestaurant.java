package logic.engineeringclasses.bean;

public class BeanFavRestaurant extends AbstractBeanRestaurant {

	private String strAvgVote;
	
	public BeanFavRestaurant(String name, String address, String city, String strAvgVote) {
		super(name, address, city, null);
		this.strAvgVote=strAvgVote;
	}

	/**
	 * @return the strAvgVote
	 */
	public String getStrAvgVote() {
		return strAvgVote;
	}

	/**
	 * @param strAvgVote the strAvgVote to set
	 */
	public void setStrAvgVote(String strAvgVote) {
		this.strAvgVote = strAvgVote;
	}
	
}
