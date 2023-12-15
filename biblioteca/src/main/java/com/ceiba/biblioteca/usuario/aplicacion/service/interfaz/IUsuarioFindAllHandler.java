package com.ceiba.biblioteca.usuario.aplicacion.service.interfaz;

import java.util.List;

import com.ceiba.biblioteca.usuario.domain.model.dto.UsuarioDto;

public interface IUsuarioFindAllHandler {
	public List<UsuarioDto> findAll();
}