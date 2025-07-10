package com.manager.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manager.task.dto.UsuarioDTO;
import com.manager.task.model.Usuario;
import com.manager.task.service.UsuarioService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@PostMapping
	public ResponseEntity<Usuario> salvarUsuario(@RequestBody UsuarioDTO dto) {
		Usuario salvo = usuarioService.salvarUsuario(dto);
		return ResponseEntity.ok(salvo);
	}

}
