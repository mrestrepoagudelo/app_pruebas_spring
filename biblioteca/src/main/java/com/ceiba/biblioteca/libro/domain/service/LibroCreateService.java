package com.ceiba.biblioteca.libro.domain.service;

import com.ceiba.biblioteca.libro.domain.model.entity.Libro;
import com.ceiba.biblioteca.libro.domain.port.ILibroRepositoryPort;

public class LibroCreateService {
	private final ILibroRepositoryPort libroRepository;

	public LibroCreateService(ILibroRepositoryPort libroRepository) {
		this.libroRepository = libroRepository;
	}

	public Libro create(Libro oLibro) {
		return libroRepository.create(oLibro);
	}
}
