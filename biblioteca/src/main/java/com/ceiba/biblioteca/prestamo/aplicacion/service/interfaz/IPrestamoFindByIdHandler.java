package com.ceiba.biblioteca.prestamo.aplicacion.service.interfaz;

import com.ceiba.biblioteca.prestamo.domain.model.dto.PrestamoDto;

public interface IPrestamoFindByIdHandler {
	public PrestamoDto findById(Long id);
}