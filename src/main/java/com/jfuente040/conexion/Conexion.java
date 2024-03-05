package com.jfuente040.conexion;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;


public class Conexion {
	
	private static BasicDataSource dataSource = null;
	
	private static DataSource getDataSource() {
		if(dataSource == null) {
			dataSource = new BasicDataSource();
			dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
			dataSource.setUsername("root");
			dataSource.setPassword("PDAPESDB");
			dataSource.setUrl("jdbc:mysql://localhost:3306/crud");
			dataSource.setInitialSize(20);
			dataSource.setMaxIdle(15);
			dataSource.setMaxTotal(20);
	        dataSource.setMaxConnLifetimeMillis(5000);
		}
		
		return dataSource;
	}
	
	public static Connection getConnection() {	
		Connection c = null;
		try {
			return getDataSource().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

}
