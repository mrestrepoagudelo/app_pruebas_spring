package com.ceiba.biblioteca.prestamo.aplicacion.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.biblioteca.prestamo.aplicacion.service.interfaz.IPrestamoFindAllHandler;
import com.ceiba.biblioteca.prestamo.domain.model.dto.PrestamoDto;
import com.ceiba.biblioteca.prestamo.domain.model.entity.Prestamo;
import com.ceiba.biblioteca.prestamo.domain.service.PrestamoFindAllService;

@Component
public class PrestamoFindAllHandler implements IPrestamoFindAllHandler{
	
	@Autowired
	private ModelMapper modelMapper;
	
	private final PrestamoFindAllService prestamoFindAllService;

	public PrestamoFindAllHandler(PrestamoFindAllService prestamoFindAllService) {
		this.prestamoFindAllService = prestamoFindAllService;
	}
	
	@Override
	public List<PrestamoDto> findAll() {
		List<Prestamo> listaPrestamos = prestamoFindAllService.getAll();
		List<PrestamoDto> listaPrestamoDto = modelMapper.map(listaPrestamos,
				new TypeToken<List<PrestamoDto>>() {}.getType());
		
		return listaPrestamoDto;
	}
}
