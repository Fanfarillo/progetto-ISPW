package logic.engineeringclasses.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import logic.engineeringclasses.query.QueryRestaurant;
import logic.engineeringclasses.query.QueryScheduling;
import logic.model.Restaurant;
import logic.model.Scheduling;

public class SchedulesDAO {
    private static String connectionString = "jdbc:mysql://localhost:3306/progettoispwfinaledatabase?user=root&password=Kp*d.!>3&serverTimezone=UTC";
    private static String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
    
    //get a list with user notifications
    public static List<Scheduling> findTouristScheduling(String user) throws Exception {
        Statement stmt = null;
        Connection conn = null;
        List<Scheduling> scheduling = new ArrayList<Scheduling>();
        
        try {
            Class.forName(DRIVER_CLASS_NAME);
            //conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            conn = DriverManager.getConnection(connectionString);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            
            String ristName;
            Restaurant rest;
            String address;
            String city;
            double vote;
            String date;
            Scheduling sched;
            boolean atLunch;
            List<List<String>> schedules= new ArrayList<>();
            List<String> schedule= new ArrayList<>();
            
            ResultSet rs = QueryScheduling.selectSchedules(stmt,user); 
            
            if(rs.first())
            {
            	do {          		
            	          	schedule.add(rs.getString("Ristorante"));
            	          	schedule.add(rs.getString("Giorno"));
            	          	schedule.add(rs.getString("CenaVsPranzo"));
            	          	schedules.add(schedule);
            	          	schedule=new ArrayList<>();
            	}while(rs.next());
            }
            
            for( List<String> eachSchedule: schedules ) {
            	
            	rs=QueryRestaurant.selectRestaurant(stmt, eachSchedule.get(0));               
                
                ristName=rs.getString("Nome");
                address=rs.getString("Indirizzo");
                city=rs.getString("Citta");
                vote=rs.getDouble("VotoMedio");
                rest=new Restaurant(ristName,address,city,vote);
                
                // TO FIX
                date=eachSchedule.get(1);
                atLunch=(eachSchedule.get(2).equals("Pranzo"));
                sched=new Scheduling(date,atLunch,rest);//vedi
                scheduling.add(sched);	//create a notification and add it to the list			
            	
            }


            
            rs.close();
        	} 
        	finally 
        	{       	
                if (stmt != null)
                    stmt.close();
                if (conn != null)
                    conn.close();
        
        	}

        return scheduling;
    }
}