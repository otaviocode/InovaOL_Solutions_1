package com.manager.task.service;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.task.dto.UsuarioDTO;
import com.manager.task.model.Usuario;
import com.manager.task.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario salvarUsuario(UsuarioDTO dto) {
		Usuario usuario = new Usuario();

		// outros campos...
		usuario.setNomeCompleto(dto.getNomeCompleto());
		usuario.setEmail(dto.getEmail());
		usuario.setLoginUsuario(dto.getLoginUsuario());
		usuario.setSenha(dto.getSenha());
		usuario.setTelefone(dto.getTelefone());
		usuario.setDataNascimento(dto.getDataNascimento());
		usuario.setCep(dto.getCep());
		usuario.setEndereco(dto.getEndereco());
		usuario.setNumeroResidencia(dto.getNumeroResidencia());
		usuario.setComplemento(dto.getComplemento());
		usuario.setBairro(dto.getBairro());
		usuario.setCidade(dto.getCidade());
		usuario.setEstado(dto.getEstado());

		// ⚠️ Aqui convertemos a imagem
		if (dto.getFotoPerfilBase64() != null && !dto.getFotoPerfilBase64().isEmpty()) {
			byte[] fotoBytes = Base64.getDecoder().decode(dto.getFotoPerfilBase64());
			usuario.setFotoPerfil(fotoBytes);
		}

		return usuarioRepository.save(usuario);
	}

}
