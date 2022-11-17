package com.coop.domain.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.coop.domain.constants.MsgConstant;
import com.coop.domain.entities.PerfilRecursoSeguridad;
import com.coop.domain.entities.RecursoSeguridad;
import com.coop.domain.exception.ModelException;
import com.coop.domain.interfaces.perfilRecursoSeguridad.IPerfilRecursoSeguridadRepository;
import com.coop.domain.interfaces.perfilRecursoSeguridad.IPerfilRecursoSeguridadService;
import com.coop.domain.interfaces.recursoSeguridad.IRecursoSeguridadRepository;

public class PerfilRecursoSeguridadServiceImp implements IPerfilRecursoSeguridadService{
	
	@Autowired
	private IRecursoSeguridadRepository recursoSeguridadRepository;

	private IPerfilRecursoSeguridadRepository perfilRecursoSeguridadRepository;
	
    public PerfilRecursoSeguridadServiceImp(IPerfilRecursoSeguridadRepository perfilRecursoSeguridadRepository) {
        this.perfilRecursoSeguridadRepository = perfilRecursoSeguridadRepository;
    }
	
	@Override
	@Transactional(readOnly = true)
	public Map<String,Object> findAll(int pageNumber,int pageSize) {
		return perfilRecursoSeguridadRepository.findAll(pageNumber, pageSize);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Map<String,Object> findAllFilters(Map<String,String> mapParameters, Integer pageNumber, Integer pageSize){ 
		return perfilRecursoSeguridadRepository.findAllFilters(mapParameters, pageNumber, pageSize);
	}

	@Override
	@Transactional(readOnly = true)
	public PerfilRecursoSeguridad findById(Long id) {
		PerfilRecursoSeguridad oPerfilRecursoSeguridad = perfilRecursoSeguridadRepository.findById(id);
		if(oPerfilRecursoSeguridad == null) {
			throw new ModelException(MsgConstant.MSG_REGISTRO_NO_ENCONTRADO);
		}
		return oPerfilRecursoSeguridad;
	}
	
	@Override
	@Transactional(readOnly = true)
	public Map<String,Object> findRecursosByPerfil(Long idPerfil){
		return perfilRecursoSeguridadRepository.findRecursosByPerfil(idPerfil);
	} 

	@Override
	@Transactional
	public Map<String,Object> create(Map<String,Object> mapParametros) {
		
		Long idPerfil = Long.valueOf((Integer)mapParametros.get("idPerfil"));
		String control = (String) mapParametros.get("control");
		boolean tienePermiso = (boolean) mapParametros.get("tienePermiso");
		
		//Buscar el recurso por el nombre del control 
		RecursoSeguridad oRecursoSeguridad = recursoSeguridadRepository.findByControl(control);
		
		//Si el recurso no exite lo creamos
		if(oRecursoSeguridad == null) {
			oRecursoSeguridad = new RecursoSeguridad();
			oRecursoSeguridad.setControl(control);
			recursoSeguridadRepository.create(oRecursoSeguridad);
		}
		
		//Buscar los permisos
		PerfilRecursoSeguridad oPerfilRecursoSeguridad = 
				perfilRecursoSeguridadRepository.findByIdPerfilAndIdRecursoSeguridad(idPerfil, oRecursoSeguridad.getIdRecursoSeguridad());
		
		boolean tienePermisoAux = false;
		
		if(tienePermiso){
			
			//Si tiene permiso quitarselo
			if(oPerfilRecursoSeguridad != null){
				perfilRecursoSeguridadRepository.delete(oPerfilRecursoSeguridad.getIdPerfilRecursoSeguridad());
				tienePermisoAux = false;
			}
		}
		else {
			
			//Si no tiene permiso darselo 
			if(oPerfilRecursoSeguridad == null){
				oPerfilRecursoSeguridad = new PerfilRecursoSeguridad();
				oPerfilRecursoSeguridad.setIdPerfil(idPerfil);
				oPerfilRecursoSeguridad.setIdRecursoSeguridad(oRecursoSeguridad.getIdRecursoSeguridad());
				perfilRecursoSeguridadRepository.create(oPerfilRecursoSeguridad);
				tienePermisoAux = true;
			}
		}
		
		Map <String,Object> mapResponse = new HashMap<String, Object>();
		mapResponse.put("tienePermiso", tienePermisoAux);
		mapResponse.put("msg", "Registro actualizado exitosamente");
		return mapResponse;
	}
	
	@Override
	@Transactional
	public void delete(Long id) {
		PerfilRecursoSeguridad oPerfilRecursoSeguridad = perfilRecursoSeguridadRepository.findById(id);
		if(oPerfilRecursoSeguridad == null) {
			throw new ModelException(MsgConstant.MSG_REGISTRO_NO_ENCONTRADO_DELETE);
		}
		perfilRecursoSeguridadRepository.delete(id);
	}

}
