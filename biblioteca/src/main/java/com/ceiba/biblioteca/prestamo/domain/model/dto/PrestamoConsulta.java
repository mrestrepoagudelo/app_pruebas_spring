package com.ceiba.biblioteca.prestamo.domain.model.dto;

import java.util.Date;

import lombok.Value;

@Value
public class PrestamoConsulta {
	private Long idPrestamo;
	private Long idUsuario;
	private String idLibro;
	private Date fechaPrestamo;
	private Date fechaMaximaDevolucion;
	private Long idTipoUsuario;
	private Long numeroIdentificacion;
}
