package com.ceiba.biblioteca.libro.domain.service;

import com.ceiba.biblioteca.libro.domain.model.entity.Libro;
import com.ceiba.biblioteca.libro.domain.port.ILibroRepositoryPort;
import com.ceiba.biblioteca.usuario.domain.constant.MsgConstant;
import com.ceiba.biblioteca.usuario.domain.exception.ModelException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LibroDeleteByIdService {
	private final ILibroRepositoryPort libroRepository;

	public LibroDeleteByIdService(ILibroRepositoryPort libroRepository) {
		this.libroRepository = libroRepository;
	}

	public void deleteById(Long id) {
		Libro oLibro = libroRepository.getById(id);
		if (oLibro == null) {
			log.error("deleteById -" + MsgConstant.MSG_REGISTRO_NO_ENCONTRADO);
			throw new ModelException(MsgConstant.MSG_REGISTRO_NO_ENCONTRADO_DELETE);
		}
		libroRepository.deleteById(id);
	}
}
