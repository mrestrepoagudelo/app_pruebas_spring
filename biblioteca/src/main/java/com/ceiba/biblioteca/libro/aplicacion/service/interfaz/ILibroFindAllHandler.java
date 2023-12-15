package com.ceiba.biblioteca.libro.aplicacion.service.interfaz;

import java.util.List;

import com.ceiba.biblioteca.libro.domain.model.dto.LibroDto;

public interface ILibroFindAllHandler {
	public List<LibroDto> findAll();
}