package com.ceiba.biblioteca.usuario.infraestructure.constant;

public class UsuarioRestMapping {
	
	public UsuarioRestMapping() {
		
	}
	
	public static final String URL_MAPPING = "/usuario";
	public static final String URL_CREATE = "/create";
	public static final String URL_UPDATE = "/update";
	public static final String URL_DELETE = "/delete/{id}";
	public static final String URL_FIND_BY_ID = "/findById/{id}";
	public static final String URL_FIND_ALL = "/findAll";
}