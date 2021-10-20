package com.coop.application.constants;

public class Mapping {
	public Mapping() {
	}
	private static final String URL_PATH = "/api/";
	public static final String URL_LOGIN = URL_PATH + "/login";
	
	public static final String URL_CREATE_PERSONA = URL_PATH + "persona/create";
	public static final String URL_UPDATE_PERSONA = URL_PATH + "persona/update";
	public static final String URL_DELETE_PERSONA = URL_PATH + "persona/delete/{id}";
	public static final String URL_FIND_BY_ID_PERSONA = URL_PATH + "persona/findById/{id}";
	public static final String URL_FIND_ALL_PERSONA = URL_PATH + "persona/findAll/{pageNumber}/{pageSize}";
	public static final String URL_FIND_ALL_FILTERS_PERSONA = URL_PATH + "persona/findAllFilters/{pageNumber}/{pageSize}";
	public static final String URL_RESOURCES_VIEW_PERSONA = URL_PATH + "persona/getResourcesView/{resource}";
	
	public static final String URL_CREATE_USUARIO = URL_PATH + "usuario/create";
	public static final String URL_UPDATE_USUARIO = URL_PATH + "usuario/update";
	public static final String URL_DELETE_USUARIO = URL_PATH + "usuario/delete/{id}";
	public static final String URL_FIND_BY_ID_USUARIO = URL_PATH + "usuario/findById/{id}";
	public static final String URL_FIND_ALL_USUARIO = URL_PATH + "usuario/findAll/{pageNumber}/{pageSize}";
	public static final String URL_FIND_ALL_FILTERS_USUARIO = URL_PATH + "usuario/findAllFilters/{pageNumber}/{pageSize}";
	public static final String URL_RESOURCES_VIEW_USUARIO = URL_PATH + "usuario/getResourcesView/{resource}";
	
	public static final String URL_CREATE_PERFIL = URL_PATH + "perfil/create";
	public static final String URL_UPDATE_PERFIL = URL_PATH + "perfil/update";
	public static final String URL_DELETE_PERFIL = URL_PATH + "perfil/delete/{id}";
	public static final String URL_FIND_BY_ID_PERFIL = URL_PATH + "perfil/findById/{id}";
	public static final String URL_FIND_ALL_PERFIL = URL_PATH + "perfil/findAll/{pageNumber}/{pageSize}";
	public static final String URL_FIND_ALL_FILTERS_PERFIL = URL_PATH + "perfil/findAllFilters/{pageNumber}/{pageSize}";
	public static final String URL_RESOURCES_VIEW_PERFIL = URL_PATH + "perfil/getResourcesView/{resource}";
	
	public static final String URL_CREATE_PERFIL_RECURSO_SEGURIDAD = URL_PATH + "permisosMenuPerfilController/create";
	public static final String URL_FIND_ALL_PERFIL_RECURSO_SEGURIDAD = URL_PATH + "permisosMenuPerfilController/findAll/{pageNumber}/{pageSize}";
	public static final String URL_FIND_ALL_FILTERS_PERFIL_RECURSO_SEGURIDAD = URL_PATH + "permisosMenuPerfilController/findAllFilters/{pageNumber}/{pageSize}";
	public static final String URL_RESOURCES_VIEW_PERFIL_RECURSO_SEGURIDAD = URL_PATH + "permisosMenuPerfilController/getResourcesView/{resource}";
}
