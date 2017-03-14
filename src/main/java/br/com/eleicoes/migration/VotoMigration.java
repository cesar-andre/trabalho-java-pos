package br.com.eleicoes.migration;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.eleicoes.config.Database;

public class VotoMigration {
	public static void up() {
		String sql = "CREATE TABLE votos (id INT(11) NOT NULL AUTO_INCREMENT,id_eleitor INT(11) NOT NULL,id_candidato INT(11) NOT NULL,id_eleicao INT(11) NOT NULL,data DATE NOT NULL,PRIMARY KEY (id),INDEX fk_eleitor (id_eleitor),INDEX fk_candidato (id_candidato),INDEX fk_eleicao (id_eleicao),CONSTRAINT fk_candidato FOREIGN KEY (id_candidato) REFERENCES usuarios (id) ON UPDATE CASCADE ON DELETE CASCADE,CONSTRAINT fk_eleicao FOREIGN KEY (id_eleicao) REFERENCES eleicoes (id) ON UPDATE CASCADE ON DELETE CASCADE,CONSTRAINT fk_eleitor FOREIGN KEY (id_eleitor) REFERENCES usuarios (id) ON UPDATE CASCADE ON DELETE CASCADE);";
		executa(sql);

	}

	public static void down() {
		String sql = "DROP TABLE votos";
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
