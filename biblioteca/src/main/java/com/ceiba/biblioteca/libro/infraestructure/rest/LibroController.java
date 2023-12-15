package com.ceiba.biblioteca.libro.infraestructure.rest;

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

import com.ceiba.biblioteca.libro.aplicacion.service.impl.LibroCreateHandler;
import com.ceiba.biblioteca.libro.aplicacion.service.impl.LibroDeleteByIdHandler;
import com.ceiba.biblioteca.libro.aplicacion.service.impl.LibroFindAllHandler;
import com.ceiba.biblioteca.libro.aplicacion.service.impl.LibroFindByIdHandler;
import com.ceiba.biblioteca.libro.domain.model.dto.LibroDto;
import com.ceiba.biblioteca.libro.infraestructure.constant.LibroRestMapping;

@CrossOrigin("*")
@RestController
@RequestMapping(LibroRestMapping.URL_MAPPING)
public class LibroController {

	@Autowired
	private LibroCreateHandler libroCreateHandler;
	
	@Autowired
	private LibroFindAllHandler libroFindAllHandler;
	
	@Autowired
	private LibroFindByIdHandler libroFindByIdHandler;
	
	@Autowired
	private LibroDeleteByIdHandler libroDeleteByIdHandler;

	@GetMapping(LibroRestMapping.URL_FIND_ALL)
	public ResponseEntity<List<LibroDto>> findAll() {
		List<LibroDto> response = libroFindAllHandler.findAll();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping(LibroRestMapping.URL_FIND_BY_ID)
	public ResponseEntity<LibroDto> findById(@PathVariable Long id) {
		LibroDto libroDto = libroFindByIdHandler.findById(id);
		return new ResponseEntity<>(libroDto, HttpStatus.OK);
	}

	@PostMapping(LibroRestMapping.URL_CREATE)
	public ResponseEntity<LibroDto> create(@RequestBody LibroDto libro) {
		LibroDto libroDto = libroCreateHandler.create(libro);
		return new ResponseEntity<>(libroCreateHandler.create(libroDto), HttpStatus.CREATED);
	}

	@DeleteMapping(LibroRestMapping.URL_DELETE)
	public ResponseEntity<Object> delete(@PathVariable Long id){
		libroDeleteByIdHandler.deleteById(id);
		return new ResponseEntity<>(id, HttpStatus.OK);
	}
}
