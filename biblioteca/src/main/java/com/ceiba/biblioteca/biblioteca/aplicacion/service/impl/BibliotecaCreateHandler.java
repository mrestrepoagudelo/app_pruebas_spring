package com.ceiba.biblioteca.biblioteca.aplicacion.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.biblioteca.biblioteca.aplicacion.service.interfaz.IBibliotecaCreateHandler;
import com.ceiba.biblioteca.biblioteca.domain.model.dto.BibliotecaDto;
import com.ceiba.biblioteca.biblioteca.domain.model.entity.Biblioteca;
import com.ceiba.biblioteca.biblioteca.domain.service.BibliotecaCreateService;

@Component
public class BibliotecaCreateHandler implements IBibliotecaCreateHandler{
	
	@Autowired
	private ModelMapper modelMapper;
	
	private final BibliotecaCreateService bibliotecaCreateService;
	
	@Autowired
	public BibliotecaCreateHandler(BibliotecaCreateService BibliotecaCreateService) {
		this.bibliotecaCreateService = BibliotecaCreateService;
	}

	@Override
	public BibliotecaDto create(BibliotecaDto bibliotecaDto) {
		Biblioteca biblioteca = modelMapper.map(bibliotecaDto, Biblioteca.class);
		BibliotecaDto bibliotecaDtoCreated = modelMapper.map(bibliotecaCreateService.create(biblioteca), BibliotecaDto.class);
		return bibliotecaDtoCreated;
	}
}
