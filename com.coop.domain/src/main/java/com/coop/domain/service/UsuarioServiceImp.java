package com.coop.domain.service;

import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.coop.domain.constants.MsgConstant;
import com.coop.domain.dto.Usuario;
import com.coop.domain.exception.ModelExceptionDos;
import com.coop.domain.interfaces.usuario.IUsuarioRepository;
import com.coop.domain.interfaces.usuario.IUsuarioService;

public class UsuarioServiceImp implements IUsuarioService{
	
	private IUsuarioRepository usuarioRepository;
	
    public UsuarioServiceImp(IUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
	
	@Override
	@Transactional(readOnly = true)
	public Map<String,Object> findAll(int pageNumber,int pageSize) {
		return usuarioRepository.findAll(pageNumber, pageSize);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Map<String,Object> findAllFilters(Map<String,String> mapParameters, int pageNumber, int pageSize){ 
		return usuarioRepository.findAllFilters(mapParameters, pageNumber, pageSize);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findById(Long id) {
		Usuario oUsuario = usuarioRepository.findById(id);
		if(oUsuario == null) {
			throw new ModelExceptionDos(MsgConstant.MSG_REGISTRO_NO_ENCONTRADO);
		}
		return oUsuario;
	}

	@Override
	@Transactional
	public Usuario create(Usuario oUsuario) {
		boolean esInsertar = oUsuario.getIdUsuario() == null;
		
		//Actualizar
		if(!esInsertar) {
			Usuario oUsuarioDB = usuarioRepository.findById(oUsuario.getIdUsuario());
			if(oUsuarioDB == null) {
				throw new ModelExceptionDos(MsgConstant.MSG_REGISTRO_NO_ENCONTRADO_UPDATE);
			}
		}
		
		return usuarioRepository.create(oUsuario);
	}
	
	@Override
	@Transactional
	public void delete(Long id) {
		Usuario oUsuario = usuarioRepository.findById(id);
		if(oUsuario == null) {
			throw new ModelExceptionDos(MsgConstant.MSG_REGISTRO_NO_ENCONTRADO_DELETE);
		}
		usuarioRepository.delete(id);
	}
}
