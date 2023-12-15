package com.ceiba.biblioteca.libro.aplicacion.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.biblioteca.libro.aplicacion.service.interfaz.ILibroFindAllHandler;
import com.ceiba.biblioteca.libro.domain.model.dto.LibroDto;
import com.ceiba.biblioteca.libro.domain.model.entity.Libro;
import com.ceiba.biblioteca.libro.domain.service.LibroFindAllService;

@Component
public class LibroFindAllHandler implements ILibroFindAllHandler{
	
	@Autowired
	private ModelMapper modelMapper;
	
	private final LibroFindAllService libroFindAllService;

	public LibroFindAllHandler(LibroFindAllService libroFindAllService) {
		this.libroFindAllService = libroFindAllService;
	}
	
	@Override
	public List<LibroDto> findAll() {
		List<Libro> listaLibros = libroFindAllService.getAll();
		List<LibroDto> listaLibroDto = modelMapper.map(listaLibros,
				new TypeToken<List<LibroDto>>() {}.getType());
		
		return listaLibroDto;
	}
}
