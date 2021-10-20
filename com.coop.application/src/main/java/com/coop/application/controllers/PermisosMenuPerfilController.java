package com.coop.application.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coop.application.constants.Mapping;
import com.coop.domain.entities.PerfilRecursoSeguridad;
import com.coop.domain.interfaces.perfilRecursoSeguridad.IPerfilRecursoSeguridadService;
import com.coop.infrastructure.repository.resources_view.IResourcesView;

@CrossOrigin("*")
@RestController
public class PermisosMenuPerfilController{
	
	@Autowired
	private IPerfilRecursoSeguridadService perfilRecursoSeguridadService;
	
	@Autowired
	private IResourcesView resourcesView;
	
	@GetMapping(Mapping.URL_FIND_ALL_PERFIL_RECURSO_SEGURIDAD)
	public ResponseEntity<Map<String,Object>> findAll(@PathVariable int pageNumber,@PathVariable int pageSize){
		Map<String,Object> mapResponse = perfilRecursoSeguridadService.findAll(pageNumber,pageSize);
		return new ResponseEntity<>(mapResponse, HttpStatus.OK);
	}
	
	@PostMapping(Mapping.URL_FIND_ALL_FILTERS_PERFIL_RECURSO_SEGURIDAD)
	public ResponseEntity<Map<String,Object>> findAllFilters(@PathVariable int pageNumber,@PathVariable int pageSize, @RequestBody Map<String, String> mapParameters){
		Map<String,Object> mapResponse = perfilRecursoSeguridadService.findAllFilters(mapParameters, pageNumber, pageSize);
		return new ResponseEntity<>(mapResponse, HttpStatus.OK);
	}
	
	@PostMapping(Mapping.URL_CREATE_PERFIL_RECURSO_SEGURIDAD)
	public ResponseEntity<Map<String,Object>> create(@RequestBody Map<String,Object> mapPerfilRecursoSeguridad){
		return new ResponseEntity<>(perfilRecursoSeguridadService.create(mapPerfilRecursoSeguridad),HttpStatus.OK);
	}
	
  	@GetMapping(Mapping.URL_RESOURCES_VIEW_PERFIL_RECURSO_SEGURIDAD)
	public ResponseEntity<List<Map<String, Object>>> getResourcesView(@PathVariable String resource){
		List<Map<String, Object>>  listResource = resourcesView.getList(resource);
		return new ResponseEntity<>(listResource, HttpStatus.OK);
	}
}
