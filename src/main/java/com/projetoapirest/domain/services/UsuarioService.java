package com.projetoapirest.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.projetoapirest.domain.Usuario;
import com.projetoapirest.domain.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	private UsuarioRepository usuarioRepository;
	private PasswordEncoder passwordEncoder;
	
	public  UsuarioService(UsuarioRepository repository) {
		this.usuarioRepository = repository;
		this.passwordEncoder = new BCryptPasswordEncoder();
		
	}
	
	public List<Usuario> listarUsuario(){
		return usuarioRepository.findAll();
		
	}
	
	public Optional<Usuario> umUsuario(Integer id){
		Optional<Usuario> idUsuario = usuarioRepository.findById(id);
		return idUsuario;
	}
	
	public Usuario criarUsuario(Usuario usuario) { // RECEBE UM USUARIO COM OS DADOS E ( no 'FORMATO JSON') ...
		String encoder = this.passwordEncoder.encode(usuario.getSenha());
		usuario.setSenha(encoder);
		Usuario usuarioNovo = usuarioRepository.save(usuario); // PEGA ESSE USUARIO E SALVA NO REPOSITORY E NA TABELA DO BD E ...
		return usuarioNovo;                             // ... DO BANCO RETORNA UM USUARIO SALVO CHAMADO usuarioNovo .
	}
	
	public Usuario editarUsuario(Usuario usuario) {
		Usuario usuarioNovo = usuarioRepository.save(usuario);
		return usuarioNovo;
	}
	
	public Boolean excluirUsuario(Integer id) {  // NÃO RETORNA O USUARIO EXCLUIDO
		usuarioRepository.deleteById(id);
		return true;
	}
}
