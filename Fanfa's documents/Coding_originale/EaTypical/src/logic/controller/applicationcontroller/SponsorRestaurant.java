package logic.controller.applicationcontroller;

import java.sql.SQLException;

import logic.engineeringclasses.bean.sponsorrestaurant.BeanNewRestaurant;
import logic.engineeringclasses.dao.RestaurantDAO;
import logic.engineeringclasses.exceptions.AlreadyInUseRestaurantNameException;

public class SponsorRestaurant {

	public void saveRestaurant(BeanNewRestaurant bnr) throws SQLException, AlreadyInUseRestaurantNameException, ClassNotFoundException {
		 RestaurantDAO.insertRestaurant(bnr.getName(), bnr.getAddress(), bnr.getCity(), bnr.getUsernameOwner(), bnr.getOpeningHours());
		
	}
	
}
