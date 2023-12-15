package com.coop.domain.service;

import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.coop.domain.constants.MsgConstant;
import com.coop.domain.dto.Perfil;
import com.coop.domain.exception.ModelExceptionDos;
import com.coop.domain.interfaces.perfil.IPerfilRepository;
import com.coop.domain.interfaces.perfil.IPerfilService;

public class PerfilServiceImp implements IPerfilService{
	
	private IPerfilRepository perfilRepository;
	
    public PerfilServiceImp(IPerfilRepository perfilRepository) {
        this.perfilRepository = perfilRepository;
    }
	
	@Override
	@Transactional(readOnly = true)
	public Map<String,Object> findAll(int pageNumber,int pageSize) {
		return perfilRepository.findAll(pageNumber, pageSize);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Map<String,Object> findAllFilters(Map<String,String> mapParameters, int pageNumber, int pageSize){ 
		return perfilRepository.findAllFilters(mapParameters, pageNumber, pageSize);
	}

	@Override
	@Transactional(readOnly = true)
	public Perfil findById(Long id) {
		Perfil oPerfil = perfilRepository.findById(id);
		if(oPerfil == null) {
			throw new ModelExceptionDos(MsgConstant.MSG_REGISTRO_NO_ENCONTRADO);
		}
		return oPerfil;
	}

	@Override
	@Transactional
	public Perfil create(Perfil oPerfil) {
		boolean esInsertar = oPerfil.getIdPerfil() == null;
		
		//Actualizar
		if(!esInsertar) {
			Perfil oPerfilDB = perfilRepository.findById(oPerfil.getIdPerfil());
			if(oPerfilDB == null) {
				throw new ModelExceptionDos(MsgConstant.MSG_REGISTRO_NO_ENCONTRADO_UPDATE);
			}
		}
		
		return perfilRepository.create(oPerfil);
	}
	
	@Override
	@Transactional
	public void delete(Long id) {
		Perfil oPerfil = perfilRepository.findById(id);
		if(oPerfil == null) {
			throw new ModelExceptionDos(MsgConstant.MSG_REGISTRO_NO_ENCONTRADO_DELETE);
		}
		perfilRepository.delete(id);
	}
}
