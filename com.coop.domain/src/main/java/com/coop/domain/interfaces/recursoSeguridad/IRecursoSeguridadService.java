package com.coop.domain.interfaces.recursoSeguridad;

import java.util.Map;
import com.coop.domain.entities.RecursoSeguridad;

public interface IRecursoSeguridadService {
	public Map<String,Object> findAll(int pageNumber, int pageSize);
	public Map<String,Object> findAllFilters(Map<String, String> mapParameters, int pageNumber, int pageSize);
	public RecursoSeguridad findById(Long id);
	public RecursoSeguridad create(RecursoSeguridad oRecursoSeguridad);
	public void delete(Long id);
}
