package com.projetoapirest.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name = "usuarios")
public class Usuario {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	
	@Column(name = "Ids")
	private Integer id;
	
	@NotBlank(message= "O nome é Obrigatório!")
	@Size(min = 3, message="O nome teve conter no mínimo 3 caracteres!")
	@Column(name = "Nomes", length = 100, nullable = false)
	private String nome;
	
	@Email(message="Insira um email válido!")
	@NotBlank(message= "O email é Obrigatório!")
	@Column(name = "Emails", length = 50, nullable = false)
	private String email;
	
	@NotBlank(message= "A senha é Obrigatória!")
	@Column(name = "Senhas", columnDefinition = "TEXT", nullable = false)
	private String senha;

	@NotBlank(message= "O telefone é Obrigatório!")
	@Column(name = "Telefones", length = 50, nullable = false )
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
