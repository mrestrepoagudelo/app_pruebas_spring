package com.coop.domain.dto;

public class Perfil {
	private Long idPerfil;
	private String nombrePerfil;

	public Perfil (Long idPerfil, String nombrePerfil){
		this.idPerfil = idPerfil;
		this.nombrePerfil = nombrePerfil;
	}
  
	public Perfil() {
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
}
