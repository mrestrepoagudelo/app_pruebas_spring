package com.ceiba.biblioteca.libro.aplicacion.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.biblioteca.libro.aplicacion.service.interfaz.ILibroCreateHandler;
import com.ceiba.biblioteca.libro.domain.model.dto.LibroDto;
import com.ceiba.biblioteca.libro.domain.model.entity.Libro;
import com.ceiba.biblioteca.libro.domain.service.LibroCreateService;

@Component
public class LibroCreateHandler implements ILibroCreateHandler{
	
	@Autowired
	private ModelMapper modelMapper;
	
	private final LibroCreateService libroCreateService;
	
	@Autowired
	public LibroCreateHandler(LibroCreateService libroCreateService) {
		this.libroCreateService = libroCreateService;
	}

	@Override
	public LibroDto create(LibroDto libroDto) {
		Libro libro = modelMapper.map(libroDto, Libro.class);
		LibroDto libroCreated = modelMapper.map(libroCreateService.create(libro), LibroDto.class);
		return libroCreated;
	}
}
