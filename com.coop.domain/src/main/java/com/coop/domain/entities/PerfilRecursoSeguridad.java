package com.coop.domain.entities;

public class PerfilRecursoSeguridad {
	private Long idPerfilRecursoSeguridad;
	private Long idPerfil;
	private Long idRecursoSeguridad;

	public PerfilRecursoSeguridad (Long idPerfilRecursoSeguridad, Long idPerfil, Long idRecursoSeguridad){
		this.idPerfilRecursoSeguridad = idPerfilRecursoSeguridad;
		this.idPerfil = idPerfil;
		this.idRecursoSeguridad = idRecursoSeguridad;
	}
  
	public PerfilRecursoSeguridad() {
		// TODO Auto-generated constructor stub
	}
	
	public Long getIdPerfilRecursoSeguridad() {
		return idPerfilRecursoSeguridad;
	}
	public void setIdPerfilRecursoSeguridad(Long idPerfilRecursoSeguridad) {
		this.idPerfilRecursoSeguridad = idPerfilRecursoSeguridad;
	}
	public Long getIdPerfil() {
		return idPerfil;
	}
	public void setIdPerfil(Long idPerfil) {
		this.idPerfil = idPerfil;
	}
	public Long getIdRecursoSeguridad() {
		return idRecursoSeguridad;
	}
	public void setIdRecursoSeguridad(Long idRecursoSeguridad) {
		this.idRecursoSeguridad = idRecursoSeguridad;
	}
}
