package logic.engineeringclasses.query;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class QueryRecipe {

	private QueryRecipe() {}
	/**
	 * 
	 * Elimina un piatto dal menu di un ristorante
	 * 
	 * @param stmt statement
	 * @param nomeRistorante nome del ristorante che ha la ricetta
	 * @param nomePiatto nome del piatto che deve essere eliminato
	 * @return il numero di righe interessate oppure 0 se si una una istruzione DDL
	 * @throws SQLException
	 */
	
	/**
	 * Serve per add recipe
	 * @param stmt
	 * @return
	 * @throws SQLException
	 */
	public static ResultSet selectDish(Statement stmt) throws SQLException {
		String sql = "SELECT distinct NomePiatto FROM Piatto";
		System.out.print("Query eseguita\n");
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
	
	
	
	public static int deleteDish(Statement stmt, String nomeRistorante, String nomePiatto) throws SQLException {
		String sql = "DELETE FROM piatto WHERE NomeRistorante = '" + nomeRistorante + "' and NomePiatto = '" + nomePiatto + "';";
		System.out.println(sql);
		return stmt.executeUpdate(sql);		
	}
	
	public static void addDish(Connection conn,String nomePiatto, String nomeRistorante, String contenuto, double prezzo, boolean vegano, boolean celiaco) throws SQLException  {
		String sql = "INSERT into piatto(NomeRistorante, NomePiatto,Contenuto,Prezzo,Vegano,Celiaco) values(?,?,?,?,?,?);";
		PreparedStatement preparedStatement = null;
		try {
			//creo insert preparedStatement
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, nomeRistorante);
			preparedStatement.setString(2, nomePiatto);
			preparedStatement.setString(3, contenuto);
			preparedStatement.setDouble(4, prezzo);
			preparedStatement.setBoolean(5, vegano);
			preparedStatement.setBoolean(6, celiaco);
			
			//eseguo
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Eccezione add dish");
			throw e;
		}finally {
			try {
				if(preparedStatement != null) {
				preparedStatement.close();
				}
			} catch (Exception e2) {
				System.out.println("Eccezione add dish");
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
	 */
	public static void updateDishes(Statement stmt, String nomePiatto,String username)
	{
		
	}
}