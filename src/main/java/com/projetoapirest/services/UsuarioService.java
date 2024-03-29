package com.projetoapirest.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.projetoapirest.domain.Usuario;
import com.projetoapirest.dto.UsuarioDto;
import com.projetoapirest.repositories.UsuarioRepository;
import com.projetoapirest.security.Token;
import com.projetoapirest.security.TokenUtil;



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
		String encoder = this.passwordEncoder.encode(usuario.getSenha());
		usuario.setSenha(encoder);
		Usuario usuarioNovo = usuarioRepository.save(usuario);
		return usuarioNovo;
	}
	
	public Boolean excluirUsuario(Integer id) {  // NÃO RETORNA O USUARIO EXCLUIDO
		usuarioRepository.deleteById(id);
		return true;
	}

	public Boolean validarSenha(Usuario usuario) {
		String senha = usuarioRepository.getReferenceById(usuario.getId()).getSenha();
		Boolean valid = passwordEncoder.matches(usuario.getSenha(), senha); //COMPARA O GETSENHA DO BANCO COM A SENHA QUE TA CHEGANDO
		return valid;
	}

	public Token gerarToken(@Valid UsuarioDto usuario) {
		Usuario user = usuarioRepository.findByNomeOrEmail(usuario.getNome(), usuario.getEmail());
		
		if( user !=null ) { // VERIFICA SE O USUARIO EXISTE
			
			Boolean valid = passwordEncoder.matches(usuario.getSenha(), user.getEmail());
		
			if (valid) {
				return new Token(TokenUtil.createToken(user));
			}
		}
		return null;
	}
}
