package com.ceiba.biblioteca.biblioteca.domain.model.entity;

import lombok.Data;

@Data
public class Biblioteca {
	private Long idBiblioteca;
	private String nombre;
	private String direccion;
	private String telefono;
	private String email;
}
