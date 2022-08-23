package com.projetoapirest.domain.services;

import java.util.List;
import java.util.Optional;

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
		return repository.findAll();
		
	}
	
	public Optional<Usuario> umUsuario(Integer id){
		Optional<Usuario> idUsuario = repository.findById(id);
		return idUsuario;
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
