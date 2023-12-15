package com.ceiba.biblioteca.biblioteca.aplicacion.service.interfaz;

import com.ceiba.biblioteca.biblioteca.domain.model.dto.BibliotecaDto;

public interface IBibliotecaFindByIdHandler {
	public BibliotecaDto findById(Long id);
}