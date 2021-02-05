package logic.engineeringclasses.query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class QueryFavouriteRest {
	private QueryFavouriteRest(){}
	//get a result set with the favourite restaurants of an user from the database
	public static ResultSet selectFavourites(Statement stmt, String tourist) throws SQLException
	{
		String sql = "SELECT * FROM Preferiti WHERE UsernameTurista = '"+ tourist + "';";
		return stmt.executeQuery(sql);
	}
	
	public static int insertFavourite(Statement stmt, String rest, String tourist) throws SQLException
	{		
		        String insertStatement = String.format("INSERT INTO Preferiti (NomeRistorante, UsernameTurista) VALUES ('%s','%s')", rest, tourist);		      
		        return stmt.executeUpdate(insertStatement);		    
	}
	 
}