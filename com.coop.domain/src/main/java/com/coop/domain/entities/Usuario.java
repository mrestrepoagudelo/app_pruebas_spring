package com.coop.domain.entities;

public class Usuario {
	private Long idUsuario;
	private String userName;
	private String clave;
	private Long idPersona;
	private Long idPerfil;
	private String activo;
	
	public Usuario() {
	}

	public Usuario(Long idUsuario, String userName, String clave, Long idPersona, Long idPerfil, String activo) {
		super();
		this.idUsuario = idUsuario;
		this.userName = userName;
		this.clave = clave;
		this.idPersona = idPersona;
		this.idPerfil = idPerfil;
		this.activo = activo;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public Long getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}

	public Long getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(Long idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}
}
