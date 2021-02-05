package logic.engineeringclasses.query;




import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class QueryRecipe {

	private QueryRecipe() {}
	
	public static ResultSet selectAllOtherRecipesWithMinimumPrice(Statement stmt,String username) throws SQLException {
		String sql = "select NomePiatto,NomeRistorante,Contenuto,Vegano,Celiaco, min(Prezzo)\r\n"
				+ "from piatto join ristorante on piatto.NomeRistorante = ristorante.Nome \r\n"
				+ "where ristorante.UsernameProprietario <> '"+username+"'\r\n"
				+ "group by NomePiatto";
		return stmt.executeQuery(sql);
	}
	
	/**
	 * Serve per add recipe
	 * @param stmt
	 * @return
	 * @throws SQLException
	 */
	public static ResultSet selectDish(Statement stmt) throws SQLException {
		String sql = "SELECT distinct NomePiatto FROM piattotipico";
		return stmt.executeQuery(sql);
	}
	
	/**
	 * Serve per restituire tutte le ricette di un proprietario per poterne eliminare una (vengono visualizzate
	 * su GUI cosi l'utente poi scegliere quale eliminare)
	 * @param stmt
	 * @param Username
	 * @return
	 * @throws SQLException
	 */
	public static ResultSet selectOwnDish(Statement stmt, String username) throws SQLException
	{
		String sql = "SELECT distinct NomePiatto FROM Piatto as P, Ristorante as R, Proprietario as PR WHERE P.NomeRistorante = R.Nome and R.UsernameProprietario = '"+ username +"';";
		return stmt.executeQuery(sql);
	}
	
	
	
	public static void addDish(Connection conn,String nomePiatto, String nomeRistorante, String contenuto, double prezzo, boolean vegano, boolean celiaco) throws SQLException  {
		
		PreparedStatement cstmt = null;
		try {
			
			cstmt = conn.prepareStatement("{call aggiungi_piatto4(?,?,?,?,?,?)}");
			cstmt.setString(1, nomeRistorante);
			cstmt.setString(2, nomePiatto);
			cstmt.setString(3, contenuto);
			cstmt.setDouble(4, prezzo);
			cstmt.setBoolean(5, vegano);
			cstmt.setBoolean(6, celiaco);
			
			cstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			//stampa stack
			e.printStackTrace();
			
			throw e;
		}finally {
			
			//chiudo
			try {
				if(cstmt != null) {
					
				cstmt.close();
				
				}
			} catch (Exception e2) {
				
				e2.printStackTrace();
				
			}
			
		}		
		
	}
	
	/**
	 * Elimina il piatto cucinato da un ristorante
	 * @param conn
	 * @param nomePiatto
	 * @param nomeRistorante
	 * @throws SQLException 
	 */
	public static void deleteDish(Connection conn, String nomeRistorante, String nomePiatto) throws SQLException {
		
		
		PreparedStatement preparedStatement = null;
		try {
			
			//creo insert preparedStatement
			preparedStatement = conn.prepareStatement("call elimina_piatto4(?,?);");
			preparedStatement.setString(1, nomeRistorante);
			preparedStatement.setString(2, nomePiatto);
			
			
			//eseguo
			preparedStatement.executeUpdate();
			
			
		} catch (SQLException e) {
			
			//stampa stack
			e.printStackTrace();
			
			throw e;
		}finally {
			
			//chiudo
			
			try {
				if(preparedStatement != null) {
					
					preparedStatement.close();
				
				}
			} catch (Exception e2) {
				
				e2.printStackTrace();
				
			}
			
		}
	}
	
	/**
	 * Devo prima trovare tutte le ricette NEI RISTORANTI DELL'UTENTE e poi modificare quelle selezionate assegnadole i vari parametri 
	 * inseriti dall'utente
	 * @param stmt
	 * @param nomePiatto
	 * @param username
	 * @throws SQLException 
	 */
	public static void updateDishes(String contenuto, String ristorante, Connection conn, String nomePiatto,double prezzo, boolean vegano, boolean celiaco) throws SQLException
	{
		PreparedStatement cstmt = null;
		try {
			
			cstmt =  conn.prepareStatement("{call aggiorna_piatto4(?,?,?,?,?,?)}");
			
			cstmt.setDouble(4, prezzo);
			cstmt.setBoolean(5, vegano);
			cstmt.setBoolean(6, celiaco);
			cstmt.setString(1, ristorante);
			cstmt.setString(2, nomePiatto);
			cstmt.setString(3, contenuto);
			
			cstmt.executeUpdate();
			
		} catch (SQLException e11) {
			
			//stampa stack
			e11.printStackTrace();			
			throw e11;
			
		}finally {
			
			//chiudo
			try {
				if(cstmt != null) {
					
				cstmt.close();
				
				}
			} catch (Exception e21) {
				
				e21.printStackTrace();
				
			}
			
		}		
	}
}