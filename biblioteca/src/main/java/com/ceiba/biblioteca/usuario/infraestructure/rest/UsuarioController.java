package com.ceiba.biblioteca.usuario.infraestructure.rest;

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

import com.ceiba.biblioteca.usuario.aplicacion.service.impl.UsuarioCreateHandler;
import com.ceiba.biblioteca.usuario.aplicacion.service.impl.UsuarioDeleteByIdHandler;
import com.ceiba.biblioteca.usuario.aplicacion.service.impl.UsuarioFindAllHandler;
import com.ceiba.biblioteca.usuario.aplicacion.service.impl.UsuarioFindByIdHandler;
import com.ceiba.biblioteca.usuario.domain.model.dto.UsuarioDto;
import com.ceiba.biblioteca.usuario.infraestructure.constant.UsuarioRestMapping;

@CrossOrigin("*")
@RestController
@RequestMapping(UsuarioRestMapping.URL_MAPPING)
public class UsuarioController {

	@Autowired
	private UsuarioCreateHandler usuarioCreateHandler;
	
	@Autowired
	private UsuarioFindAllHandler usuarioFindAllHandler;
	
	@Autowired
	private UsuarioFindByIdHandler usuarioFindByIdHandler;
	
	@Autowired
	private UsuarioDeleteByIdHandler usuarioDeleteByIdHandler;

	@GetMapping(UsuarioRestMapping.URL_FIND_ALL)
	public ResponseEntity<List<UsuarioDto>> findAll() {
		List<UsuarioDto> response = usuarioFindAllHandler.findAll();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping(UsuarioRestMapping.URL_FIND_BY_ID)
	public ResponseEntity<UsuarioDto> findById(@PathVariable Long id) {
		UsuarioDto oUsuario = usuarioFindByIdHandler.findById(id);
		return new ResponseEntity<>(oUsuario, HttpStatus.OK);
	}

	@PostMapping(UsuarioRestMapping.URL_CREATE)
	public ResponseEntity<UsuarioDto> create(@RequestBody UsuarioDto usuario) {
		UsuarioDto usuarioDto = usuarioCreateHandler.create(usuario);
		return new ResponseEntity<>(usuarioCreateHandler.create(usuarioDto), HttpStatus.CREATED);
	}

	@DeleteMapping(UsuarioRestMapping.URL_DELETE)
	public ResponseEntity<Object> delete(@PathVariable Long id){
		usuarioDeleteByIdHandler.deleteById(id);
		return new ResponseEntity<>(id, HttpStatus.OK);
	}
}
