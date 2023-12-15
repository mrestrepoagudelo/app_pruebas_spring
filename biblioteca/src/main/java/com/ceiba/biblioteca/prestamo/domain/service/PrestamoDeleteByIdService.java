package com.ceiba.biblioteca.prestamo.domain.service;

import com.ceiba.biblioteca.prestamo.domain.constant.MsgConstant;
import com.ceiba.biblioteca.prestamo.domain.exception.ModelException;
import com.ceiba.biblioteca.prestamo.domain.model.entity.Prestamo;
import com.ceiba.biblioteca.prestamo.domain.port.IPrestamoRepositoryPort;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PrestamoDeleteByIdService {
	private final IPrestamoRepositoryPort prestamoRepository;

	public PrestamoDeleteByIdService(IPrestamoRepositoryPort prestamoRepository) {
		this.prestamoRepository = prestamoRepository;
	}

	public void deleteById(Long id) {
		Prestamo oPrestamo = prestamoRepository.getById(id);
		if (oPrestamo == null) {
			log.error("deleteById -" + MsgConstant.MSG_REGISTRO_NO_ENCONTRADO);
			throw new ModelException(MsgConstant.MSG_REGISTRO_NO_ENCONTRADO_DELETE);
		}
		prestamoRepository.deleteById(id);
	}
}
