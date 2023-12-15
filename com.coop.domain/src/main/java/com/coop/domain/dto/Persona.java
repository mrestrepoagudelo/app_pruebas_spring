package com.coop.domain.dto;

public class Persona {
	private Long idPersona;
	private String nombres;
	private String primerApellido;
	private String segundoApellido;
	private Integer numeroIdentificacion;
	private Long idTipoIdentificacion;
	private String email;

	public Persona (Long idPersona, String nombres, String primerApellido, String segundoApellido, Integer numeroIdentificacion, Long idTipoIdentificacion, String email){
		this.idPersona = idPersona;
		this.nombres = nombres;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.numeroIdentificacion = numeroIdentificacion;
		this.idTipoIdentificacion = idTipoIdentificacion;
		this.email = email;
	}
  
	public Persona() {
		
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
}
