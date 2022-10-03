package com.projetoapirest.security;

public class Token {

	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Token(String token) { //CONSTRUTOR COM ARGUMENTO
		super();
		this.token = token;
	}
	
	
}
