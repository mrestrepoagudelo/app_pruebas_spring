package com.ceiba.biblioteca.biblioteca.aplicacion.service.impl;

import org.springframework.stereotype.Component;

import com.ceiba.biblioteca.biblioteca.aplicacion.service.interfaz.IBibliotecaDeleteByIdHandler;
import com.ceiba.biblioteca.biblioteca.domain.service.BibliotecaDeleteByIdService;

@Component
public class BibliotecaDeleteByIdHandler implements IBibliotecaDeleteByIdHandler{

	private final BibliotecaDeleteByIdService bibliotecaDeleteByIdService;

	public BibliotecaDeleteByIdHandler(BibliotecaDeleteByIdService bibliotecaDeleteByIdService) {
		this.bibliotecaDeleteByIdService = bibliotecaDeleteByIdService;
	}
	
	@Override
	public void deleteById(Long id) {
		bibliotecaDeleteByIdService.deleteById(id);
	}
}
