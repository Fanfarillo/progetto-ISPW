
package logic.engineeringclasses.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import logic.engineeringclasses.bean.manageMenu.BeanListReviews;
import logic.engineeringclasses.others.Connect;
import logic.engineeringclasses.query.QueryRestaurant;
import logic.engineeringclasses.query.QueryReview;
import logic.model.Restaurant;
import logic.model.Review;
import logic.model.Tourist;


public class ReviewsDAO {

	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String CONTENUTO = "Contenuto";


    public static List<Review> findRestaurantReviews(String restaurant) throws ClassNotFoundException, SQLException   {
        Statement stmt = null;
        Connection conn = null;
        List<Review> listOfReviews = new ArrayList<>();
        try {
            Class.forName(DRIVER);

            conn = Connect.getInstance().getDBConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            ResultSet rs;
            
	            rs = QueryReview.selectReviews(stmt,restaurant);
	            if(rs.first()) {
		            do{								
		                String text = rs.getString(CONTENUTO);
		                int vote = rs.getInt("Voto");
		                Tourist tourist=new Tourist(null,null,rs.getString("UsernameTurista"),null,null,null);
		                Review rev = new Review(text,tourist, vote,null);
		                listOfReviews.add(rev);
		            }while(rs.next());
	            }
            

            rs.close();
        	} finally {

            
                if (stmt != null)
                    stmt.close();
          
            
        }

        return listOfReviews;
    }


public static void updateAvgVote(Restaurant rest) throws ClassNotFoundException, SQLException  {
        Statement stmt = null;
        Connection conn = null;
        String name=rest.getName();
        Class.forName(DRIVER);
        conn = Connect.getInstance().getDBConnection();

        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            
        ResultSet rs=QueryReview.getAvg(stmt,name); 
        int cont=0;
        double avg=0;
        if(rs.first()) {
        	do {
        		cont++;
        		avg+=rs.getInt("Voto");
        	}while(rs.next());
        }
        if(avg!=0)       	
        	avg=avg/cont;
        QueryReview.insertAvg(stmt,avg,name);  
        stmt.close();
        rs.close();
    }

    public static Review findRestaurantReviews(String restaurant,String username) throws ClassNotFoundException, SQLException {		//recensione di un certo ristorante e di un certo utente
        Statement stmt = null;
        Connection conn = null;
        
        Review rev;
        
            Class.forName(DRIVER);

            conn = Connect.getInstance().getDBConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            ResultSet rs;
            
	            rs = QueryReview.selectReviewsByName(stmt,restaurant, username);
	            do{									
	                String text = rs.getString(CONTENUTO);
	                int vote = rs.getInt("Voto");
	                rev = new Review(text, vote);
	            }while(rs.next());  
	                       

        return rev;
    }

    

    public static void insertReview(Review review) throws ClassNotFoundException, SQLException  {
        Statement stmt = null;
        Connection conn = null;
        String username=review.getTourist().getUsername();
        String restaurant=review.getRestaurant().getName();
        String content=review.getText();
        
        int vote=review.getVote();        
            Class.forName(DRIVER);
            conn = Connect.getInstance().getDBConnection();

            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            QueryReview.insertReview(stmt, username, restaurant, content, vote);                                  
        stmt.close();
         
    }
    
    /**
     * Il metodo restituisce un oggetto avente quattro liste: una per i touristi, una per i ristoranti, una per il contenuto delle recensioni,
     * una per il voto al ristorante
     * @param username
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static BeanListReviews findOwnerReviews(String username) throws SQLException, ClassNotFoundException
    {
    	Statement stmt = null;
        Connection conn = null;
        ArrayList<String> restaurants = new ArrayList<>();
        BeanListReviews beanListReviews; 
        
        try {
            Class.forName(DRIVER);

            conn = Connect.getInstance().getDBConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            ResultSet rs;
            
            //ottengo i ristoranti dell'utente
	        rs = QueryRestaurant.selectOwnRestaurant(stmt, username);
	        rs.next();
	        do{								
	            restaurants.add(rs.getString("Nome"));
	        }while(rs.next());     
	        
	        beanListReviews = new BeanListReviews();
	        
	        for (int i = 0; i < restaurants.size(); i++) {		
	        	//prendo le recensioni del ristorante i-esimo
	        	rs = QueryReview.selectReviews(stmt, restaurants.get(i));
	        	while(rs.next()) {
	        		//creo le recensioni
	        		beanListReviews.getRestaurants().add(restaurants.get(i));
	        		beanListReviews.getContents().add(rs.getString(CONTENUTO));
	        		beanListReviews.getTourists().add(rs.getString("UsernameTurista"));
	        		beanListReviews.getVotes().add(rs.getString("Voto"));
	        	}
	        }
	        
        	} finally {

            
                if (stmt != null)
                    stmt.close();
          
            
        }

        return beanListReviews;
        
    }
    
    

    
}
