package com.ensah.utils;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;

import com.ensah.model.entityData.ConnectionData;

public class ConnectionFactory {

	private static ConnectionFactory connectionFactory = null;

	private ConnectionFactory() {
		try {
			Class.forName(ConnectionData.driverClassName.getValue());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = (Connection) DriverManager.getConnection(ConnectionData.connectionUrl.getValue(),
					ConnectionData.dbUser.getValue(), ConnectionData.dbPwd.getValue());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static ConnectionFactory getInstance() {
		if (connectionFactory == null) {
			connectionFactory = new ConnectionFactory();
		}
		return connectionFactory;
	}
}
