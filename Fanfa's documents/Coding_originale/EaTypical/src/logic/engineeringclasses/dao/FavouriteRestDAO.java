// DA FIXARE



package logic.engineeringclasses.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import logic.engineeringclasses.query.QueryFavouriteRest;
import logic.model.Tourist;
import logic.model.Restaurant;


public class FavouriteRestDAO {

//Note this is the USER on the DBMS that has proper privileges in order to access the specific DB 	
	private static String DB_USER = "root";
    private static String DB_PASS = "password";
    private static String DB_URL = "jdbc:mysql://localhost:3308/progettoispwfinaledatabase";
    private static String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";

    public static List<Restaurant> findFavourites(Tourist tourist) throws Exception {
        // STEP 1: dichiarazioni
        Statement stmt = null;
        Connection conn = null;
        List<Restaurant> listOfRestaurants = new ArrayList<Restaurant>();
        
        try {
            // STEP 2: loading dinamico del driver mysql
            Class.forName(DRIVER_CLASS_NAME);

            // STEP 3: apertura connessione
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

            // STEP 4: creazione ed esecuzione della query
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            
            ResultSet rs = QueryFavouriteRest.selectFavourites(stmt,tourist);			//FIXARE IL TURISTA
            do{									//// SISTEMA TURISTA

                String restaurant = rs.getString("NomeRistorante");
                //SISTEMA RICERCA RISTORANTI PER NOME
                Restaurant rest=new Restaurant(null,null,null,null,null,null,null);
                listOfRestaurants.add(rest);
            }while(rs.next());
            
            // STEP 5.1: Clean-up dell'ambiente
            rs.close();
        	} finally {
            // STEP 5.2: Clean-up dell'ambiente
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

        return listOfRestaurants;
    }

    public static void insertFavourite(Restaurant rest, Tourist tourist) throws Exception {
        // STEP 1: dichiarazioni
        Statement stmt = null;
        Connection conn = null;
        
        try {
            // STEP 2: loading dinamico del driver mysql
            Class.forName(DRIVER_CLASS_NAME);

            // STEP 3: apertura connessione
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

            // STEP 4.1: creazione ed esecuzione della query
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = QueryFavouriteRest.selectFavourites(stmt, tourist);
            /*while (rs.next()) {								//CONTROLLO RISTORANTE NON PRESENTE FRA I FAVORITI
                // lettura delle colonne "by name"
                int albumId = rs.getInt("AlbumId");
                System.out.println("Found AlbumId: "+ albumId);
                if (albumId == instance.getAlbumId()){
                	DuplicatedRecordException e = new DuplicatedRecordException("Duplicated Instance ID. Id "+albumId + " was already assigned");
                	throw e;                	
                }
            }*/
            
            rs.close();
            stmt.close();

            // STEP 4.2: creazione ed esecuzione della query
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            int result = QueryFavouriteRest.insertFavourite(stmt, rest); 
            
            if(result==0) {												///DA FARE: VEDI SIGNIFICATO EXECUTEUPDATE
            	
            }



            
            // STEP 5.1: Clean-up dell'ambiente
            rs.close();
        } finally {
            // STEP 5.2: Clean-up dell'ambiente        	
                if (stmt != null)
                    stmt.close();
                if (conn != null)
                    conn.close();
        }
    }

    
}