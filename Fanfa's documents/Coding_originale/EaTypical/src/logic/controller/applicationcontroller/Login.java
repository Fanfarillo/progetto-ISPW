package logic.controller.applicationcontroller;


import logic.model.Owner;
import logic.model.Tourist;
import logic.model.User;

import java.sql.SQLException;

import logic.engineeringclasses.bean.login.BeanLoggedUser;
import logic.engineeringclasses.bean.login.BeanUser;
import logic.engineeringclasses.dao.OwnerDAO;
import logic.engineeringclasses.dao.TouristDAO;
import logic.engineeringclasses.exceptions.AlreadyInUseUsernameException;
import logic.engineeringclasses.exceptions.GenericException;
import logic.engineeringclasses.exceptions.LoginDBException;
import logic.engineeringclasses.exceptions.WrongUsernameOrPasswordException;


public class Login {
	
	
	
	public BeanLoggedUser loginMethod(BeanUser loggingUser) throws  LoginDBException,WrongUsernameOrPasswordException,SQLException, ClassNotFoundException
	{				
		BeanLoggedUser loggedUser=new BeanLoggedUser();
		
		try		
		{
			if(loggingUser.isOwner())
			{
				Owner user;
				user=(Owner)OwnerDAO.selectOwner(loggingUser.getUsername(),loggingUser.getPassword());
				loggedUser.setUsername(user.getUsername());
				loggedUser.setName(user.getName());
				return loggedUser;
			}
			else
			{
				Tourist user;
				user=(Tourist) TouristDAO.selectTourist(loggingUser.getUsername(),loggingUser.getPassword());
				loggedUser.setUsername(user.getUsername());
				loggedUser.setName(user.getName());
				loggedUser.setFavouriteRestaurants(user.getFavouriteRestaurants());
				loggedUser.setNotifications(user.getNotifications());
				loggedUser.setTrip(user.getTrip());
				return loggedUser;
			}
		}
		catch(LoginDBException dbe)		//exception came from the db: the username or the password are wrong
		{
			throw new WrongUsernameOrPasswordException("Invalid Username Or Password");
		}
		catch(SQLException e)				//generic exception to handle that may occour if there is a bug or some not planned interaction
		{
			e.printStackTrace();
			throw new SQLException("Please try again!");
		}
	}
	
	public BeanLoggedUser registerMethod(BeanUser loggingUser) throws GenericException, AlreadyInUseUsernameException
	{
		String name=loggingUser.getName();
		String surname=loggingUser.getSurname();
		String username=loggingUser.getUsername();
		String password=loggingUser.getPassword();
		BeanLoggedUser blu=new BeanLoggedUser();
		try
		{
			if(loggingUser.isOwner())
			{
				User newOwner=new Owner(name, surname,username);
				OwnerDAO.insertOwner(newOwner, password);			
			}
			else {
				User newTourist=new Tourist(name, surname, username, null, null, null);
				TouristDAO.insertTourist(newTourist, password);
			}
			blu.setUsername(username);
			blu.setName(name);
			return blu;
		}
		catch(AlreadyInUseUsernameException ae)			//exception came form the db: the username that the user want to use is already is use by someone
		{
			throw new AlreadyInUseUsernameException(ae.getMessage());
		}
		catch(Exception e)								//generic exception to handle that may occour in caso of there's a bug or some not planned interaction
		{
			throw new GenericException("Please try again!");
		}
	}

}
