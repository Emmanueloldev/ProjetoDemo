package com.projetoapirest.domain.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projetoapirest.domain.Usuario;
import com.projetoapirest.domain.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	private UsuarioRepository repository;
	
	public  UsuarioService(UsuarioRepository repository) {
		this.repository = repository;
	}
	
	public List<Usuario> listarUsuario(){
		List<Usuario> lista = repository.findAll();
		return lista;
	}
	
	public Usuario criarUsuario(Usuario usuario) {
		Usuario usuarioNovo = repository.save(usuario);
		return usuarioNovo;
	}
	
	public Usuario editarUsuario(Usuario usuario) {
		Usuario usuarioNovo = repository.save(usuario);
		return usuarioNovo;
	}
	
	public Boolean excluirUsuario(Integer id) {
		repository.deleteById(id);
		return true;
	}
}
