package come.revature.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class connectionFactory {
	
	private static connectionFactory cf;
	private static boolean build = true;
	
	private connectionFactory() {
		build = false;
	}

	public static synchronized connectionFactory getInstance() {
		return (build) ? cf = new connectionFactory() : cf;		
	}
	
	public Connection getConnection() {
		
		Connection con = null;
		Properties prop = new Properties();	
		
		try {
			
			prop.load(new FileReader("C:\\Users\\Tom Steyaert\\1806-Jun18-Java-USF\\jdbc-demo\\src\\test\\resources\\application.properties"));
			Class.forName(prop.getProperty("driver"));
			
			con = DriverManager.getConnection(
				prop.getProperty("url"),
				prop.getProperty("usr"),
				prop.getProperty("pw"));
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return con;
	}
		
	
}
