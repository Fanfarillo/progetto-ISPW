package logic.engineeringclasses.query;

import java.sql.SQLException;
import java.sql.Statement;

public class QueryScheduling {

	private QueryScheduling() {}
	
	public static void deleteScheduling(Statement stmt, String username) throws SQLException {
		stmt.executeUpdate("DELETE FROM Scheduling WHERE Turista = '" +username+ "'");
	}
	
	public static void insertScheduling(Statement stmt, String username, String date, boolean atLunch, String nameRest) throws SQLException {
		stmt.executeUpdate("INSERT INTO Scheduling VALUES('" +username+ "', '" +date+ "', '" +atLunch+ "', '" +nameRest+ "')");
	}
	
}
