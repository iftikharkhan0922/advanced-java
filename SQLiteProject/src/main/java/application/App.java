package application;

import java.sql.DriverManager;
import java.sql.SQLException;

public class App {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Get the connection using SQLite driver.
		Class.forName("org.sqlite.JDBC");
		String dbUrl = "jdbc:sqlite:people.db";
		var conn = DriverManager.getConnection(dbUrl);
		
		// Create a statement to connection.
		var stmt = conn.createStatement();
		
		var sql = "create table if not exists user (id integer primary Key, name text not null)";
		stmt.execute(sql);
		
		sql = "insert into user (id, name) values (0, 'Iftikhar')";
		stmt.execute(sql);
		
		sql = "insert into user (id, name) values (1, 'Nelma')";
		stmt.execute(sql);
		
		sql = "insert into user (id, name) values (2, 'Farhan')";
		stmt.execute(sql);
		
		sql = "insert into user (id, name) values (3, 'Manal')";
		stmt.execute(sql);

		sql = "insert into user (id, name) values (4, 'Inayah')";
		stmt.execute(sql);
		
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
