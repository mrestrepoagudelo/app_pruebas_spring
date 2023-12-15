package com.ceiba.biblioteca.libro.domain.model.entity;

import lombok.Data;

@Data
public class Libro {
	private Long idLibro;
	private String isbn;
	private Long idGeneroLibro;
	private String nombre;
	private String descripcion;
}
