package logic.engineeringclasses.dao;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import logic.model.Menu;
import logic.model.Restaurant;
import logic.engineeringclasses.exceptions.NoResultException;
import logic.engineeringclasses.query.FanfaQueryRestaurant;
import logic.engineeringclasses.others.Connect;

public class FanfaRestaurantDAO extends FanfaAbstractDAO {

	public List<Restaurant> select1(String city, boolean vegan, boolean celiac) throws NoResultException, Exception {
		// Step 1: declarations
		Statement stmt=null;
		Connection conn=null;
		List<Restaurant> listOfRestaurants = new ArrayList<Restaurant>();
		
		try {
			// Step 2: dinamic loading of sql driver
			Class.forName(this.DRIVER_CLASS_NAME);
			
			// Step 3: connection opening
			conn = Connect.getInstance().getDBConnection();
			
			// Step 4: creation and execution of query
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = FanfaQueryRestaurant.selectRestaurantsForTrip(stmt, city, vegan, celiac);
			
			if(!rs.first()) {		// rs empty
				NoResultException e = new NoResultException("No restaurant has been found.");
				throw e;
			}
			
			rs.first();
			do {
				String name = rs.getString("Nome");
				String address = rs.getString("Indirizzo");
				double avgVote = rs.getDouble("VotoMedio");
				//int dayOfWeek = rs.getInt("GiornoSettimana");
				//boolean atLunch = rs.getBoolean("ApertoAPranzo");
				//boolean atDinner = rs.getBoolean("ApertoACena");
				Menu menu = new Menu(null, rs.getDouble("Totale"));
				boolean[][] openingHours = new boolean[7][2];
				
				for(int i=0; i<7; i++) {
					for(int j=0; j<2; j++) {
						openingHours[i][j]=false;
					}
				}
				
				while(rs.getString("Nome")==name) {
					openingHours[rs.getInt("GiornoSettimana")-1][0] = rs.getBoolean("ApertoAPranzo");
					openingHours[rs.getInt("GiornoSettimana")-1][1] = rs.getBoolean("ApertoACena");
					rs.next();
				}
				rs.previous();
				
				Restaurant rest = new Restaurant(null, city, menu, address, name, avgVote, null, null, openingHours);
				listOfRestaurants.add(rest);
				
			}	while(rs.next());
			
			// Step 5: clean-up
			rs.close();
			
		}
		
		finally {
			try {
				if(stmt!=null) {
					stmt.close();
				}
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			
		}
		
		return listOfRestaurants;
		
	}
	
}
