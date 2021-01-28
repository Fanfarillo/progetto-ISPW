package logic.engineeringclasses.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import logic.engineeringclasses.bean.manageMenu.BeanListNotificationsScheduling;
import logic.engineeringclasses.bean.manageMenu.BeanSchedulingNotification;
import logic.engineeringclasses.query.QueryNotifications;

/**
 * 
 * @author Luca Capotombolo
 *
 */

public class NotificationsOwnerDAO {

	String connectionString = "jdbc:mysql://localhost:3306/progettoispwfinaledatabase?user=root&password=Monte_2020.&serverTimezone=UTC";
	private String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
	
	public BeanListNotificationsScheduling selectOwnerSchedulingNotifications(String username) throws ClassNotFoundException {
		
		ResultSet rs = null;
		Statement stmt = null;
		Connection conn = null;
		BeanListNotificationsScheduling notifications = new BeanListNotificationsScheduling();
		
		
		try {
			
			//loading dinamico del driver del DBMS scelto
			Class.forName(DRIVER_CLASS_NAME);
			
			//apro la connssione verso il DBMS
			conn = DriverManager.getConnection(connectionString);
			
			
			//creazione ed esecuzione dell'eliminazione
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);	
			
			
			rs = QueryNotifications.ownerNotificationScheduling(stmt,username);
				
			//scansiono i risultati
			rs.first();
			BeanSchedulingNotification notification;notification = new BeanSchedulingNotification();
			
			do {
				notification = new BeanSchedulingNotification();
				notification.setUsername(rs.getString(2));
				notification.setRistorante(rs.getString(3));
				notification.setData(rs.getString(4));
				notification.setPranzoVsCena(rs.getString(5));
				System.out.println(notification);
				notifications.getNotifications().add(notification);
			}
			while(rs.next());
				
			
			
			
		} catch (SQLException e) {			
			System.out.print("Notifica scheduling");		
			e.printStackTrace();
		}finally {
			try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            	System.out.println("Errore chiusura Statement notifica");
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
            	System.out.println("Errore chiusura Connessione notifica");
                se.printStackTrace();
            }
		}
		
		return notifications;
	}
}
