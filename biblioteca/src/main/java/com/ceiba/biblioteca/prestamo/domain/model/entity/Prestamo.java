package com.ceiba.biblioteca.prestamo.domain.model.entity;

import java.util.Date;

import lombok.Data;

@Data
public class Prestamo {
	private Long idPrestamo;
	private Long idUsuario;
	private Long idLibro;
	private Date fechaPrestamo;
	private Date fechaMaximaDevolucion;
}
