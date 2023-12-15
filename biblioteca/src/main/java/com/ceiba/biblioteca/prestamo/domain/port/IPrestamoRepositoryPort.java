package com.ceiba.biblioteca.prestamo.domain.port;

import java.util.List;

import com.ceiba.biblioteca.prestamo.domain.model.entity.Prestamo;

public interface IPrestamoRepositoryPort {
	public Prestamo create(Prestamo persona);
	public Prestamo getById(Long id);
	public List<Prestamo> getAll();
	public void deleteById(Long id);
}
