package com.coop.domain.interfaces.recursoSeguridad;

import java.util.Map;

import com.coop.domain.dto.RecursoSeguridad;

public interface IRecursoSeguridadRepository {
	public Map<String,Object> findAll(int pageNumber,int pageSize);
	public Map<String,Object> findAllFilters(Map<String,String> mapParameters, int pageNumber, int pageSize);
	public RecursoSeguridad findById(Long id);
	public RecursoSeguridad create(RecursoSeguridad oRecursoSeguridad);
	public RecursoSeguridad findByControl(String control);
	public void delete(Long id);
}
