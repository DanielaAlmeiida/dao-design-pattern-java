package br.com.fiap.dao;

import java.sql.SQLException;

import java.util.List;


import br.com.fiap.model.Usuario;

public interface UsuarioDAO {

	public void insert(Usuario usuario) throws SQLException;
	
	public List<Usuario> select() throws SQLException;
	
	public Usuario selectById(int id) throws SQLException;
	
	public void delete(int id) throws SQLException;
	
	public void update(Usuario usuario) throws SQLException;

}
