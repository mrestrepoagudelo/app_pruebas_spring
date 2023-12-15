package com.ceiba.biblioteca.usuario.aplicacion.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.biblioteca.usuario.aplicacion.service.interfaz.IUsuarioFindAllHandler;
import com.ceiba.biblioteca.usuario.domain.model.dto.UsuarioDto;
import com.ceiba.biblioteca.usuario.domain.model.entity.Usuario;
import com.ceiba.biblioteca.usuario.domain.service.UsuarioFindAllService;

@Component
public class UsuarioFindAllHandler implements IUsuarioFindAllHandler{
	
	@Autowired
	private ModelMapper modelMapper;
	
	private final UsuarioFindAllService usuarioFindAllService;

	public UsuarioFindAllHandler(UsuarioFindAllService usuarioFindAllService) {
		this.usuarioFindAllService = usuarioFindAllService;
	}
	
	@Override
	public List<UsuarioDto> findAll() {
		List<Usuario> listaUsuarios = usuarioFindAllService.getAll();
		List<UsuarioDto> listaUsuarioDto = modelMapper.map(listaUsuarios,
				new TypeToken<List<UsuarioDto>>() {}.getType());
		
		return listaUsuarioDto;
	}
}
