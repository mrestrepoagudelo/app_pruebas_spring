package com.ceiba.biblioteca.biblioteca.domain.service;

import com.ceiba.biblioteca.biblioteca.domain.model.entity.Biblioteca;
import com.ceiba.biblioteca.biblioteca.domain.port.IBibliotecaRepositoryPort;
import com.ceiba.biblioteca.usuario.domain.constant.MsgConstant;
import com.ceiba.biblioteca.usuario.domain.exception.ModelException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BibliotecaFindByIdService {
	private final IBibliotecaRepositoryPort bibliotecaRepository;

	public BibliotecaFindByIdService(IBibliotecaRepositoryPort bibliotecaRepository) {
		this.bibliotecaRepository = bibliotecaRepository;
	}

	public Biblioteca getById(Long id) {
		Biblioteca oBiblioteca = bibliotecaRepository.getById(id);
		if (oBiblioteca == null) {
			log.error("getById - " + MsgConstant.MSG_REGISTRO_NO_ENCONTRADO);
			throw new ModelException(MsgConstant.MSG_REGISTRO_NO_ENCONTRADO);
		}
		return oBiblioteca;
	}
}
