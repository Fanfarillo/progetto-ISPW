package logic.engineeringclasses.adapter;

import java.sql.SQLException;
import java.util.List;
import logic.model.Restaurant;

public interface ChooseSpecificRestaurants {
	List<Restaurant> findAllRestaurants(String city) throws ClassNotFoundException, SQLException;
	
	List<Restaurant> findCeliacRestaurants(String city) throws ClassNotFoundException, SQLException;
	
	List<Restaurant> findVeganRestaurants(String city) throws ClassNotFoundException, SQLException;
	
	List<Restaurant> findBothRestaurants(String city) throws ClassNotFoundException, SQLException;
}
