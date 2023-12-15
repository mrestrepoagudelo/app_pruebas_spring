package com.ceiba.biblioteca.usuario.domain.service;

import java.util.List;

import com.ceiba.biblioteca.usuario.domain.model.entity.Usuario;
import com.ceiba.biblioteca.usuario.domain.port.IUsuarioRepositoryPort;

public class UsuarioFindAllService {
	private final IUsuarioRepositoryPort usuarioRepository;

	public UsuarioFindAllService(IUsuarioRepositoryPort usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public List<Usuario> getAll() {
		return usuarioRepository.getAll();
	}
}
