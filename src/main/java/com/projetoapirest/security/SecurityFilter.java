package com.projetoapirest.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

public class SecurityFilter extends OncePerRequestFilter {

	
	@Override
	protected void doFilterInternal(HttpServletRequest request, 
			                        HttpServletResponse response, 
			                        FilterChain filterChain) throws ServletException, IOException { //filterChain = OBJETO DO FILTER
		// TODO Auto-generated method stub
		
		filterChain.doFilter(request, response); //INTERCEPTA(RECEBE) A REQUISIÇÃO E MANDA UMA RESPOSTA
		//CHAMA OS MÉTODOS DA CLASSE TOKEN UTIL
	}
}
