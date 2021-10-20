package com.coop.domain.interfaces.usuario;

import java.util.Map;

import com.coop.domain.entities.Usuario;

public interface IUsuarioService {
	public Map<String,Object> findAll(int pageNumber, int pageSize);
	public Map<String,Object> findAllFilters(Map<String, String> mapParameters, int pageNumber, int pageSize);
	public Usuario findById(Long id);
	public Usuario create(Usuario oUsuario);
	public void delete(Long id);
}
