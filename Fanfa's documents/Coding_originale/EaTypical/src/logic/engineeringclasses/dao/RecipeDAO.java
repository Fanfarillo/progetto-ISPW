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
	String connectionString = "jdbc:mysql://localhost:3306/progettoispwfinaledatabase3?user=root&password=Monte_2020.&serverTimezone=UTC";
	private String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
	
	/**
	 * Instaura la connessione al DBMS e richiede la lettura dei possibili piatti tipici
	 * @param username 
	 * @throws ClassNotFoundException 
	 * 
	 */
	
	public ObservableList<String> selectAllRecipe() throws ClassNotFoundException
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
			
			
			rs = QueryRecipe.selectDish(stmt);
				
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
	
	/**
	 * Instaura la connessione al DBMS e richiede l'eliminazione del piatto identificato dai parametri
	 * @param nomeRistorante
	 * @param nomePiatto
	 * @throws ClassNotFoundException 
	 * 
	 */
	
	public void deleteRecipe(String nomeRistorante, String nomePiatto) throws ClassNotFoundException {
		
		
		Connection conn = null;
	
		
		try {
			
			//loading dinamico del driver del DBMS scelto
			Class.forName(DRIVER_CLASS_NAME);
			
			//apro la connssione verso il DBMS
			conn = DriverManager.getConnection(connectionString);
			
			
			//creazione ed esecuzione dell'eliminazione
			//stmt = conn.createStatement();			
			
			QueryRecipe.deleteDish(conn, nomeRistorante, nomePiatto);
			System.out.print("Procedura chiamata.\n!");
				
			
			
			
		} catch (SQLException e) {			
			System.out.print("Eccezione eliminazione piatto");	
			e.printStackTrace();
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
	
	/**
	 * Instaura la connessione al DBMS e richiede l'aggiunta del piatto identificato dai parametri
	 * @param nomeRistorante
	 * @param nomePiatto
	 * @throws ClassNotFoundException 
	 * 
	 */
	
	
	public void addDish(Recipe recipe) throws ClassNotFoundException {	
		Connection conn = null;	
		
		try {
			
			//loading dinamico del driver del DBMS scelto
			Class.forName(DRIVER_CLASS_NAME);
			
			//apro la connssione verso il DBMS
			conn = DriverManager.getConnection(connectionString);
			
			//eseguo l'inserimento
			
			
			QueryRecipe.addDish(conn, recipe.getDishName(), recipe.getRestaurant(), recipe.getContenuto(), recipe.getPrice(), recipe.isVegan(),recipe.isCeliac());
			System.out.print("add completata.\n");
			
			
			
		} catch (SQLException e) {		
			
			//stampa stack
			e.printStackTrace();
			
		}finally {
			
			//chiudo la connessione al DBMS
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
		}
		
	}
	
	/**
	 * Instaura la connessione al DBMS e richiede la lettura delle ricette dei ristoranti di un proprietario
	 * @param nomeRistorante
	 * @param nomePiatto
	 * @throws ClassNotFoundException 
	 * 
	 */
	
	public ObservableList<String> selectOwnRecipe(String username)
	{
		ResultSet rs = null;
		Statement stmt = null;
		Connection conn = null;
		ObservableList<String> obs = FXCollections.observableArrayList();
		
		System.out.println("Usernam : " + username);
		try {
			
			//loading dinamico del driver del DBMS scelto
			Class.forName(DRIVER_CLASS_NAME);
			
			//apro la connssione verso il DBMS
			conn = DriverManager.getConnection(connectionString);
			
			
			//creazione ed esecuzione dell'eliminazione
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);	
			
			
			rs = QueryRecipe.selectOwnDish(stmt, username);
				
			
				
			//System.out.print(rs.toString());
			
			//scansiono i risultati
			rs.first();
			String recipe;
			do {
				recipe = rs.getString(1);
				//System.out.println(recipe);
				obs.add(recipe);
			}
			while(rs.next());
				
			
			
			
		} catch (SQLException e) {			
			System.out.print("Eccezione eliminazione piatto");	
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
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
	
	
	public void updateDishes(String contenuto,String ristorante,String nomePiatto,String username,double prezzo, boolean vegano, boolean celiaco) throws ClassNotFoundException
	{
		Connection conn = null;	
		
		try {
			
			//loading dinamico del driver del DBMS scelto
			Class.forName(DRIVER_CLASS_NAME);
			
			//apro la connssione verso il DBMS
			conn = DriverManager.getConnection(connectionString);
			
		
			QueryRecipe.updateDishes(contenuto,ristorante,conn,nomePiatto,username,prezzo,vegano,celiaco);
			//System.out.print("add completata.\n");
			
			
			
		} catch (SQLException e) {			
			System.out.print("Eccezione aggiornamento piatto");	
			e.printStackTrace();
		}finally {
			
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
            	System.out.println("Errore chiusura Connessione update");
                se.printStackTrace();
            }
		}
	}
	
}