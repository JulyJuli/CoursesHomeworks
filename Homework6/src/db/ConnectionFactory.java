package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static final String DB_USER_NAME = "root";
	private static final String DB_USER_PASS = "12345";
	private static final String DB_HOST = "localhost:3306";
	private static final String DB_DATABASE = "test";

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
	}

	public static Connection getMySQlConnection() throws SQLException {
		String url = "jdbc:mysql://" + DB_HOST + "/" + DB_DATABASE;
		return DriverManager.getConnection(url, DB_USER_NAME, DB_USER_PASS);
	}

	

}
