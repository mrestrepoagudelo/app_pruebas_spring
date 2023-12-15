package com.ceiba.biblioteca.prestamo.aplicacion.service.interfaz;

import com.ceiba.biblioteca.prestamo.domain.model.dto.PrestamoDto;
import com.ceiba.biblioteca.prestamo.domain.model.dto.PrestamoDtoResponseCreated;

public interface IPrestamoCreateHandler {
	public PrestamoDtoResponseCreated create(PrestamoDto prestamoDto);
}