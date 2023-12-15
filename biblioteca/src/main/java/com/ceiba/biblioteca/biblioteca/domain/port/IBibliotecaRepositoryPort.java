package com.ceiba.biblioteca.biblioteca.domain.port;

import java.util.List;

import com.ceiba.biblioteca.biblioteca.domain.model.entity.Biblioteca;

public interface IBibliotecaRepositoryPort {
	public Biblioteca create(Biblioteca persona);
	public Biblioteca getById(Long id);
	public List<Biblioteca> getAll();
	public void deleteById(Long id);
}
