package br.com.eleicoes.migration;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.eleicoes.config.Database;

public class EleicaoMigration {
	public static void up() {
		String sql = "CREATE TABLE eleicoes (id INT(11) NOT NULL AUTO_INCREMENT, data_abertura DATE NULL DEFAULT NULL,PRIMARY KEY (id))";
		executa(sql);

	}

	public static void down() {
		String sql = "DROP TABLE eleicoes";
		executa(sql);
	}

	private static void executa(String sql) {
		try (Connection con = Database.getConnection()) {
			try (Statement stmt = con.createStatement()) {
				stmt.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
