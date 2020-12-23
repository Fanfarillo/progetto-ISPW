package logic.model;

/**
 * Non vogliamo che tale classe venga istanziata
 * @author hp
 *
 */

public abstract class User {
	private String name;
	private String surname;
	private boolean notification;
		
	
	public User(String name, String surname,boolean notifications) {
		this.surname = surname;
		this.name = name;
		this.notification = notifications;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public boolean isNotification() {
		return notification;
	}

	public void setNotification(boolean notification) {
		this.notification = notification;
	}	
	
}
