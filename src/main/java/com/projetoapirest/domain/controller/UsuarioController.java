package com.projetoapirest.domain.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoapirest.domain.Usuario;
import com.projetoapirest.domain.repositories.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioRepository repositories;

	@GetMapping
	public List<Usuario> listaUsuarios() {
		return (List<Usuario>) repositories.findAll();
	}

	@PostMapping
	public Usuario criarUsuario(@RequestBody Usuario usuario) {
		Usuario novoUsuario = repositories.save(usuario);
		return novoUsuario;
	}

	@PutMapping
	public Usuario editarUsuario(@RequestBody Usuario usuario) {
		Usuario novoUsuario = repositories.save(usuario);
		return novoUsuario;

	}

	@DeleteMapping("/{id}")
	public Optional<Usuario> excluirUsuario(@PathVariable Integer id) {
		Optional<Usuario> delUsuario = repositories.findById(id);
		repositories.deleteById(id);
		return delUsuario;
	}

}