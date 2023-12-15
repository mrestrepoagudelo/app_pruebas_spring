package com.ceiba.biblioteca.biblioteca.domain.service;

import com.ceiba.biblioteca.biblioteca.domain.model.entity.Biblioteca;
import com.ceiba.biblioteca.biblioteca.domain.port.IBibliotecaRepositoryPort;

public class BibliotecaCreateService {
	private final IBibliotecaRepositoryPort bibliotecaRepository;

	public BibliotecaCreateService(IBibliotecaRepositoryPort bibliotecaRepository) {
		this.bibliotecaRepository = bibliotecaRepository;
	}

	public Biblioteca create(Biblioteca oPersona) {
		return bibliotecaRepository.create(oPersona);
	}
}
