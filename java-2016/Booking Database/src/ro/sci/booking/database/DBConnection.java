package ro.sci.booking.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private static DBConnection dbConnection;
	private Connection connection;
	
	private DBConnection() {
		try {
			Class.forName("org.postgresql.Driver").newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		connection = connect("postgresql", "localhost", 5432, "booking", "postgres", "dfdfdf");
	}
	
	/**
	 * 
	 * @return connection.
	 */
	public static Connection getInstance(){
		try {
			if(dbConnection == null || dbConnection.getConnection().isClosed()){
				dbConnection = new DBConnection();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dbConnection.getConnection();
	}
	
	private Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	private static Connection connect(String type, String host, int port, String dbName, String user, String pw) {

		Connection conn = null;
		DriverManager.setLoginTimeout(60);
		try {
			String url = new StringBuilder().append("jdbc:").append(type) 
					.append("://").append(host).append(":").append(port).append("/").append(dbName).append("?user=")
					.append(user).append("&password=").append(pw).toString();
			
			System.out.println("URL:" + url);
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.err.println("Cannot connect to the database: " + e.getMessage());
		}
		return conn;
	}	
}