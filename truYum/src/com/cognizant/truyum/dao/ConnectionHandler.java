package com.cognizant.truyum.dao;

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
			Properties prop = new Properties();
			String fileName = "connection.properties";
			prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName));
			driver = prop.getProperty("driver");
			url = prop.getProperty("connection-url");
			user = prop.getProperty("user");
			password = prop.getProperty("password");
			Class.forName(driver);

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println(driver);
		System.out.println(url);
		System.out.println(user);
		System.out.println(password);
	}

	public static Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection(url, user, password);
		return connection;
	}
}
