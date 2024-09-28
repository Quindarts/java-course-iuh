package bookStore.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import jakarta.annotation.Resource;

public class ConnectionDB {
	public static String jdbcURL = "jdbc:sqlserver://localhost:1433;encrypt=false;databaseName =bookStore;";
	public static String jdbcUsername = "sa";
	public static String jdbcPassword = "sapassword";

	@Resource(lookup = "java:comp/env/jdbc/bookStore")
	private static DataSource ds;

	public static Connection getConnection() {
		System.out.println(ds);
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException var5) {
			var5.printStackTrace();
		}

		return connection;
	}
}
