package com.ceiba.biblioteca.prestamo.domain.service;

import com.ceiba.biblioteca.prestamo.domain.constant.MsgConstant;
import com.ceiba.biblioteca.prestamo.domain.exception.ModelException;
import com.ceiba.biblioteca.prestamo.domain.model.entity.Prestamo;
import com.ceiba.biblioteca.prestamo.domain.port.IPrestamoRepositoryPort;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PrestamoFindByIdService {
	private final IPrestamoRepositoryPort prestamoRepository;

	public PrestamoFindByIdService(IPrestamoRepositoryPort prestamoRepository) {
		this.prestamoRepository = prestamoRepository;
	}

	public Prestamo getById(Long id) {
		Prestamo oPrestamo = prestamoRepository.getById(id);
		if (oPrestamo == null) {
			log.error("getById - " + MsgConstant.MSG_REGISTRO_NO_ENCONTRADO);
			throw new ModelException(MsgConstant.MSG_REGISTRO_NO_ENCONTRADO);
		}
		return oPrestamo;
	}
}
