package logic.engineeringclasses.bean.login;

import logic.engineeringclasses.exceptions.LoginException;
public class BeanUser {
	
	private String username;
	private String name;
	private String surname;
	private String password;
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) throws Exception{
		if(username.equals(""))
		{
			throw exceptionMaker(0);
		}
		else {
		this.username = username;
		}
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) throws Exception{
		if(name.equals(""))
		{
			throw exceptionMaker(1);
		}
		else
		{
		this.name = name;
		}
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) throws Exception{
		if(surname.equals(""))
		{
			throw exceptionMaker(2);
		}
		else
		{
		this.surname = surname;
		}
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) throws Exception{
		if(password.equals(""))
		{			
			throw exceptionMaker(3);
		}
		else
		{		
		this.password = password;
		}
	}
	
	private LoginException exceptionMaker(int code)
	{
		return new LoginException(code);
	}

}
