package br.com.eleicoes.seeder;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.eleicoes.config.Database;

public class PermissoesSeeder {
	public static void seed() {
		
		String eleitor = "INSERT INTO permissoes (nome) VALUES ('eleitor')";
		String candidato = "INSERT INTO permissoes (nome) VALUES ('candidato')";
		String adm = "INSERT INTO permissoes (nome) VALUES ('administrador')";
		
		
		try (Connection con = Database.getConnection()) {
			try (Statement stmt = con.createStatement()) {
				stmt.executeUpdate(eleitor);
				stmt.executeUpdate(candidato);
				stmt.executeUpdate(adm);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
