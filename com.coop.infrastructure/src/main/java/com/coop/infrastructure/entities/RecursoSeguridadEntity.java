package com.coop.infrastructure.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "recursoSeguridad")
public class RecursoSeguridadEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRecursoSeguridad;

  	@Column(name="nombre_recurso")
	private String nombreRecurso;

  	@Column(name="control")
	private String control;

	public RecursoSeguridadEntity (Long idRecursoSeguridad, String nombreRecurso, String control){
		this.idRecursoSeguridad = idRecursoSeguridad;
		this.nombreRecurso = nombreRecurso;
		this.control = control;
	}
  
	public RecursoSeguridadEntity() {
		// TODO Auto-generated constructor stub
	}

	public Long getIdRecursoSeguridad() {
		return idRecursoSeguridad;
	}
	
	public void setIdRecursoSeguridad(Long idRecursoSeguridad) {
		this.idRecursoSeguridad = idRecursoSeguridad;
	}

	public String getNombreRecurso() {
		return nombreRecurso;
	}
	
	public void setNombreRecurso(String nombreRecurso) {
		this.nombreRecurso = nombreRecurso;
	}

	public String getControl() {
		return control;
	}
	
	public void setControl(String control) {
		this.control = control;
	}
	private static final long serialVersionUID = 1L;
}
