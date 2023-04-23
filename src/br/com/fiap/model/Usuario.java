package br.com.fiap.model;

import java.sql.Date;
import java.util.Calendar;

public class Usuario {
	private long id;
	private String nome;
	private String email;
	private String senha;
	private String telefone;
	private Date data = new Date(Calendar.getInstance().getTimeInMillis());
	
	//Constructor
	public Usuario() {
		
	}
	
	public Usuario(long id, String nome, String email, String senha, String telefone) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "{Nome: " + nome + ", Email: " + email 
				+ ", Telefone: " + telefone + ", Data: " + data + "}";
	}
	
	
}
