package com.ceiba.biblioteca.libro.domain.service;

import com.ceiba.biblioteca.libro.domain.model.entity.Libro;
import com.ceiba.biblioteca.libro.domain.port.ILibroRepositoryPort;
import com.ceiba.biblioteca.usuario.domain.constant.MsgConstant;
import com.ceiba.biblioteca.usuario.domain.exception.ModelException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LibroFindByIdService {
	private final ILibroRepositoryPort libroRepository;

	public LibroFindByIdService(ILibroRepositoryPort libroRepository) {
		this.libroRepository = libroRepository;
	}

	public Libro getById(Long id) {
		Libro oLibro = libroRepository.getById(id);
		if (oLibro == null) {
			log.error("getById - " + MsgConstant.MSG_REGISTRO_NO_ENCONTRADO);
			throw new ModelException(MsgConstant.MSG_REGISTRO_NO_ENCONTRADO);
		}
		return oLibro;
	}
}
