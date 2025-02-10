package org.dnyayog.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {
	private static String url = "jdbc:mysql://127.0.0.1:3307/ecommerce_management";
	private static String userName = "root";
	private static String password = "mohite@123";

	public static Connection connection;
	private static Statement statement;

	static {
		try {
			connection = DriverManager.getConnection(url, userName, password); // create connection
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ResultSet executeSelectQuery(String query) throws SQLException {

		Statement statement = connection.createStatement(); // SQL Script editor
		ResultSet result = statement.executeQuery(query);
		return result;
	}

	public static Connection userConnection() {
		setUrl("jdbc:mysql://127.0.0.1:3307/user");
		try {
			return DriverManager.getConnection(getUrl(), userName, password);
		} catch (SQLException e) {

			e.printStackTrace();
			return connection;
		}
	}

	private static String getUrl() {

		return url;
	}

	public static void setUrl(String tempurl) {
		url = tempurl;
	}

	public static Connection productConnection() {
		setUrl("jdbc:mysql://127.0.0.1:3307/product");
		try {
			return DriverManager.getConnection(getUrl(), userName, password);
		} catch (SQLException e) {

			e.printStackTrace();
			return connection;
		}
	}

	public static boolean executeQuery(String query) throws SQLException {
		return statement.execute(query);
	}
}
