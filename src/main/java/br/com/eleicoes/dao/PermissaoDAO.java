package br.com.eleicoes.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.eleicoes.config.Database;
import br.com.eleicoes.model.Permissao;

public class PermissaoDAO {
	
	private Connection con;
	private Permissao permissao;
	private List<Permissao> permissoes;

	public List<Permissao> findAll() {
		
		permissoes = new ArrayList<>();
		
		try {
			con = Database.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM permissoes");
			while (rs.next()) {
				permissao.setId(rs.getInt("id"));
				permissao.setNome(rs.getString("nome"));
				permissoes.add(permissao);
			}
						
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return permissoes;
	}

}
