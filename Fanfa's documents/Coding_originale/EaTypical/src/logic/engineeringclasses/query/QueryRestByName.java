package logic.engineeringclasses.query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class QueryRestByName {
	
	private QueryRestByName(){throw new IllegalStateException("Utility class");};
	public static ResultSet selectRestaurants(Statement stmt, String restaurant) throws SQLException
	{
		String sql = "SELECT * FROM Ristorante WHERE Nome = '"+ restaurant + "';";
		return stmt.executeQuery(sql);
	}	
	 
}