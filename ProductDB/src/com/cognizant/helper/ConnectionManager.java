package com.cognizant.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConnectionManager {
@Autowired
	private DataSource datasource;

private static Connection conn=null;
public Connection openConnection()
{
	try {
		Class.forName(datasource.getDriver());
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		conn=DriverManager.getConnection(datasource.getUrl(),datasource.getUsername(),datasource.getPassword());
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return conn;
}
public void closeConnection()
{
	try {
		conn.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
}
