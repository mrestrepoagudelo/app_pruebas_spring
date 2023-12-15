package com.ceiba.biblioteca.usuario.infraestructure.adapter.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class UsuarioEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;
	
	@Column(name = "id_tipo_usuario")
	private Long idTipoUsuario;
	
	@Column(name = "id_tipo_identificacion")
	private Long idTipoIdentificacion;
	
	@Column(name = "numero_identificacion")
	private String numeroIdentificacion;

	@Column(name = "nombres")
	private String nombres;

	@Column(name = "apellidos")
	private String apellidos;

	@Column(name = "numero_celular")
	private String numeroCelular;
	
	@Column(name = "direccion")
	private String direccion;

	@Column(name = "email")
	private String email;
}
