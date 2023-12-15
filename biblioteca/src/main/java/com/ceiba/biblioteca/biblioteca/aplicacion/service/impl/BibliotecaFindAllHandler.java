package com.ceiba.biblioteca.biblioteca.aplicacion.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.biblioteca.biblioteca.aplicacion.service.interfaz.IBibliotecaFindAllHandler;
import com.ceiba.biblioteca.biblioteca.domain.model.dto.BibliotecaDto;
import com.ceiba.biblioteca.biblioteca.domain.model.entity.Biblioteca;
import com.ceiba.biblioteca.biblioteca.domain.service.BibliotecaFindAllService;

@Component
public class BibliotecaFindAllHandler implements IBibliotecaFindAllHandler{
	
	@Autowired
	private ModelMapper modelMapper;
	
	private final BibliotecaFindAllService bibliotecaFindAllService;

	public BibliotecaFindAllHandler(BibliotecaFindAllService bibliotecaFindAllService) {
		this.bibliotecaFindAllService = bibliotecaFindAllService;
	}
	
	@Override
	public List<BibliotecaDto> findAll() {
		List<Biblioteca> listaBibliotecas = bibliotecaFindAllService.getAll();
		List<BibliotecaDto> listaBibliotecaDto = modelMapper.map(listaBibliotecas,
				new TypeToken<List<BibliotecaDto>>() {}.getType());
		
		return listaBibliotecaDto;
	}
}
