package com.cognizant.moviecruiser.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionHandler {
	static String driver;
	static String url;
	static String user;
	static String password;

	static {

		try {
			Properties properties = new Properties();
			String fileName = "connection.properties";
			properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName));
			driver = properties.getProperty("driver");
			url = properties.getProperty("connection-url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
			Class.forName(driver);

		} catch (IOException | ClassNotFoundException exception) {
			exception.printStackTrace();
		}

	}

	public static Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection(url, user, password);
		return connection;
	}
}
