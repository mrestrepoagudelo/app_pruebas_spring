package com.ceiba.biblioteca.biblioteca.infraestructure.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.biblioteca.biblioteca.aplicacion.service.impl.BibliotecaCreateHandler;
import com.ceiba.biblioteca.biblioteca.aplicacion.service.impl.BibliotecaDeleteByIdHandler;
import com.ceiba.biblioteca.biblioteca.aplicacion.service.impl.BibliotecaFindAllHandler;
import com.ceiba.biblioteca.biblioteca.aplicacion.service.impl.BibliotecaFindByIdHandler;
import com.ceiba.biblioteca.biblioteca.domain.model.dto.BibliotecaDto;
import com.ceiba.biblioteca.biblioteca.infraestructure.constant.BibliotecaRestMapping;

@CrossOrigin("*")
@RestController
@RequestMapping(BibliotecaRestMapping.URL_MAPPING)
public class BibliotecaController {

	@Autowired
	private BibliotecaCreateHandler bibliotecaCreateHandler;
	
	@Autowired
	private BibliotecaFindAllHandler bibliotecaFindAllHandler;
	
	@Autowired
	private BibliotecaFindByIdHandler bibliotecaFindByIdHandler;
	
	@Autowired
	private BibliotecaDeleteByIdHandler bibliotecaDeleteByIdHandler;

	@GetMapping(BibliotecaRestMapping.URL_FIND_ALL)
	public ResponseEntity<List<BibliotecaDto>> findAll() {
		List<BibliotecaDto> response = bibliotecaFindAllHandler.findAll();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping(BibliotecaRestMapping.URL_FIND_BY_ID)
	public ResponseEntity<BibliotecaDto> findById(@PathVariable Long id) {
		BibliotecaDto response = bibliotecaFindByIdHandler.findById(id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping(BibliotecaRestMapping.URL_CREATE)
	public ResponseEntity<BibliotecaDto> create(@RequestBody BibliotecaDto biblioteca) {
		BibliotecaDto bibliotecaDto = bibliotecaCreateHandler.create(biblioteca);
		return new ResponseEntity<>(bibliotecaCreateHandler.create(bibliotecaDto), HttpStatus.CREATED);
	}

	@DeleteMapping(BibliotecaRestMapping.URL_DELETE)
	public ResponseEntity<Object> delete(@PathVariable Long id){
		bibliotecaDeleteByIdHandler.deleteById(id);
		return new ResponseEntity<>(id, HttpStatus.OK);
	}
}
