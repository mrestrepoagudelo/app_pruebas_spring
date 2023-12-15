package com.ceiba.biblioteca.biblioteca.aplicacion.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.biblioteca.biblioteca.aplicacion.service.interfaz.IBibliotecaFindByIdHandler;
import com.ceiba.biblioteca.biblioteca.domain.model.dto.BibliotecaDto;
import com.ceiba.biblioteca.biblioteca.domain.model.entity.Biblioteca;
import com.ceiba.biblioteca.biblioteca.domain.service.BibliotecaFindByIdService;

@Component
public class BibliotecaFindByIdHandler implements IBibliotecaFindByIdHandler{
	
	@Autowired
	private ModelMapper modelMapper;
	
	private final BibliotecaFindByIdService bibliotecaFindByIdService;

	public BibliotecaFindByIdHandler(BibliotecaFindByIdService bibliotecaFindByIdService) {
		this.bibliotecaFindByIdService = bibliotecaFindByIdService;
	}
	
	@Override
	public BibliotecaDto findById(Long id) {
		Biblioteca biblioteca = bibliotecaFindByIdService.getById(id);
		BibliotecaDto bibliotecaDto = modelMapper.map(biblioteca, BibliotecaDto.class);
		return bibliotecaDto;
	}
}
