package com.ceiba.biblioteca.usuario.aplicacion.service.interfaz;

import com.ceiba.biblioteca.usuario.domain.model.dto.UsuarioDto;

public interface IUsuarioFindByIdHandler {
	public UsuarioDto findById(Long id);
}