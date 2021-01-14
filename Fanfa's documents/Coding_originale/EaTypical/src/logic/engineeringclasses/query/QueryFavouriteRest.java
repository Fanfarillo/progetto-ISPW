package logic.engineeringclasses.query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import logic.model.Restaurant;
import logic.model.Tourist;

public class QueryFavouriteRest {
	

	public static ResultSet selectFavourites(Statement stmt, Tourist tourist) throws SQLException
	{
		String sql = "SELECT * FROM Preferiti WHERE NomeRistorante = '"+ tourist.getUsername() + "';";
		return stmt.executeQuery(sql);
	}
	public static int insertFavourite(Statement stmt, Restaurant rest) throws SQLException
	{		
		        String insertStatement = String.format("INSERT INTO Preferiti (NomeRistorante, UsernameTurista) VALUES ('%s',%s)", rest.getName(), rest.getName());
		        System.out.println("Ristorante inserito nei preferiti");			//FIXARE IL TURISTA!
		        return stmt.executeUpdate(insertStatement);
		    
	}
	 
}