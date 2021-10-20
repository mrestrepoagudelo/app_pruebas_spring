package com.coop.app_web.controllers;

import java.util.HashMap;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coop.application.interfaces.IPersonaAccion;
import com.coop.domain.entities.Persona;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/persona")
public class PersonaRestController {
	
	@Autowired
	private IPersonaAccion personaService;
	
	@GetMapping("/findAll/{pageNumber}/{pageSize}")
	public ResponseEntity<Map> findAll(@PathVariable int pageNumber,@PathVariable int pageSize){
		Map mapResponse = personaService.findAll(pageNumber,pageSize);
		return new ResponseEntity<>(mapResponse, HttpStatus.OK);
	}
	
	@GetMapping("/findAllFilters/{pageNumber}/{pageSize}")
	public ResponseEntity<Map> findAllFilters(@PathVariable int pageNumber,@PathVariable int pageSize, @RequestBody Map<String, String> mapParameters){
		Map mapResponse = personaService.findAllFilters(mapParameters, pageNumber, pageSize);
		return new ResponseEntity<>(mapResponse, HttpStatus.OK);
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Persona> findById(@PathVariable Long id){
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		Persona oPersona = personaService.findById(id);
		return new ResponseEntity<>(oPersona,HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<Persona> create(@RequestBody Persona persona){
		return new ResponseEntity<>(personaService.create(persona),HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Persona> update(@RequestBody Persona persona) {
		return new ResponseEntity<>(personaService.create(persona),HttpStatus.OK);
	}
	
	@GetMapping("/delete/{id}")
	public ResponseEntity<Object> delete(@PathVariable Long id) throws Exception{
		personaService.delete(id);
		Map map = new HashMap<>();
		map.put("msg","Registro eliminado!");
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
}
