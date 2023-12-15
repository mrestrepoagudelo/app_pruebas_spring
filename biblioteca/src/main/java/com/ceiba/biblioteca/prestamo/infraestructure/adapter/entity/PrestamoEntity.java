package com.ceiba.biblioteca.prestamo.infraestructure.adapter.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "prestamo")
public class PrestamoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPrestamo;
	
	@Column(name = "id_usuario")
	private Long idUsuario;
	
	@Column(name = "id_libro")
	private String idLibro;

	@Column(name = "fecha_prestamo")
	private Date fechaPrestamo;

	@Column(name = "fecha_maxima_devolucion")
	private Date fechaMaximaDevolucion;
}
