package com.javamaster.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionPool {
	
	
	private ConnectionPool(){
		//private constructor
	}
	
	/**
	 * Connection instance
	 */
	private Connection connection = getConnection();

	private static ConnectionPool instance = null;
	
	public static ConnectionPool getInstance(){
		if (instance==null)
			instance = new ConnectionPool();
		return instance;
	}
	
	/**
	 * Getting connection from connection pool.
	 *
	 * @see ConnectionPool
	 * @throws SQLException
	 */
	Connection getConnection() {

				try {
					Class.forName("org.postgresql.Driver").newInstance();
				} catch (InstantiationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
		String username = "mxqsrpyhemzlek";
		String password = "a085a69d6fda2851e106bbc4d4fbcb9c25d86b85162cd7215001f18186a262b1";
		String dbUrl = "jdbc:postgresql://" + "ec2-44-215-40-87.compute-1.amazonaws.com:5432"
				+ "/d2gnmbkfbpoccu?sslmode=require";
		try {
			return DriverManager.getConnection(dbUrl, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return connection;
	}
}
