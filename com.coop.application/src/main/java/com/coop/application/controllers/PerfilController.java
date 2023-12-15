package com.coop.application.controllers;

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
import org.springframework.web.bind.annotation.RestController;

import com.coop.application.constants.Mapping;
import com.coop.domain.constants.MsgConstant;
import com.coop.domain.dto.Perfil;
import com.coop.domain.interfaces.perfil.IPerfilService;

@CrossOrigin("*")
@RestController
public class PerfilController {
	
	@Autowired
	private IPerfilService perfilService;
	
	
	@GetMapping(Mapping.URL_FIND_ALL_PERFIL)
	public ResponseEntity<Map<String,Object>> findAll(@PathVariable int pageNumber,@PathVariable int pageSize){
		Map<String,Object> mapResponse = perfilService.findAll(pageNumber,pageSize);
		return new ResponseEntity<>(mapResponse, HttpStatus.OK);
	}
	
	@PostMapping(Mapping.URL_FIND_ALL_FILTERS_PERFIL)
	public ResponseEntity<Map<String,Object>> findAllFilters(@PathVariable int pageNumber,@PathVariable int pageSize, @RequestBody Map<String, String> mapParameters){
		Map<String,Object> mapResponse = perfilService.findAllFilters(mapParameters, pageNumber, pageSize);
		return new ResponseEntity<>(mapResponse, HttpStatus.OK);
	}
	
	@GetMapping(Mapping.URL_FIND_BY_ID_PERFIL)
	public ResponseEntity<Perfil> findById(@PathVariable Long id){
		Perfil oPerfil = perfilService.findById(id);
		return new ResponseEntity<>(oPerfil,HttpStatus.OK);
	}
	
	@PostMapping(Mapping.URL_CREATE_PERFIL)
	public ResponseEntity<Perfil> create(@RequestBody Perfil oPerfil){
		return new ResponseEntity<>(perfilService.create(oPerfil),HttpStatus.OK);
	}
	
	@PutMapping(Mapping.URL_UPDATE_PERFIL)
	public ResponseEntity<Perfil> update(@RequestBody Perfil oPerfil) {
		return new ResponseEntity<>(perfilService.create(oPerfil),HttpStatus.OK);
	}
	
	@GetMapping(Mapping.URL_DELETE_PERFIL)
	public ResponseEntity<Object> delete(@PathVariable Long id) throws Exception{
		perfilService.delete(id);
		Map<String,String> map = new HashMap<>();
		map.put("msg",MsgConstant.MSG_GUARDADO_EXITO);
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	
}
