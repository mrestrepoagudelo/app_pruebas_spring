package com.ceiba.biblioteca.libro.aplicacion.service.impl;

import org.springframework.stereotype.Component;

import com.ceiba.biblioteca.libro.aplicacion.service.interfaz.ILibroDeleteByIdHandler;
import com.ceiba.biblioteca.libro.domain.service.LibroDeleteByIdService;

@Component
public class LibroDeleteByIdHandler implements ILibroDeleteByIdHandler{

	private final LibroDeleteByIdService libroDeleteByIdService;

	public LibroDeleteByIdHandler(LibroDeleteByIdService libroDeleteByIdService) {
		this.libroDeleteByIdService = libroDeleteByIdService;
	}
	
	@Override
	public void deleteById(Long id) {
		libroDeleteByIdService.deleteById(id);
	}
}
