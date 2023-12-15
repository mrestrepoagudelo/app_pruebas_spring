package com.ceiba.biblioteca.prestamo.aplicacion.service.impl;

import org.springframework.stereotype.Component;

import com.ceiba.biblioteca.prestamo.aplicacion.service.interfaz.IPrestamoDeleteByIdHandler;
import com.ceiba.biblioteca.prestamo.domain.service.PrestamoDeleteByIdService;

@Component
public class PrestamoDeleteByIdHandler implements IPrestamoDeleteByIdHandler{

	private final PrestamoDeleteByIdService prestamoDeleteByIdService;

	public PrestamoDeleteByIdHandler(PrestamoDeleteByIdService prestamoDeleteByIdService) {
		this.prestamoDeleteByIdService = prestamoDeleteByIdService;
	}
	
	@Override
	public void deleteById(Long id) {
		prestamoDeleteByIdService.deleteById(id);
	}
}
