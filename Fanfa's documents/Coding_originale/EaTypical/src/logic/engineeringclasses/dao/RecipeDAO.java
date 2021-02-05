package logic.engineeringclasses.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import logic.engineeringclasses.exceptions.DishAlreadyExists;
import logic.engineeringclasses.exceptions.InvalidDishDelete;
import logic.engineeringclasses.exceptions.InvalidDishModify;
import logic.engineeringclasses.others.Connect;
import logic.engineeringclasses.query.QueryRecipe;
import logic.model.Recipe;


public class RecipeDAO {

	/*
	 * Se ho tempo, crea un file di configurazione per le credenziali
	 */
	String connectionString = "jdbc:mysql://localhost:3306/progettoispwfinaledatabase?user=root&password=Monte_2020.&serverTimezone=UTC";
	private static String driverclassname = "com.mysql.jdbc.Driver";
	
	/**
	 * Instaura la connessione al DBMS e richiede la lettura dei possibili piatti tipici
	 * non necessariamente della sua citta
	 * @param username 
	 * @throws ClassNotFoundException 
	 * 
	 */
	
	public List<String> selectAllRecipe() throws ClassNotFoundException
	{
		ResultSet rs = null;
		Statement stmt = null;
		Connection conn = null;
		ArrayList<String> recipeNames = new ArrayList<>();
		
		
		try {
			
			//loading dinamico del driver del DBMS scelto
			Class.forName(driverclassname);
			
			//apro la connssione verso il DBMS
			conn = Connect.getInstance().getDBConnection();
			
			//creazione ed esecuzione dell'eliminazione
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);	
			
			
			rs = QueryRecipe.selectDish(stmt);
				
			//scansiono i risultati
			rs.first();
			String recipe;
			do {
				recipe = rs.getString(1);
				recipeNames.add(recipe);
			}
			while(rs.next());
				
			
			
			
		} catch (SQLException e8) {				
			e8.printStackTrace();
		}finally {
			try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se6) {
				se6.printStackTrace();
            }
		}
		
		return recipeNames;
	}
	
	/**
	 * Instaura la connessione al DBMS e richiede l'eliminazione del piatto identificato dai parametri
	 * @param nomeRistorante
	 * @param nomePiatto
	 * @throws ClassNotFoundException 
	 * @throws InvalidDishDelete 
	 * 
	 */
	
	public void deleteRecipe(String nomeRistorante, String nomePiatto) throws ClassNotFoundException, InvalidDishDelete {
		
		
		Connection conn = null;
	
		
		try {
			
			//loading dinamico del driver del DBMS scelto
			Class.forName(driverclassname);
			
			//apro la connssione verso il DBMS
			conn = Connect.getInstance().getDBConnection();
						
			
			QueryRecipe.deleteDish(conn, nomeRistorante, nomePiatto);
				
			
			
			
		} catch (SQLException e) {	
			throw new InvalidDishDelete(nomePiatto, nomeRistorante);
		}
		
	}
	
	/**
	 * Instaura la connessione al DBMS e richiede l'aggiunta del piatto identificato dai parametri
	 * @param nomeRistorante
	 * @param nomePiatto
	 * @throws ClassNotFoundException 
	 * 
	 */
	
	
	public void addDish(Recipe recipe) throws ClassNotFoundException, DishAlreadyExists {	
		Connection conn = null;	
		
		try {
			
			//loading dinamico del driver del DBMS scelto
			Class.forName(driverclassname);
			
			//apro la connssione verso il DBMS
			conn = Connect.getInstance().getDBConnection();
			
			//eseguo l'inserimento
			
			
			QueryRecipe.addDish(conn, recipe.getDishName(), recipe.getRestaurant(), recipe.getContenuto(), recipe.getPrice(), recipe.isVegan(),recipe.isCeliac());
			
			
			
		} catch (SQLException e) {		
			
			//lancio l'eccezione per dire che il piatto ÃƒÆ’Ã†â€™Ãƒâ€ Ã¢â‚¬â„¢ÃƒÆ’Ã¢â‚¬Â ÃƒÂ¢Ã¢â€šÂ¬Ã¢â€žÂ¢ÃƒÆ’Ã†â€™ÃƒÂ¢Ã¢â€šÂ¬Ã…Â¡ÃƒÆ’Ã¢â‚¬Å¡Ãƒâ€šÃ‚Â¨ stato giÃƒÆ’Ã†â€™Ãƒâ€ Ã¢â‚¬â„¢ÃƒÆ’Ã¢â‚¬Â ÃƒÂ¢Ã¢â€šÂ¬Ã¢â€žÂ¢ÃƒÆ’Ã†â€™ÃƒÂ¢Ã¢â€šÂ¬Ã…Â¡ÃƒÆ’Ã¢â‚¬Å¡Ãƒâ€šÃ‚Â  inserito in precedenza
			throw new DishAlreadyExists(recipe.getDishName());
			
		}
		
	}
	
	/**
	 * Instaura la connessione al DBMS e richiede la lettura delle ricette dei ristoranti del proprietario
	 * @param nomeRistorante
	 * @param nomePiatto
	 * @throws ClassNotFoundException 
	 * 
	 */
	
	public List<String> selectOwnRecipe(String username)
	{
		ResultSet rs = null;
		Statement stmt = null;
		Connection conn = null;
		ArrayList<String> obs = new ArrayList<>();
		
		try {
			
			//loading dinamico del driver del DBMS scelto
			Class.forName(driverclassname);
			
			//apro la connssione verso il DBMS
			conn = Connect.getInstance().getDBConnection();
			
			//creazione ed esecuzione dell'eliminazione
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);	
			
			
			rs = QueryRecipe.selectOwnDish(stmt, username);
				
			
				
			
			//scansiono i risultati
			rs.first();
			String recipe;
			do {
				recipe = rs.getString(1);
				obs.add(recipe);
			}
			while(rs.next());
				
			
			
			
		} catch (SQLException | ClassNotFoundException e) {			
			e.printStackTrace();
		}finally {
			try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException seStmt) {
				seStmt.printStackTrace();
            }
		}
		
		return obs;
	}
	
	
	public void updateDishes(Recipe recipe) throws ClassNotFoundException,  InvalidDishModify
	{
		Connection conn = null;	
		
		try {
			
			//loading dinamico del driver del DBMS scelto
			Class.forName(driverclassname);
			
			//apro la connssione verso il DBMS
			conn = Connect.getInstance().getDBConnection();
			
		
			QueryRecipe.updateDishes(recipe.getContenuto(),recipe.getRestaurant(),conn,recipe.getDishName(),recipe.getPrice(),recipe.isVegan(),recipe.isCeliac());
			
			
			
			
		} catch (SQLException e) {			
			//eccezione piatto non esistente
			throw new InvalidDishModify(recipe.getDishName(), recipe.getRestaurant());
			
		}
	}
	
	/**
	 * OTTIENE LE RICETTA CHE NON SONO TRATTATE DAI RISTORANTI DELLO USER
	 */
	
	public List<Recipe> selectAllOtherRecipes(String username) throws ClassNotFoundException
	{
		ResultSet rs = null;
		Statement stmt = null;
		Connection conn = null;
		ArrayList<Recipe> recipes = new ArrayList<>();
		
		
		try {
			
			//loading dinamico del driver del DBMS scelto
			Class.forName(driverclassname);
			
			//apro la connssione verso il DBMS
			conn = Connect.getInstance().getDBConnection();
			
			
			//creazione ed esecuzione dell'eliminazione
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);	
			
			
			rs = QueryRecipe.selectAllOtherRecipesWithMinimumPrice(stmt,username);
				
			//scansiono i risultati
			rs.first();
			Recipe recipe;
			do {
				recipe = new Recipe(rs.getString(1), rs.getString(3), rs.getString(2), rs.getBoolean(4), rs.getBoolean(5), rs.getDouble(6));				
				recipes.add(recipe);
			}
			while(rs.next());
				
			
			
			
		} catch (SQLException e3) {		
			e3.printStackTrace();
		}finally {
			try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se3) {
				se3.printStackTrace();
            }
		}
		
		return recipes;
	}
	
}