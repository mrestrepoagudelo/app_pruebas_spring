package com.coop.application.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coop.application.constants.Mapping;
import com.coop.domain.constants.MsgConstant;
import com.coop.domain.entities.Persona;
import com.coop.domain.interfaces.persona.IPersonaService;
import com.coop.infrastructure.repository.resources_view.IResourcesView;

@CrossOrigin("*")
@RestController
public class PersonaController {
	
	@Autowired
	private IPersonaService personaService;
	
	@Autowired
	private IResourcesView resourcesView;
	
	@GetMapping(Mapping.URL_FIND_ALL_PERSONA)
	public ResponseEntity<Map<String,Object>> findAll(@PathVariable int pageNumber,@PathVariable int pageSize){
		Map<String,Object> mapResponse = personaService.findAll(pageNumber,pageSize);
		return new ResponseEntity<>(mapResponse, HttpStatus.OK);
	}
	
	@PostMapping(Mapping.URL_FIND_ALL_FILTERS_PERSONA)
	public ResponseEntity<Map<String,Object>> findAllFilters(@PathVariable int pageNumber,@PathVariable int pageSize, @RequestBody Map<String, String> mapParameters){
		Map<String,Object> mapResponse = personaService.findAllFilters(mapParameters, pageNumber, pageSize);
		return new ResponseEntity<>(mapResponse, HttpStatus.OK);
	}
	
	@GetMapping(Mapping.URL_FIND_BY_ID_PERSONA)
	public ResponseEntity<Persona> findById(@PathVariable Long id){
		Persona oPersona = personaService.findById(id);
		return new ResponseEntity<>(oPersona,HttpStatus.OK);
	}
	
	@PostMapping(Mapping.URL_CREATE_PERSONA)
	public ResponseEntity<Persona> create(@RequestBody Persona persona){
		return new ResponseEntity<>(personaService.create(persona),HttpStatus.OK);
	}
	
	@PutMapping(Mapping.URL_UPDATE_PERSONA)
	public ResponseEntity<Persona> update(@RequestBody Persona persona) {
		return new ResponseEntity<>(personaService.create(persona),HttpStatus.OK);
	}
	
	@GetMapping(Mapping.URL_DELETE_PERSONA)
	public ResponseEntity<Object> delete(@PathVariable Long id) throws Exception{
		personaService.delete(id);
		Map<String,String> map = new HashMap<>();
		map.put("msg",MsgConstant.MSG_GUARDADO_EXITO);
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	
	@GetMapping(Mapping.URL_RESOURCES_VIEW_PERSONA)
	public ResponseEntity<List<Map<String, Object>>> getResourcesView(@PathVariable String resource){
		List<Map<String, Object>>  listResource = resourcesView.getList(resource);
		return new ResponseEntity<>(listResource, HttpStatus.OK);
	}
}
