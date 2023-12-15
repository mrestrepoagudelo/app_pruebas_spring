package com.coop.domain.dto;

public class RecursoSeguridad {
	private Long idRecursoSeguridad;
	private String nombreRecurso;
	private String control;

	public RecursoSeguridad (Long idRecursoSeguridad, String nombreRecurso, String control){
		this.idRecursoSeguridad = idRecursoSeguridad;
		this.nombreRecurso = nombreRecurso;
		this.control = control;
	}
  
	public RecursoSeguridad() {
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
}
