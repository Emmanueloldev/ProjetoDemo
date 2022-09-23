package com.projetoapirest.domain.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.projetoapirest.domain.Usuario;
import com.projetoapirest.domain.services.UsuarioService;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuarios")

public class UsuarioController {

	//EXCLUIMOS o @Autowired
	//          private UsuarioRepository repositories; POR CONTA QUE ESTAMOS USANDO o SERVICE
	
	
	private  UsuarioService usuarioService;
	

	public  UsuarioController(UsuarioService usuarioService) {
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
	public ResponseEntity <Usuario> criarUsuario(@Valid @RequestBody Usuario usuario) {  //@ResquestBody = VALIDAÇÃO DE OBJETO
		return ResponseEntity.status(201).body(usuarioService.criarUsuario(usuario));
	}

	@PutMapping
	public ResponseEntity <Usuario> editarUsuario(@Valid @RequestBody Usuario usuario) {
		return ResponseEntity.status(200).body(usuarioService.editarUsuario(usuario));

	}

	@DeleteMapping("/{id}")
	public ResponseEntity <Optional <Usuario>> excluirUsuario(@PathVariable Integer id) {
		usuarioService.excluirUsuario(id);
		return ResponseEntity.status(204).build();   // build = NÃO DIZ O USUARIO EXCLUIDO
	}
	
	@PostMapping("/login")  // TESTE DE LOGIN, FAZ A VERIFICACAO COMPARANDO A SENHA SE ESTA CORRETA
	public ResponseEntity<Usuario> validSenha(@Valid @RequestBody Usuario usuario){
	Boolean valid = usuarioService.validarSenha(usuario);
	if(!valid) {
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	}
	return ResponseEntity.status(200).build();
	
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST) // DEIXANDO MAIS LIMPO A RESPOSTA DO BAD REQUEST
	@ExceptionHandler(MethodArgumentNotValidException.class) // VALIDATION
	public Map<String, String> handleValidationException(MethodArgumentNotValidException ex){
		Map<String, String> errors = new HashMap<>();
		
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}

}