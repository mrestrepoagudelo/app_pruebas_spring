package com.coop.domain.service;

import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.coop.domain.constants.MsgConstant;
import com.coop.domain.dto.RecursoSeguridad;
import com.coop.domain.exception.ModelExceptionDos;
import com.coop.domain.interfaces.recursoSeguridad.IRecursoSeguridadRepository;
import com.coop.domain.interfaces.recursoSeguridad.IRecursoSeguridadService;

public class RecursoSeguridadServiceImp implements IRecursoSeguridadService{
	
	private IRecursoSeguridadRepository recursoSeguridadRepository;
	
    public RecursoSeguridadServiceImp(IRecursoSeguridadRepository recursoSeguridadRepository) {
        this.recursoSeguridadRepository = recursoSeguridadRepository;
    }
	
	@Override
	@Transactional(readOnly = true)
	public Map<String,Object> findAll(int pageNumber,int pageSize) {
		return recursoSeguridadRepository.findAll(pageNumber, pageSize);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Map<String,Object> findAllFilters(Map<String,String> mapParameters, int pageNumber, int pageSize){ 
		return recursoSeguridadRepository.findAllFilters(mapParameters, pageNumber, pageSize);
	}

	@Override
	@Transactional(readOnly = true)
	public RecursoSeguridad findById(Long id) {
		RecursoSeguridad oRecursoSeguridad = recursoSeguridadRepository.findById(id);
		if(oRecursoSeguridad == null) {
			throw new ModelExceptionDos(MsgConstant.MSG_REGISTRO_NO_ENCONTRADO);
		}
		return oRecursoSeguridad;
	}

	@Override
	@Transactional
	public RecursoSeguridad create(RecursoSeguridad oRecursoSeguridad) {
		boolean esInsertar = oRecursoSeguridad.getIdRecursoSeguridad() == null;
		
		//Actualizar
		if(!esInsertar) {
			RecursoSeguridad oRecursoSeguridadDB = recursoSeguridadRepository.findById(oRecursoSeguridad.getIdRecursoSeguridad());
			if(oRecursoSeguridadDB == null) {
				throw new ModelExceptionDos(MsgConstant.MSG_REGISTRO_NO_ENCONTRADO_UPDATE);
			}
		}
		
		return recursoSeguridadRepository.create(oRecursoSeguridad);
	}
	
	@Override
	@Transactional
	public void delete(Long id) {
		RecursoSeguridad oRecursoSeguridad = recursoSeguridadRepository.findById(id);
		if(oRecursoSeguridad == null) {
			throw new ModelExceptionDos(MsgConstant.MSG_REGISTRO_NO_ENCONTRADO_DELETE);
		}
		recursoSeguridadRepository.delete(id);
	}
}
