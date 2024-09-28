package shopping.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import jakarta.annotation.Resource;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;

@Singleton
@Startup
public class DBConnection {
	public static String jdbcURL = "jdbc:sqlserver://localhost:1433;encrypt=false;databaseName =shopping;";
	public static String jdbcUsername = "sa";
	public static String jdbcPassword = "sapassword";

	@Resource(lookup = "java:comp/env/jdbc/shopping")
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
