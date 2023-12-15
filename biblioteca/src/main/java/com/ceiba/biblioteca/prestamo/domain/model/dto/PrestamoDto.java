package com.ceiba.biblioteca.prestamo.domain.model.dto;

import java.util.Date;

import lombok.Data;

@Data
public class PrestamoDto {
	private Long idPrestamo;
	private Long idUsuario;
	private String idLibro;
	private Date fechaPrestamo;
	private Date fechaMaximaDevolucion;
}
