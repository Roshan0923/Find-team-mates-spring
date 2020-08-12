package com.example.demo.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbConfig {
	  private static DbConfig uniqueInstance = null;
	    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

	    private static final String URL = "jdbc:mysql://assignment4.ckyqzu90h1yu.us-east-1.rds.amazonaws.com:3306/team-mate-finder?createDatabaseIfNotExist=true&autoReconnect=true&useSSL=false";
	    private static final String USER = "root";
	    private static final String PASSWORD = "shreeji2017";

	 public DbConfig() {
		// TODO Auto-generated constructor stub
	}
	    public static DbConfig instance()
	    {
	        if (null == uniqueInstance)
	        {
	            uniqueInstance = new DbConfig();
	        }
	        return uniqueInstance;
	    }

	    public Connection getDBConnection() throws SQLException
	    {
	        return DriverManager.getConnection(URL, USER, PASSWORD);
	    }

}
