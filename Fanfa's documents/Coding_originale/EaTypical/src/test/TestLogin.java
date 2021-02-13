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
import java.util.Random;

public class TestLogin {
	
	@Test
	public void testRegisterMethodUserAlreadyExists()
	{
		int code=-1;
		BeanUser bu=new BeanUser();
		Login login=new Login();
		try {
		bu.setUsername("Pazizo");
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
		Random random=new Random();
		int code=-1;
		int rand;
		boolean badUsername;
		
		String randomUser;
		do {
				badUsername=false;
				randomUser="";
				for(int i=0;i<6;i++)
				{
					rand=random.nextInt(22);
					switch(rand) {
					case 0: randomUser+="a"; break;
					case 1: randomUser+="b"; break;
					case 2: randomUser+="c"; break;
					case 3: randomUser+="d"; break;
					case 4: randomUser+="e"; break;
					case 5: randomUser+="f"; break;
					case 6: randomUser+="g"; break;
					case 7: randomUser+="h"; break;
					case 8: randomUser+="i"; break;
					case 9: randomUser+="l"; break;
					case 10: randomUser+="m"; break;
					case 11: randomUser+="n"; break;
					case 12: randomUser+="o"; break;
					case 13: randomUser+="p"; break;
					case 14: randomUser+="q"; break;
					case 15: randomUser+="r"; break;
					case 16: randomUser+="s"; break;
					case 17: randomUser+="t"; break;
					case 18: randomUser+="u"; break;
					case 19: randomUser+="v"; break;
					case 20: randomUser+="w"; break;
					case 21: randomUser+="z"; break;
					default: randomUser+="Aa"; 
					}
				}
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
		bu.setUsername("Pazizo");
		bu.setPassword("1");
		blu=login.loginMethod(bu);
		} catch (ClassNotFoundException | LoginDBException | WrongUsernameOrPasswordException | SQLException | DataException e) {
			code=1;			
		}
		boolean correctLogin=(blu.getUsername().equals("Pazizo")&&code==-1);
		assertEquals(true, correctLogin);
		
	}
	
	@Test
	public void testLoginMethodWrongPassword()
	{
		int code=-1;
		BeanUser bu=new BeanUser();		
		Login login=new Login();
		try {
		bu.setUsername("Pazizo");
		bu.setPassword("testWrongPassword");
		login.loginMethod(bu);
		} catch (ClassNotFoundException | LoginDBException | SQLException | DataException e) {
			code=1;			
		}
		catch(WrongUsernameOrPasswordException we) {
			code=1;
		}
		
		assertEquals(1, code);
		
	}
		

}
