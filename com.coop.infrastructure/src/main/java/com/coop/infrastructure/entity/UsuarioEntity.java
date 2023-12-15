package com.coop.infrastructure.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class UsuarioEntity implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="clave")
	private String clave;
	
	@Column(name="id_persona")
	private Long idPersona;
	
	@Column(name="id_perfil")
	private Long idPerfil;
	
	@Column(name="activo")
	private String activo;
	
	public UsuarioEntity() {
		// TODO Auto-generated constructor stub
	}

	public UsuarioEntity(Long idUsuario, String userName, String clave, Long idPersona, Long idPerfil, String activo) {
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