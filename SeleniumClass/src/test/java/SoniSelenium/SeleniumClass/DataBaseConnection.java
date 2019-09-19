package SoniSelenium.SeleniumClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnection {

	public static void main(String[] args) {
	
		try {
			/*Registering driver step is optional,Since JDBC 4.0, explicitly registering the driver is optional. 
			 * We just need to put vender's Jar in the classpath, and then JDBC driver manager can detect 
			 * and load the driver automatically. **/
			//Class.forName("com.mysql.cj.jdbc.Driver"); 	
			
			String url = "jdbc:mysql://us-east-dev-us-dcs-dev57-aurora-cluster.cluster-ccgacol62mak.us-east-1.rds.amazonaws.com:3306/de-qa";
			String username = "svcuat1userro";
			String password = "PassworDuat";
			Connection connection = DriverManager.getConnection(url, username, password);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM `de-qa`.baseProfile");
			while(resultSet.next()) {
				System.out.println("DCS ID   "+resultSet.getLong(1)+ "  username   "+resultSet.getString(2)+ "  firstname "+ resultSet.getString("firstName"));
			}
			connection.close();

		} catch ( SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
