package com.coop.infrastructure.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "perfil")
public class PerfilEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPerfil;

  	@Column(name="nombre_perfil")
	private String nombrePerfil;

	public PerfilEntity (Long idPerfil, String nombrePerfil){
		this.idPerfil = idPerfil;
		this.nombrePerfil = nombrePerfil;
	}
  
	public PerfilEntity() {
		// TODO Auto-generated constructor stub
	}

	public Long getIdPerfil() {
		return idPerfil;
	}
	
	public void setIdPerfil(Long idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getNombrePerfil() {
		return nombrePerfil;
	}
	
	public void setNombrePerfil(String nombrePerfil) {
		this.nombrePerfil = nombrePerfil;
	}
	private static final long serialVersionUID = 1L;
}
