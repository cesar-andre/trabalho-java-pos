package br.com.eleicoes.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

	public static Connection getConnection() throws SQLException {

		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/eleicoes", "root", "");
		return connection;

	}
}
