package com.ceiba.biblioteca.usuario.aplicacion.service.impl;

import org.springframework.stereotype.Component;

import com.ceiba.biblioteca.usuario.aplicacion.service.interfaz.IUsuarioDeleteByIdHandler;
import com.ceiba.biblioteca.usuario.domain.service.UsuarioDeleteByIdService;

@Component
public class UsuarioDeleteByIdHandler implements IUsuarioDeleteByIdHandler{

	private final UsuarioDeleteByIdService usuarioDeleteByIdService;

	public UsuarioDeleteByIdHandler(UsuarioDeleteByIdService usuarioDeleteByIdService) {
		this.usuarioDeleteByIdService = usuarioDeleteByIdService;
	}
	
	@Override
	public void deleteById(Long id) {
		usuarioDeleteByIdService.deleteById(id);
	}
}
