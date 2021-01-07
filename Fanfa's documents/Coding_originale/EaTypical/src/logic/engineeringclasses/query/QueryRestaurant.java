package logic.engineeringclasses.query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryRestaurant {
	
	private QueryRestaurant() {}

	public static ResultSet selectOwnRestaurant(Statement stmt, String username) throws SQLException
	{
		String sql = "SELECT nome FROM ristorante WHERE UsernameProprietario = '"+ username + "';";
		return stmt.executeQuery(sql);
	}
}
