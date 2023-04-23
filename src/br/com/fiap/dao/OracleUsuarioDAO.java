package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Usuario;

public class OracleUsuarioDAO implements UsuarioDAO {
	
	private Connection conexao;
	
	//Construtor
	public OracleUsuarioDAO() {
		this.conexao = new ConnectionFactory().conectar();
	}

	//INSERT (CRUD - Create) - Inserir um Usuario no banco
	@Override
	public void insert(Usuario usuario) throws SQLException {
		
		String sql = "insert into usuario(id, nome, email, senha, telefone, data) "
				+ "values (?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		
		stmt.setLong(1, usuario.getId());
		stmt.setString(2, usuario.getNome());
		stmt.setString(3, usuario.getEmail());
		stmt.setString(4, usuario.getSenha());
		stmt.setString(5, usuario.getTelefone());
		stmt.setDate(6, usuario.getData());

		stmt.execute();
		stmt.close();
	}
	
	//SELECT * (CRUD - Read) - Buscar todos os Usuarios do banco
	@Override
	public List<Usuario> select() throws SQLException {
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		String sql = "select * from usuario order by nome";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
	
		while (rs.next()) {
			Usuario usuario = new Usuario();
			usuario.setId(rs.getLong("id"));
			usuario.setNome(rs.getString("nome"));
			usuario.setEmail(rs.getString("email"));
			usuario.setSenha(rs.getString("senha"));
			usuario.setTelefone(rs.getString("telefone"));
			usuario.setData(rs.getDate("data"));
			
			usuarios.add(usuario);
		}
	
		rs.close();
		stmt.close();
		return usuarios;
	}
	
	//SELECT where (CRUD - Read) - Busca um único Usuario pelo ID
	@Override
	public Usuario selectById(int id) throws SQLException {
		
		Usuario usuario = null;
		String sql = "select * from usuario where id = ? ";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setLong(1, id);
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
			usuario = new Usuario();
			usuario.setId(rs.getLong("id"));
			usuario.setNome(rs.getString("nome"));
			usuario.setEmail(rs.getString("email"));
			usuario.setSenha(rs.getString("senha"));
			usuario.setTelefone(rs.getString("telefone"));
			usuario.setData(rs.getDate("data"));
		}
		
		rs.close();
		stmt.close();
		return usuario;
	}
	
	//DELETE - Exclusão de um Usuario pelo ID
	@Override
	public void delete(int id) throws SQLException {
		String sql = "delete from usuario where id = ?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setLong(1, id);
		stmt.execute();
		stmt.close();
	}
	
	//ALTER - Altera um Usuario
	@Override
	public void update(Usuario usuario) throws SQLException {
		String sql = "update usuario set nome=?, email=?, senha=?, telefone=? where id=?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		
		stmt.setString(1, usuario.getNome());
		stmt.setString(2, usuario.getEmail());
		stmt.setString(3, usuario.getSenha());
		stmt.setString(4, usuario.getTelefone());
		stmt.setLong(5, usuario.getId());
		
		stmt.execute();
		stmt.close();
	}


	
}
