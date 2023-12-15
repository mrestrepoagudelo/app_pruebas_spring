package com.ceiba.biblioteca.biblioteca.domain.service;

import java.util.List;

import com.ceiba.biblioteca.biblioteca.domain.model.entity.Biblioteca;
import com.ceiba.biblioteca.biblioteca.domain.port.IBibliotecaRepositoryPort;

public class BibliotecaFindAllService {
	private final IBibliotecaRepositoryPort bibliotecaRepository;

	public BibliotecaFindAllService(IBibliotecaRepositoryPort bibliotecaRepository) {
		this.bibliotecaRepository = bibliotecaRepository;
	}

	public List<Biblioteca> getAll() {
		return bibliotecaRepository.getAll();
	}
}
