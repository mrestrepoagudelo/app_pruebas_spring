package com.coop.domain.interfaces.perfil;

import java.util.Map;

import com.coop.domain.dto.Perfil;

public interface IPerfilService {
	public Map<String,Object> findAll(int pageNumber, int pageSize);
	public Map<String,Object> findAllFilters(Map<String, String> mapParameters, int pageNumber, int pageSize);
	public Perfil findById(Long id);
	public Perfil create(Perfil oPerfil);
	public void delete(Long id);
}
