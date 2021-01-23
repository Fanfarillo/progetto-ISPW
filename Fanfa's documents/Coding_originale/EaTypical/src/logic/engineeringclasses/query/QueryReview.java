package logic.engineeringclasses.query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import logic.model.Review;

public class QueryReview {
	

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
	public static int insertReview(Statement stmt, Review review) throws SQLException
	{		
		        String insertStatement = String.format("INSERT INTO Recensione (UsernameTurista, Nomeristorante, Contenuto, Voto) VALUES ('%s','%s','%s',%s)", review.getTourist(), review.getRestaurant(), review.getText(), review.getVote());
		        System.out.println("recensione inserita");
		        return stmt.executeUpdate(insertStatement);
		    
	}
	 
}