package databaseConnection;

import java.sql.*;

public class DBConnection {

		private DBConnection() {

		}

		private static String user = "uppg";
		private static String pwd = "uppg";

		public static Connection getConnection() throws SQLException {
			String url = "jdbc:sqlserver://localhost:1433;database=uppgift1";
			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
			return DriverManager.getConnection(url, user, pwd);
}
}
