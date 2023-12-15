package com.ceiba.biblioteca.libro.aplicacion.service.interfaz;

import com.ceiba.biblioteca.libro.domain.model.dto.LibroDto;

public interface ILibroCreateHandler {
	public LibroDto create(LibroDto usuarioDto);
}