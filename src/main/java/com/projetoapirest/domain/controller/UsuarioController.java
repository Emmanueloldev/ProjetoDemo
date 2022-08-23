package com.projetoapirest.domain.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoapirest.domain.Usuario;
import com.projetoapirest.domain.services.UsuarioService;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuarios")
public class UsuarioController {

	//Excluimos o @Autowired
	//          private UsuarioRepository repositories; por conta que estamos usando o SERVICE
	
	public  UsuarioService usuarioService;
	
	private UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;

	}
	
	@GetMapping
	public ResponseEntity <List<Usuario>> listaUsuarios() {
		return ResponseEntity.status(200).body(usuarioService.listarUsuario());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Integer> umUsuario(@PathVariable Integer id){
		usuarioService.umUsuario(id);
		return ResponseEntity.status(200).body(id);
	}

	@PostMapping
	public ResponseEntity <Usuario> criarUsuario(@RequestBody Usuario usuario) {  //@ResquestBody = Validação de objeto
		return ResponseEntity.status(201).body(usuarioService.criarUsuario(usuario));
	}

	@PutMapping
	public ResponseEntity <Usuario> editarUsuario(@RequestBody Usuario usuario) {
		return ResponseEntity.status(201).body(usuarioService.editarUsuario(usuario));

	}

	@DeleteMapping("/{id}")
	public ResponseEntity <Optional <Usuario>> excluirUsuario(@PathVariable Integer id) {
		usuarioService.excluirUsuario(id);
		return ResponseEntity.status(204).build();   // build = não diz o usuario excluido
	}

}