package com.ceiba.biblioteca.usuario.domain.service;

import com.ceiba.biblioteca.usuario.domain.model.entity.Usuario;
import com.ceiba.biblioteca.usuario.domain.port.IUsuarioRepositoryPort;

public class UsuarioCreateService {
	private final IUsuarioRepositoryPort usuarioRepository;

	public UsuarioCreateService(IUsuarioRepositoryPort usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public Usuario create(Usuario oUsuario) {
		return usuarioRepository.create(oUsuario);
	}
}
