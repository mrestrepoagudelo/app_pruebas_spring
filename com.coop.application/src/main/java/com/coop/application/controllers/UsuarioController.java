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
import com.coop.domain.entities.Usuario;
import com.coop.domain.interfaces.usuario.IUsuarioService;
import com.coop.infrastructure.repository.resources_view.IResourcesView;

@CrossOrigin("*")
@RestController
public class UsuarioController {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private IResourcesView resourcesView;
	
	@GetMapping(Mapping.URL_FIND_ALL_USUARIO)
	public ResponseEntity<Map<String,Object>> findAll(@PathVariable int pageNumber,@PathVariable int pageSize){
		Map<String,Object> mapResponse = usuarioService.findAll(pageNumber,pageSize);
		return new ResponseEntity<>(mapResponse, HttpStatus.OK);
	}
	
	@PostMapping(Mapping.URL_FIND_ALL_FILTERS_USUARIO)
	public ResponseEntity<Map<String,Object>> findAllFilters(@PathVariable int pageNumber,@PathVariable int pageSize, @RequestBody Map<String, String> mapParameters){
		Map<String,Object> mapResponse = usuarioService.findAllFilters(mapParameters, pageNumber, pageSize);
		return new ResponseEntity<>(mapResponse, HttpStatus.OK);
	}
	
	@PostMapping(Mapping.URL_FIND_BY_ID_USUARIO)
	public ResponseEntity<Usuario> findById(@PathVariable Long id){
		Usuario oUsuario = usuarioService.findById(id);
		return new ResponseEntity<>(oUsuario,HttpStatus.OK);
	}
	
	@PostMapping(Mapping.URL_CREATE_USUARIO)
	public ResponseEntity<Usuario> create(@RequestBody Usuario usuario){
		return new ResponseEntity<>(usuarioService.create(usuario),HttpStatus.OK);
	}
	
	@PutMapping(Mapping.URL_UPDATE_USUARIO)
	public ResponseEntity<Usuario> update(@RequestBody Usuario oUsuario) {
		return new ResponseEntity<>(usuarioService.create(oUsuario),HttpStatus.OK);
	}
	
	@GetMapping(Mapping.URL_DELETE_USUARIO)
	public ResponseEntity<Object> delete(@PathVariable Long id) throws Exception{
		usuarioService.delete(id);
		Map<String,String> map = new HashMap<>();
		map.put("msg",MsgConstant.MSG_ElIMINADO_EXITO);
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	
	@GetMapping(Mapping.URL_RESOURCES_VIEW_USUARIO)
	public ResponseEntity<List<Map<String, Object>>> getResourcesView(@PathVariable String resource){
		List<Map<String, Object>>  listResource = resourcesView.getList(resource);
		return new ResponseEntity<>(listResource, HttpStatus.OK);
	}
}
