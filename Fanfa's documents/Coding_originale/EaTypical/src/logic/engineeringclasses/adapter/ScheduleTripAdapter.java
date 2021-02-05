package logic.engineeringclasses.adapter;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import logic.controller.applicationcontroller.ScheduleTrip;
import logic.engineeringclasses.exceptions.NoResultException;
import logic.model.Restaurant;

public class ScheduleTripAdapter implements ChooseSpecificRestaurants{
	
	ScheduleTrip st;
	
	public ScheduleTripAdapter(ScheduleTrip st)
	{
		this.st=st;
	}
	
	public List<Restaurant> findAllRestaurants(String city) throws ClassNotFoundException, SQLException
	{
		List<Restaurant> rest;
		try {
		rest= this.st.callDAO(city,false,false);
		}catch(NoResultException ne) {
			rest=new ArrayList<>();
		}
		return rest;
	}
	
	public List<Restaurant> findCeliacRestaurants(String city) throws ClassNotFoundException, SQLException
	{
		List<Restaurant> rest;
		try {
		rest= this.st.callDAO(city,false,true);
		}catch(NoResultException ne) {rest=new ArrayList<>();}
		return rest;
	}
	
	public List<Restaurant> findVeganRestaurants(String city) throws ClassNotFoundException, SQLException
	{
		List<Restaurant> rest;
		try {
		rest= this.st.callDAO(city,true,false);
		}catch(NoResultException ne) {rest=new ArrayList<>();}
		return rest;
	}
	
	public List<Restaurant> findBothRestaurants(String city) throws ClassNotFoundException, SQLException
	{
		List<Restaurant> rest;
		try {
		rest= this.st.callDAO(city,true,true);
		}catch(NoResultException ne) {rest=new ArrayList<>();}
		return rest;
	}
}
