package br.com.eleicoes.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

import br.com.eleicoes.dao.PermissaoDAO;
import br.com.eleicoes.model.Permissao;
import br.com.eleicoes.model.Usuario;

@ManagedBean
public class UsuariosBean {

	private Usuario usuario;

	public void cadastra() {

	}

	public List<Permissao> getPermissoes() {
		PermissaoDAO dao = new PermissaoDAO();
		return dao.findAll();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
