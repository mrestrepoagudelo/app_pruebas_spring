package com.ceiba.biblioteca.prestamo.infraestructure.rest;

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

import com.ceiba.biblioteca.prestamo.aplicacion.service.impl.PrestamoCreateHandler;
import com.ceiba.biblioteca.prestamo.aplicacion.service.impl.PrestamoDeleteByIdHandler;
import com.ceiba.biblioteca.prestamo.aplicacion.service.impl.PrestamoFindAllHandler;
import com.ceiba.biblioteca.prestamo.aplicacion.service.impl.PrestamoFindByIdHandler;
import com.ceiba.biblioteca.prestamo.domain.model.dto.PrestamoDto;
import com.ceiba.biblioteca.prestamo.domain.model.dto.PrestamoDtoResponseCreated;
import com.ceiba.biblioteca.prestamo.infraestructure.constant.PrestamoRestMapping;

@CrossOrigin("*")
@RestController
@RequestMapping(PrestamoRestMapping.URL_MAPPING)
public class PrestamoController {

	@Autowired
	private PrestamoCreateHandler prestamoCreateHandler;
	
	@Autowired
	private PrestamoFindAllHandler prestamoFindAllHandler;
	
	@Autowired
	private PrestamoFindByIdHandler prestamoFindByIdHandler;
	
	@Autowired
	private PrestamoDeleteByIdHandler prestamoDeleteByIdHandler;

	@GetMapping(PrestamoRestMapping.URL_FIND_ALL)
	public ResponseEntity<List<PrestamoDto>> findAll() {
		List<PrestamoDto> response = prestamoFindAllHandler.findAll();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping(PrestamoRestMapping.URL_FIND_BY_ID)
	public ResponseEntity<PrestamoDto> findById(@PathVariable Long id) {
		PrestamoDto oPrestamo = prestamoFindByIdHandler.findById(id);
		return new ResponseEntity<>(oPrestamo, HttpStatus.OK);
	}

	@PostMapping(PrestamoRestMapping.URL_CREATE)
	public ResponseEntity<PrestamoDtoResponseCreated> create(@RequestBody PrestamoDto prestamo) {
		PrestamoDtoResponseCreated prestamoDto = prestamoCreateHandler.create(prestamo);
		return new ResponseEntity<>(prestamoDto, HttpStatus.CREATED);
	}

	@DeleteMapping(PrestamoRestMapping.URL_DELETE)
	public ResponseEntity<Object> delete(@PathVariable Long id){
		prestamoDeleteByIdHandler.deleteById(id);
		return new ResponseEntity<>(id, HttpStatus.OK);
	}
}
