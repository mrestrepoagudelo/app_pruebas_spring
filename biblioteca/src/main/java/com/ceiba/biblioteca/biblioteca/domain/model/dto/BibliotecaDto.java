package com.ceiba.biblioteca.biblioteca.domain.model.dto;

import lombok.Data;

@Data
public class BibliotecaDto {
	private Long idBiblioteca;
	private String nombre;
	private String direccion;
	private String telefono;
	private String email;
}
