package com.iftikharkhan0922.MavenProjectForMySql.MavenProjectForMySql;

import java.sql.SQLException;

public class DaoException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DaoException(SQLException e) {
		super(e);
	}
	
	

}
