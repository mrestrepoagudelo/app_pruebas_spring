package com.coop.domain.interfaces.persona;

import java.util.Map;
import com.coop.domain.entities.Persona;

public interface IPersonaService {
	public Map<String,Object> findAll(int pageNumber, int pageSize);
	public Map<String,Object> findAllFilters(Map<String, String> mapParameters, int pageNumber, int pageSize);
	public Persona findById(Long id);
	public Persona create(Persona oPersona);
	public void delete(Long id);
}
