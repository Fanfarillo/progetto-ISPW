package logic.engineeringclasses.bean.sponsorrestaurant;

public class BeanNewRestaurant {

	private String name;
	private String address;
	private String city;
	private String usernameOwner;
	private boolean[][] openingHours;
	
	public BeanNewRestaurant(String name, String address, String city, String usernameOwner) {
		this.name=name;
		this.address=address;
		this.city=city;
		this.usernameOwner=usernameOwner;
		this.openingHours=null;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the usernameOwner
	 */
	public String getUsernameOwner() {
		return usernameOwner;
	}

	/**
	 * @param usernameOwner the usernameOwner to set
	 */
	public void setUsernameOwner(String usernameOwner) {
		this.usernameOwner = usernameOwner;
	}

	/**
	 * @return the openingHours
	 */
	public boolean[][] getOpeningHours() {
		return openingHours;
	}

	/**
	 * @param openingHours the openingHours to set
	 */
	public void setOpeningHours(boolean[][] openingHours) {
		this.openingHours = openingHours;
	}
	
	
	
}
