package com.ceiba.biblioteca.usuario.aplicacion.service.interfaz;

import com.ceiba.biblioteca.usuario.domain.model.dto.UsuarioDto;

public interface IUsuarioCreateHandler {
	public UsuarioDto create(UsuarioDto usuarioDto);
}