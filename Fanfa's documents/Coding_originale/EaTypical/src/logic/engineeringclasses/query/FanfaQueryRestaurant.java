package logic.engineeringclasses.query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FanfaQueryRestaurant {

	public static ResultSet selectRestaurantsForTrip(Statement stmt, String city, boolean vegan, boolean celiac) throws SQLException {
		String sql;
		
		if(vegan==true && celiac==true) {
			sql = "SELECT distinct Nome, Indirizzo, VotoMedio, Totale, GiornoSettimana, ApertoAPranzo, ApertoACena FROM Ristorante, Menu M, Piatto P, Apertura A "
					+ "WHERE M.NomeRistorante=Nome and P.NomeRistorante=Nome and A.NomeRistorante=Nome and Citta='" +city+ "' and Vegano='1' and Celiaco='1' ORDER BY Nome;";
		}
		else if(vegan==true && celiac==false) {
			sql = "SELECT distinct Nome, Indirizzo, VotoMedio, Totale, GiornoSettimana, ApertoAPranzo, ApertoACena FROM Ristorante, Menu M, Piatto P, Apertura A "
					+ "WHERE M.NomeRistorante=Nome and P.NomeRistorante=Nome and A.NomeRistorante=Nome and Citta='" +city+ "' and Vegano='1' ORDER BY Nome;";
		}
		else if(vegan==false && celiac==true) {
			sql = "SELECT distinct Nome, Indirizzo, VotoMedio, Totale, GiornoSettimana, ApertoAPranzo, ApertoACena FROM Ristorante, Menu M, Piatto P, Apertura A "
					+ "WHERE M.NomeRistorante=Nome and P.NomeRistorante=Nome and A.NomeRistorante=Nome and Citta='" +city+ "' and Celiaco='1' ORDER BY Nome;";			
		}
		else {
			sql = "SELECT distinct Nome, Indirizzo, VotoMedio, Totale, GiornoSettimana, ApertoAPranzo, ApertoACena FROM Ristorante, Menu M, Piatto P, Apertura A "
					+ "WHERE M.NomeRistorante=Nome and P.NomeRistorante=Nome and A.NomeRistorante=Nome and Citta='" +city+ "' ORDER BY Nome;";
		}
		
		return stmt.executeQuery(sql);
		
	}
	
}
