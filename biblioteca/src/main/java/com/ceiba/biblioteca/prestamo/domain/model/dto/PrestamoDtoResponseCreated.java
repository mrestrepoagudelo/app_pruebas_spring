package com.ceiba.biblioteca.prestamo.domain.model.dto;

import java.util.Date;

import lombok.Data;

@Data
public class PrestamoDtoResponseCreated {
	private Long id;
	private Date fechaMaximaDevolucion;
}
