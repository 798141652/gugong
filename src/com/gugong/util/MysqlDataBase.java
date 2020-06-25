package com.gugong.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class MysqlDataBase {
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://49.234.101.49:3306/gugong?serverTimezone=GMT&useUnicode=true&characterEncoding=utf-8";
	private static final String USER = "root";
	private static final String PASSWORD = "19981126";

	private static Connection connection;
	private static PreparedStatement reparedStatement;
	private static ResultSet resultSet;

	public static Connection getConnct() throws SQLException {
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return connection;

	}

	public static void getClose(Connection c, java.sql.Statement s, ResultSet r)
			throws SQLException {
		if (c != null) {
			c.close();
		}
		if (s != null) {
			s.close();
		}
		if (r != null) {
			r.close();
		}

	}

}
