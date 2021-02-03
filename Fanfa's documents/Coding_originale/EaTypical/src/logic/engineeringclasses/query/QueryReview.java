package logic.engineeringclasses.query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryReview {
	
	private QueryReview(){};
	
	public static ResultSet selectReviews(Statement stmt, String restaurantName) throws SQLException
	{
		String sql = "SELECT * FROM Recensione WHERE NomeRistorante = '"+ restaurantName + "';";
		return stmt.executeQuery(sql);
	}
	public static ResultSet selectReviewsByName(Statement stmt, String restaurantName, String username) throws SQLException
	{
		String sql = "SELECT * FROM Recensione WHERE NomeRistorante = '"+ restaurantName + "' AND UsernameTurista = '" + username + "';";
		return stmt.executeQuery(sql);
	}
	public static int insertReview(Statement stmt, String username,String restaurant, String content, int vote) throws SQLException
	{						
		String insertStatement = String.format("INSERT INTO Recensione (UsernameTurista, NomeRistorante, Contenuto, Voto) VALUES ('%s','%s','%s',%d)", username, restaurant, content, vote);
		System.out.println("recensione inserita");
		return stmt.executeUpdate(insertStatement);
		    
	}
	public static ResultSet getAvg(Statement stmt, String name) throws SQLException {
		String selectStatement="SELECT AVG(Voto) FROM Recensione WHERE NomeRistorante = '"+name+"';";
		return stmt.executeQuery(selectStatement);
	}
	
	public static int insertAvg(Statement stmt, Double vote, String name) throws SQLException {
		String insertStatement=String.format("UPDATE Ristorante SET VotoMedio = %d WHERE Nome='%s';",vote,name);
		return stmt.executeUpdate(insertStatement);
	}
	 
}