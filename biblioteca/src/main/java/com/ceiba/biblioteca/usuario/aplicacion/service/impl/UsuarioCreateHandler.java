package com.ceiba.biblioteca.usuario.aplicacion.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.biblioteca.usuario.aplicacion.service.interfaz.IUsuarioCreateHandler;
import com.ceiba.biblioteca.usuario.domain.model.dto.UsuarioDto;
import com.ceiba.biblioteca.usuario.domain.model.entity.Usuario;
import com.ceiba.biblioteca.usuario.domain.service.UsuarioCreateService;

@Component
public class UsuarioCreateHandler implements IUsuarioCreateHandler{
	
	@Autowired
	private ModelMapper modelMapper;
	
	private final UsuarioCreateService usuarioCreateService;
	
	@Autowired
	public UsuarioCreateHandler(UsuarioCreateService usuarioCreateService) {
		this.usuarioCreateService = usuarioCreateService;
	}

	@Override
	public UsuarioDto create(UsuarioDto usuarioDto) {
		Usuario usuario = modelMapper.map(usuarioDto, Usuario.class);
		UsuarioDto usuarioDtoCreated = modelMapper.map(usuarioCreateService.create(usuario), UsuarioDto.class);
		return usuarioDtoCreated;
	}
}
