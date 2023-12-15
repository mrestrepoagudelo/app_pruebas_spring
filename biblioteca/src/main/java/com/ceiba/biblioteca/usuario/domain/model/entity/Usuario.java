package com.ceiba.biblioteca.usuario.domain.model.entity;

import lombok.Data;

@Data
public class Usuario {
	private Long idUsuario;
	private Long idTipoUsuario;
	private Long idTipoIdentificacion;
	private String numeroIdentificacion;
	private String nombres;
	private String apellidos;
	private String numeroCelular;
	private String email;
}
