package com.ceiba.biblioteca.libro.infraestructure.adapter.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "libro")
public class LibroEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLibro;
	
	@Column(name = "isbn")
	private String isbn;
	
	@Column(name = "id_genero_libro")
	private Long idGeneroLibro;
	
	@Column(name = "nombre")
	private String nombre;

	@Column(name = "descripcion")
	private String descripcion;

}
