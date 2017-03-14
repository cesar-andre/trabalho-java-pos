package br.com.eleicoes.migration;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.eleicoes.config.Database;

public class UsuarioMigration {
	public static void up() {
		String sql = "CREATE TABLE usuarios (id INT(11) NOT NULL AUTO_INCREMENT,id_permissao INT(11) NOT NULL,nome TEXT NOT NULL,email TEXT NOT NULL,senha TEXT NOT NULL,foto TEXT NOT NULL,codigo TEXT NOT NULL,PRIMARY KEY (id),INDEX fk_permissao (id_permissao),CONSTRAINT fk_permissao FOREIGN KEY (id_permissao) REFERENCES permissoes (id) ON UPDATE CASCADE ON DELETE CASCADE)";
		executa(sql);

	}

	public static void down() {
		String sql = "DROP TABLE usuarios";
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
