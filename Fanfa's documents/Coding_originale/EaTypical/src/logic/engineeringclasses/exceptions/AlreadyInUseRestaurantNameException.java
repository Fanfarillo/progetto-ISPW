package logic.engineeringclasses.exceptions;

public class AlreadyInUseRestaurantNameException extends Exception{
private static final long serialVersionUID = 1L;
	
	public AlreadyInUseRestaurantNameException(String message) {
		super(message);
	}
}
