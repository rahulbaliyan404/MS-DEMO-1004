package com.home.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DbConnection {
	private static final Logger LOGGER = LoggerFactory.getLogger(DbConnection.class);

	public static final String DRIVER;
	public static final String URL;
	public static final String USERNAME;
	public static final String PASSWORD;

	public DbConnection() {
		LOGGER.info("This is no-arg-constractor");
	}

	@Override
	public String toString() {
		return "Dont use.";
	}

	static {
		DRIVER = "com.mysql.jdbc.Driver";
		URL = "jdbc:mysql://localhost:3306/mydb";
		USERNAME = "root";
		PASSWORD = "root";
	}

	private Connection connection;

	public  Connection getDbConnection() {
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			return connection;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

}
