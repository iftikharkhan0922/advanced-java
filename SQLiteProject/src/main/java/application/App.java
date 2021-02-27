package application;

import java.sql.DriverManager;
import java.sql.SQLException;

public class App {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		// Define ids and names.
		int [] ids = {0, 1, 2, 3, 4};
		String [] names = {"Iftikhar Khan", "Nelma Khan", "Farhan Khan", "Manal Khan", "Inayah Khan"};
		
		// Get the connection using SQLite driver.
		Class.forName("org.sqlite.JDBC");
		String dbUrl = "jdbc:sqlite:people.db";
		var conn = DriverManager.getConnection(dbUrl);
		
		// Create a statement to connection.
		var stmt = conn.createStatement();
		
		var sql = "create table if not exists user (id integer primary Key, name text not null)";
		stmt.execute(sql);
	
		// insert ids and names db.
		sql = "insert into user (id, name) values (?, ?)";
		var insertStmt = conn.prepareStatement(sql);
		
		for(int i = 0; i < ids.length; i++) {
			insertStmt.setInt(1, ids[i]);
			insertStmt.setString(2, names[i]);
			
			insertStmt.executeUpdate();
		}
		
		insertStmt.close();
		
		sql = "select * from user";
		var rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			System.out.println(id + ":" + name);
		}
		
		sql = "drop table user";
		stmt.execute(sql);
		
		stmt.close();
		conn.close(); // Close connection.
	}

}
