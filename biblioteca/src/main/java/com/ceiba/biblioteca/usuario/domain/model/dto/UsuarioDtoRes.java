package com.ceiba.biblioteca.usuario.domain.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UsuarioDtoRes {
	private Long idUsuario;
	private String nombres;
	private String descripcion;
}
