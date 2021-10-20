package com.coop.domain.service;

import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.coop.domain.constants.MsgConstant;
import com.coop.domain.entities.Persona;
import com.coop.domain.exception.ModelException;
import com.coop.domain.interfaces.persona.IPersonaRepository;
import com.coop.domain.interfaces.persona.IPersonaService;

public class PersonaServiceImp implements IPersonaService{
	
	private IPersonaRepository personaRepository;
	
    public PersonaServiceImp(IPersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }
	
	@Override
	@Transactional(readOnly = true)
	public Map<String,Object> findAll(int pageNumber,int pageSize) {
		return personaRepository.findAll(pageNumber, pageSize);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Map<String,Object> findAllFilters(Map<String,String> mapParameters, int pageNumber, int pageSize){ 
		return personaRepository.findAllFilters(mapParameters, pageNumber, pageSize);
	}

	@Override
	@Transactional(readOnly = true)
	public Persona findById(Long id) {
		Persona oPersona = personaRepository.findById(id);
		if(oPersona == null) {
			throw new ModelException(MsgConstant.MSG_REGISTRO_NO_ENCONTRADO);
		}
		return oPersona;
	}

	@Override
	@Transactional
	public Persona create(Persona oPersona) {
		boolean esInsertar = oPersona.getIdPersona() == null;
		
		//Actualizar
		if(!esInsertar) {
			Persona oPersonaDB = personaRepository.findById(oPersona.getIdPersona());
			if(oPersonaDB == null) {
				throw new ModelException(MsgConstant.MSG_REGISTRO_NO_ENCONTRADO_UPDATE);
			}
		}
		
		return personaRepository.create(oPersona);
	}
	
	@Override
	@Transactional
	public void delete(Long id) {
		Persona oPersona = personaRepository.findById(id);
		if(oPersona == null) {
			throw new ModelException(MsgConstant.MSG_REGISTRO_NO_ENCONTRADO_DELETE);
		}
		personaRepository.delete(id);
	}
}
