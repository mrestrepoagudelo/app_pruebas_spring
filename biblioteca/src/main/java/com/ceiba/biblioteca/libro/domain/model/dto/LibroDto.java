package com.ceiba.biblioteca.libro.domain.model.dto;

import lombok.Data;

@Data
public class LibroDto {
	private Long idLibro;
	private String isbn;
	private Long idGeneroLibro;
	private String nombre;
	private String descripcion;
}
