package logic.engineeringclasses.query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import logic.model.User;
import logic.model.Tourist;
import logic.model.Owner;


public class QueryLogin {
	
	public static ResultSet login(Statement stmt, User user, String pw, boolean isOwner) throws SQLException
	{
		String sql;
		if(!isOwner)
		{
			sql = "SELECT * FROM Turista WHERE Username = '"+ ((Tourist)user).getUsername() + "' and PASSWORD = '"+ pw +"';";
			
		}
		else 
		{
			sql = "SELECT * FROM Proprietario WHERE Username = '"+ ((Owner)user).getUsername() + "' and PASSWORD = '"+ pw +"';";
		}
		return stmt.executeQuery(sql);
	}
	public static int register(Statement stmt, User user, String pw, boolean isOwner) throws SQLException
	{	
		String insertStatement;
	
		if(!isOwner)
		{	
		    insertStatement = String.format("INSERT INTO Turista (Nome, Cognome, Username, Password) VALUES ('%s','%s','%s','%s')", ((Tourist)user).getName(), ((Tourist)user).getSurname(), ((Tourist)user).getUsername(), pw);
		    System.out.println("Turista Registrato");				        
		}
		else
		{
			insertStatement = String.format("INSERT INTO Proprietario (Nome, Cognome, Username, Password) VALUES ('%s','%s','%s','%s')", ((Owner)user).getName(), ((Owner)user).getSurname(), ((Owner)user).getUsername(), pw);
			System.out.println("Proprietario Registrato");	
		}
		return stmt.executeUpdate(insertStatement);
	}
	
}
