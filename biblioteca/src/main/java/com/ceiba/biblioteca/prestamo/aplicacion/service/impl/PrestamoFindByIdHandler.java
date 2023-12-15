package com.ceiba.biblioteca.prestamo.aplicacion.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.biblioteca.prestamo.aplicacion.service.interfaz.IPrestamoFindByIdHandler;
import com.ceiba.biblioteca.prestamo.domain.model.dto.PrestamoDto;
import com.ceiba.biblioteca.prestamo.domain.model.entity.Prestamo;
import com.ceiba.biblioteca.prestamo.domain.service.PrestamoFindByIdService;

@Component
public class PrestamoFindByIdHandler implements IPrestamoFindByIdHandler{
	
	@Autowired
	private ModelMapper modelMapper;
	
	private final PrestamoFindByIdService prestamoFindByIdService;

	public PrestamoFindByIdHandler(PrestamoFindByIdService prestamoFindByIdService) {
		this.prestamoFindByIdService = prestamoFindByIdService;
	}
	
	@Override
	public PrestamoDto findById(Long id) {
		Prestamo prestamo = prestamoFindByIdService.getById(id);
		PrestamoDto prestamoDto = modelMapper.map(prestamo, PrestamoDto.class);
		return prestamoDto;
	}
}
