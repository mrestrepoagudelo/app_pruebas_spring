package com.ceiba.biblioteca.libro.infraestructure.constant;

public class LibroRestMapping {
	
	public LibroRestMapping() {
		
	}
	
	public static final String URL_MAPPING = "/libro";
	public static final String URL_CREATE = "/create";
	public static final String URL_UPDATE = "/update";
	public static final String URL_DELETE = "/delete/{id}";
	public static final String URL_FIND_BY_ID = "/findById/{id}";
	public static final String URL_FIND_ALL = "/findAll";
}