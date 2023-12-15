package com.ceiba.biblioteca.prestamo.aplicacion.service.interfaz;

import java.util.List;

import com.ceiba.biblioteca.prestamo.domain.model.dto.PrestamoDto;

public interface IPrestamoFindAllHandler {
	public List<PrestamoDto> findAll();
}