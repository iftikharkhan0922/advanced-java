package com.iftikharkhan0922.MavenProjectForMySql.MavenProjectForMySql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * This class creates a connection instance to the Database.
 */

public class Database {
	
	// Initialize a database instance.
	private static Database db = new Database();
	private static final String URL = "jdbc:mysql://localhost:3306/people?serverTimezone=EST";
	private Connection conn;
	
	// Return data base instance.
	public static Database instance() {
		return db;
	}

	private Database() {
		
	}
	
	public Connection getConnection() {
		return conn;
	}
	
	public void connect() throws SQLException {
		conn = DriverManager.getConnection(URL, "root", "hello");
	}
	
	public void close() throws SQLException {
		conn.close();
	}
	
}
