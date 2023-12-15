package com.ceiba.biblioteca.usuario.aplicacion.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.biblioteca.usuario.aplicacion.service.interfaz.IUsuarioFindByIdHandler;
import com.ceiba.biblioteca.usuario.domain.model.dto.UsuarioDto;
import com.ceiba.biblioteca.usuario.domain.model.entity.Usuario;
import com.ceiba.biblioteca.usuario.domain.service.UsuarioFindByIdService;

@Component
public class UsuarioFindByIdHandler implements IUsuarioFindByIdHandler{
	
	@Autowired
	private ModelMapper modelMapper;
	
	private final UsuarioFindByIdService usuarioFindByIdService;

	public UsuarioFindByIdHandler(UsuarioFindByIdService usuarioService) {
		this.usuarioFindByIdService = usuarioService;
	}
	
	@Override
	public UsuarioDto findById(Long id) {
		Usuario usuario = usuarioFindByIdService.getById(id);
		UsuarioDto usuarioDto = modelMapper.map(usuario, UsuarioDto.class);
		return usuarioDto;
	}
}
