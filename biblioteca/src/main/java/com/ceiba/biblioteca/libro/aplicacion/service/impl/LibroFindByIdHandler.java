package com.ceiba.biblioteca.libro.aplicacion.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.biblioteca.libro.aplicacion.service.interfaz.ILibroFindByIdHandler;
import com.ceiba.biblioteca.libro.domain.model.dto.LibroDto;
import com.ceiba.biblioteca.libro.domain.model.entity.Libro;
import com.ceiba.biblioteca.libro.domain.service.LibroFindByIdService;

@Component
public class LibroFindByIdHandler implements ILibroFindByIdHandler{
	
	@Autowired
	private ModelMapper modelMapper;
	
	private final LibroFindByIdService libroFindByIdService;

	public LibroFindByIdHandler(LibroFindByIdService usuarioService) {
		this.libroFindByIdService = usuarioService;
	}
	
	@Override
	public LibroDto findById(Long id) {
		Libro libro = libroFindByIdService.getById(id);
		LibroDto libroDto = modelMapper.map(libro, LibroDto.class);
		return libroDto;
	}
}
