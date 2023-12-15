package com.coop.infrastructure.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "perfilRecursoSeguridad")
public class PerfilRecursoSeguridadEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPerfilRecursoSeguridad;

  	@Column(name="id_perfil")
	private Long idPerfil;

  	@Column(name="id_recurso_seguridad")
	private Long idRecursoSeguridad;

	public PerfilRecursoSeguridadEntity (Long idPerfilRecursoSeguridad, Long idPerfil, Long idRecursoSeguridad){
		this.idPerfilRecursoSeguridad = idPerfilRecursoSeguridad;
		this.idPerfil = idPerfil;
		this.idRecursoSeguridad = idRecursoSeguridad;
	}
  
	public PerfilRecursoSeguridadEntity() {
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
	private static final long serialVersionUID = 1L;
}
