package com.projetoapirest.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	
	@Column(name = "ids")
	private Integer id;
	
	@Column(name = "nomes", length = 100, nullable = true)
	private String nome;
	
	@Column(name = "emails", length = 50, nullable = true)
	private String email;
	
	@Column(name = "senhas", columnDefinition = "TEXT")
	private String senha;
	
	@Column(name = "telefones", length = 50, nullable = true )
	private String telefone;
	
	public Usuario() {
		
	}

	public Usuario(Integer id, String nome, String email, String senha, String telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone; 
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
	
	
}
