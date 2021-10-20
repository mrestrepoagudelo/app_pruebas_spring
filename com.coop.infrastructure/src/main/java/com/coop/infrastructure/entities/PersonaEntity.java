package com.coop.infrastructure.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "persona")
public class PersonaEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPersona;

  	@Column(name="nombres")
	private String nombres;

  	@Column(name="primer_apellido")
	private String primerApellido;

  	@Column(name="segundo_apellido")
	private String segundoApellido;

  	@Column(name="numero_identificacion")
	private Integer numeroIdentificacion;

  	@Column(name="id_tipo_identificacion")
	private Long idTipoIdentificacion;

  	@Column(name="email")
	private String email;

	public PersonaEntity (Long idPersona, String nombres, String primerApellido, String segundoApellido, Integer numeroIdentificacion, Long idTipoIdentificacion, String email){
		this.idPersona = idPersona;
		this.nombres = nombres;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.numeroIdentificacion = numeroIdentificacion;
		this.idTipoIdentificacion = idTipoIdentificacion;
		this.email = email;
	}
  
	public PersonaEntity() {
		// TODO Auto-generated constructor stub
	}

	public Long getIdPersona() {
		return idPersona;
	}
	
	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombres() {
		return nombres;
	}
	
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}
	
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}
	
	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public Integer getNumeroIdentificacion() {
		return numeroIdentificacion;
	}
	
	public void setNumeroIdentificacion(Integer numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	public Long getIdTipoIdentificacion() {
		return idTipoIdentificacion;
	}
	
	public void setIdTipoIdentificacion(Long idTipoIdentificacion) {
		this.idTipoIdentificacion = idTipoIdentificacion;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	private static final long serialVersionUID = 1L;
}
