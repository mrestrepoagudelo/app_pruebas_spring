package com.coop.domain.interfaces.perfilRecursoSeguridad;

import java.util.Map;

import com.coop.domain.entities.PerfilRecursoSeguridad;

public interface IPerfilRecursoSeguridadRepository {
	public Map<String,Object> findAll(int pageNumber,int pageSize);
	public Map<String,Object> findAllFilters(Map<String,String> mapParameters, Integer pageNumber, Integer pageSize);
	public PerfilRecursoSeguridad findById(Long id);
	public PerfilRecursoSeguridad findByIdPerfilAndIdRecursoSeguridad(Long idPerfil, Long idRecursoSeguridad); 
	public PerfilRecursoSeguridad create(PerfilRecursoSeguridad oPerfilRecursoSeguridad);
	public void delete(Long id);
	public Map<String,Object> findRecursosByPerfil(Long idPerfil);
}
