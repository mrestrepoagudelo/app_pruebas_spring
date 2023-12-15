package com.ceiba.biblioteca.prestamo.domain.service;

import java.util.List;

import com.ceiba.biblioteca.prestamo.domain.model.entity.Prestamo;
import com.ceiba.biblioteca.prestamo.domain.port.IPrestamoRepositoryPort;

public class PrestamoFindAllService {
	private final IPrestamoRepositoryPort prestamoRepository;

	public PrestamoFindAllService(IPrestamoRepositoryPort prestamoRepository) {
		this.prestamoRepository = prestamoRepository;
	}

	public List<Prestamo> getAll() {
		return prestamoRepository.getAll();
	}
}
