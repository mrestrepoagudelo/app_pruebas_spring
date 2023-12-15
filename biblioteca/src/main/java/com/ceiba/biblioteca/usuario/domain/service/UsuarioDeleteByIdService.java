package com.ceiba.biblioteca.usuario.domain.service;

import com.ceiba.biblioteca.usuario.domain.constant.MsgConstant;
import com.ceiba.biblioteca.usuario.domain.exception.ModelException;
import com.ceiba.biblioteca.usuario.domain.model.entity.Usuario;
import com.ceiba.biblioteca.usuario.domain.port.IUsuarioRepositoryPort;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UsuarioDeleteByIdService {
	private final IUsuarioRepositoryPort usuarioRepository;

	public UsuarioDeleteByIdService(IUsuarioRepositoryPort usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public void deleteById(Long id) {
		Usuario oUsuario = usuarioRepository.getById(id);
		if (oUsuario == null) {
			log.error("deleteById -" + MsgConstant.MSG_REGISTRO_NO_ENCONTRADO);
			throw new ModelException(MsgConstant.MSG_REGISTRO_NO_ENCONTRADO_DELETE);
		}
		usuarioRepository.deleteById(id);
	}
}
