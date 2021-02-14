package test;
import org.junit.Test;
/*test cases: Baba adrian
 * 
 * 1) Try to register with an username that already exists, that will result in an exception
 * 2) Try to register using a random (and not already used) username
 * 3) Try to login with the correct username and password 
 * 4) Try to login using the wrong password, that will result in an exception
 * 
 */

import logic.controller.applicationcontroller.Login;
import logic.engineeringclasses.bean.login.BeanLoggedUser;
import logic.engineeringclasses.bean.login.BeanUser;
import logic.engineeringclasses.exceptions.AlreadyInUseUsernameException;
import logic.engineeringclasses.exceptions.DataException;
import logic.engineeringclasses.exceptions.GenericException;
import logic.engineeringclasses.exceptions.LoginDBException;
import logic.engineeringclasses.exceptions.WrongUsernameOrPasswordException;

import static org.junit.Assert.*;

import java.sql.SQLException;

public class TestLogin {
	
	private String username="Pazizo";
	StringBuilder bld = new StringBuilder();
	char alphabet[]= {'a','b','c','d','e','f','g','h','i','l','m','n','o','p','q','r','s','t','u','v','w','z'};
	
	@Test
	public void testRegisterMethodUserAlreadyExists()
	{
		int code=-1;
		BeanUser bu=new BeanUser();
		Login login=new Login();
		try {
		bu.setUsername(username);
		bu.setName("testName");
		bu.setSurname("testSurname");
		bu.setPassword("1");
		login.registerMethod(bu);
		}catch(DataException|GenericException error) {
			code=0;
		}
		 catch ( AlreadyInUseUsernameException e) {
			code=1;
		}
		assertEquals(1, code);
		
	}
	
	@Test
	public void testRegisterMethodrandomData()
	{
		BeanLoggedUser blu=new BeanLoggedUser();
		int code=-1;
		int rand;
		boolean badUsername;
		
		String randomUser;
		do {
				badUsername=false;
				randomUser="";
				for(int i=0;i<6;i++)
				{
					rand=(int)(Math.random() * 22 );
					bld.append(alphabet[rand]);					
				}
				randomUser=bld.toString();
				BeanUser bu=new BeanUser();
				Login login=new Login();
				try {
				bu.setUsername(randomUser);
				bu.setName("testName");
				bu.setSurname("testSurname");
				bu.setPassword("1");
				blu=login.registerMethod(bu);
				}catch(DataException|GenericException error) {
					code=0;
				}
				 catch ( AlreadyInUseUsernameException e) {
					badUsername=true;
				}
		}while(badUsername);
		boolean success=(code==-1&&blu.getUsername().equals(randomUser));
		
		assertEquals(true, success);
		
	}
	
	@Test
	public void testLoginMethodCorrect()
	{
		int code=-1;
		BeanLoggedUser blu= new BeanLoggedUser();
		BeanUser bu=new BeanUser();		
		Login login=new Login();
		try {
		bu.setUsername(username);
		bu.setPassword("1");
		blu=login.loginMethod(bu);
		} catch (ClassNotFoundException | LoginDBException | WrongUsernameOrPasswordException | SQLException | DataException e) {
			code=1;			
		}
		boolean correctLogin=(blu.getUsername().equals(username)&&code==-1);
		assertEquals(true, correctLogin);
		
	}
	
	@Test
	public void testLoginMethodWrongPassword()
	{
		int code=-1;
		BeanUser bu=new BeanUser();		
		Login login=new Login();
		try {
		bu.setUsername(username);
		bu.setPassword("testWrongPassword");
		login.loginMethod(bu);
		} catch (ClassNotFoundException | LoginDBException | SQLException | DataException e) {
			code=0;			
		}
		catch(WrongUsernameOrPasswordException we) {
			code=1;
		}
		
		assertEquals(1, code);
		
	}
		

}
