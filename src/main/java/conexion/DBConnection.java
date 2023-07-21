package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	private static final String DB = "bbddm5";
	private static final String PORT = "3306";
	private static final String LOGIN = "root";
	private static final String PASSWORD = "cada2521";
	private static final String URL_CONEXION = "jdbc:mysql://localhost:"+PORT+"/"+DB;

	private static DBConnection instance=null;
	private Connection connection = null;
	
	private DBConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL_CONEXION,LOGIN,PASSWORD);
			if (connection !=null) {
				System.out.println("Conecion exitosa");
			} else {
				System.out.println("Problemas para conectarme");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static DBConnection getInstance() {
		if(instance == null) {
			instance = new DBConnection();
		}
		return instance;
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	public void disconnect() {
		if (instance !=null) {
			try {
				connection.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}			
		}
		connection=null;
	}
}
