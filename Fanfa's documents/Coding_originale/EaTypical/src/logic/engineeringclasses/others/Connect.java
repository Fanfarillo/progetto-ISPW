package logic.engineeringclasses.others;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

public class Connect {
	
	private static Connect instance=null;
	private Connection conn=null;
	
	protected Connect() {}
	
	public static synchronized Connect getInstance() {
		
		if(Connect.instance==null) {
			Connect.instance = new Connect();
		}
		return Connect.instance;
	}
	
	public synchronized Connection getDBConnection()  {
		
		if(this.conn==null) {
			try {
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, ""); 
				factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, ""); 
				DocumentBuilder builder = factory.newDocumentBuilder();
				Document document = builder.parse(new File("./src/logic/engineeringclasses/others/config.xml"));
				String connectionString = document.getElementsByTagName("DbLuca").item(0).getTextContent();
				String driver = document.getElementsByTagName("Driver").item(0).getTextContent();
				Class.forName(driver);
				this.conn = DriverManager.getConnection(connectionString);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return this.conn;
	}

}







