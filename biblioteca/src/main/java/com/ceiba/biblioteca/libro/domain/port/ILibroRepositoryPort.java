package com.ceiba.biblioteca.libro.domain.port;

import java.util.List;

import com.ceiba.biblioteca.libro.domain.model.entity.Libro;

public interface ILibroRepositoryPort {
	public Libro create(Libro persona);
	public Libro getById(Long id);
	public List<Libro> getAll();
	public void deleteById(Long id);
}
