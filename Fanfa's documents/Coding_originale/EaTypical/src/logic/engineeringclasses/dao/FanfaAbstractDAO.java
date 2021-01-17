package logic.engineeringclasses.dao;

import java.util.List;

import logic.engineeringclasses.exceptions.NoResultException;
import logic.model.Restaurant;

public abstract class FanfaAbstractDAO {

	protected String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
	
	public abstract List<Restaurant> select1(String city, boolean vegan, boolean celiac) throws NoResultException, Exception;
	
}
