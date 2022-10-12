package com.projetoapirest.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	public void configure(HttpSecurity httpSec) throws Exception {
		
		httpSec.csrf().disable() // DESABILITANDO ACESSOS EXTERNOS DA API PARA FAZER A NOSSA AUTENTICAÇÃO
		              .authorizeHttpRequests() // PERMITE O ACESSO AOS END POINTS
		              .antMatchers(HttpMethod.POST, "/usuarios/login").permitAll()
		              .anyRequest().authenticated().and().cors();
		
		httpSec.addFilterBefore(new SecurityFilter(), UsernamePasswordAuthenticationFilter.class); //OBJETO DE AUTENTICATION
	}

}
