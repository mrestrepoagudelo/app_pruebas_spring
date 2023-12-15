package com.ceiba.biblioteca.biblioteca.aplicacion.service.interfaz;

import java.util.List;

import com.ceiba.biblioteca.biblioteca.domain.model.dto.BibliotecaDto;

public interface IBibliotecaFindAllHandler {
	public List<BibliotecaDto> findAll();
}