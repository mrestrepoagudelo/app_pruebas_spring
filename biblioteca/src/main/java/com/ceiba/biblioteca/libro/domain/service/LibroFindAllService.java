package com.ceiba.biblioteca.libro.domain.service;

import java.util.List;

import com.ceiba.biblioteca.libro.domain.model.entity.Libro;
import com.ceiba.biblioteca.libro.domain.port.ILibroRepositoryPort;

public class LibroFindAllService {
	private final ILibroRepositoryPort libroRepository;

	public LibroFindAllService(ILibroRepositoryPort libroRepository) {
		this.libroRepository = libroRepository;
	}

	public List<Libro> getAll() {
		return libroRepository.getAll();
	}
}
