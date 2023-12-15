package com.ceiba.biblioteca.prestamo.aplicacion.service.impl;

import org.springframework.stereotype.Component;

import com.ceiba.biblioteca.prestamo.aplicacion.service.interfaz.IPrestamoCreateHandler;
import com.ceiba.biblioteca.prestamo.aplicacion.service.mapper.PrestamoDtoMapper;
import com.ceiba.biblioteca.prestamo.domain.model.dto.PrestamoDto;
import com.ceiba.biblioteca.prestamo.domain.model.dto.PrestamoDtoResponseCreated;
import com.ceiba.biblioteca.prestamo.domain.model.entity.Prestamo;
import com.ceiba.biblioteca.prestamo.domain.service.PrestamoCreateService;

@Component
public class PrestamoCreateHandler implements IPrestamoCreateHandler{
	
	private final PrestamoDtoMapper prestamoDtoMapper;
	private final PrestamoCreateService prestamoCreateService;
	
	public PrestamoCreateHandler(PrestamoCreateService prestamoCreateService, PrestamoDtoMapper prestamoDtoMapper) {
		this.prestamoCreateService = prestamoCreateService;
		this.prestamoDtoMapper = prestamoDtoMapper;
	}

	@Override
	public PrestamoDtoResponseCreated create(PrestamoDto prestamoDto) {
		Prestamo prestamo = prestamoDtoMapper.toDomain(prestamoDto);
		PrestamoDtoResponseCreated prestamoDtoCreated = prestamoDtoMapper.toDtoResponseCreated(prestamoCreateService.create(prestamo));
		return prestamoDtoCreated;
	}
}
