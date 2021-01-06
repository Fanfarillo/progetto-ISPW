package logic.engineeringclasses.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import logic.engineeringclasses.query.QueryRecipe;
import logic.model.Recipe;


public class RecipeDAO {

	/*
	 * Se ho tempo, crea un file di configurazione per le credenziali
	 */
	String connectionString = "jdbc:mysql://localhost:3306/progettoispwfinaledatabase?user=root&password=Monte_2020.&serverTimezone=UTC";
	private String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
	
	/**
	 * Instaura la connessione al DBMS e richiede l'eliminazione del piatto identificato dai parametri
	 * @param nomeRistorante
	 * @param nomePiatto
	 * @throws ClassNotFoundException 
	 * 
	 */
	
	public ObservableList<String> selectRecipe(String username) throws ClassNotFoundException
	{
		ResultSet rs = null;
		Statement stmt = null;
		Connection conn = null;
		ObservableList<String> obs = FXCollections.observableArrayList();
		try {
			
			//loading dinamico del driver del DBMS scelto
			Class.forName(DRIVER_CLASS_NAME);
			
			//apro la connssione verso il DBMS
			conn = DriverManager.getConnection(connectionString);
			
			
			//creazione ed esecuzione dell'eliminazione
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);	
			
			try {
				rs = QueryRecipe.selectDish(stmt, username);
				
				//scansiono i risultati
				rs.first();
				String recipe;
				do {
					recipe = rs.getString(1);
					System.out.println(recipe);
					obs.add(recipe);
				}
				while(rs.next());
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		} catch (SQLException e) {			
			System.out.print("Eccezione eliminazione piatto");			
		}finally {
			try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            	System.out.println("Errore chiusura Statement delete");
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
            	System.out.println("Errore chiusura Connessione delete");
                se.printStackTrace();
            }
		}
		
		return obs;
	}
	
	public void deleteRecipe(String nomeRistorante, String nomePiatto) throws ClassNotFoundException {
		
		Statement stmt = null;
		Connection conn = null;
		int ret = -1;
		
		try {
			
			//loading dinamico del driver del DBMS scelto
			Class.forName(DRIVER_CLASS_NAME);
			
			//apro la connssione verso il DBMS
			conn = DriverManager.getConnection(connectionString);
			
			
			//creazione ed esecuzione dell'eliminazione
			stmt = conn.createStatement();			
			try {
				ret = QueryRecipe.deleteDish(stmt, nomeRistorante, nomePiatto);
				System.out.println(ret);
			} catch (SQLException e) {
				System.out.println("Errore eliminazione piatto");
			}
			
			
		} catch (SQLException e) {			
			System.out.print("Eccezione eliminazione piatto");			
		}finally {
			try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            	System.out.println("Errore chiusura Statement delete");
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
            	System.out.println("Errore chiusura Connessione delete");
                se.printStackTrace();
            }
		}
		
	}
	
	public void addDish(Recipe recipe) throws ClassNotFoundException {	
		Connection conn = null;	
		
		try {
			
			//loading dinamico del driver del DBMS scelto
			Class.forName(DRIVER_CLASS_NAME);
			
			//apro la connssione verso il DBMS
			conn = DriverManager.getConnection(connectionString);
			
			//eseguo l'inserimento
			
			try {
				QueryRecipe.addDish(conn, recipe.getDishName(), recipe.getRestaurant().getName(), recipe.getContenuto(), recipe.getPrice(), recipe.isVegan(),recipe.isCeliac());
				System.out.print("add completata.\n");
				
			} catch (SQLException e) {
				System.out.print("Errore add fish DAO");
			}
			
			
		} catch (SQLException e) {			
			System.out.print("Eccezione eliminazione piatto");			
		}finally {
			
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
            	System.out.println("Errore chiusura Connessione delete");
                se.printStackTrace();
            }
		}
		
	}
}
