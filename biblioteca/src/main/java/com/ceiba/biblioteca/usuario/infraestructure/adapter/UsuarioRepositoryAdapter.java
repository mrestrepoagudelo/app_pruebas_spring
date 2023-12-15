package com.ceiba.biblioteca.usuario.infraestructure.adapter;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ceiba.biblioteca.usuario.domain.constant.MsgConstant;
import com.ceiba.biblioteca.usuario.domain.exception.ModelException;
import com.ceiba.biblioteca.usuario.domain.model.dto.UsuarioDtoRes;
import com.ceiba.biblioteca.usuario.domain.model.entity.Usuario;
import com.ceiba.biblioteca.usuario.domain.port.IUsuarioRepositoryPort;
import com.ceiba.biblioteca.usuario.infraestructure.adapter.entity.UsuarioEntity;
import com.ceiba.biblioteca.usuario.infraestructure.adapter.respository.IUsuarioJpaRepository;

@Repository
public class UsuarioRepositoryAdapter implements IUsuarioRepositoryPort {

	@Autowired
	private ModelMapper modelMapper;

	private final IUsuarioJpaRepository usuarioJpaRepository;
	
	public UsuarioRepositoryAdapter(IUsuarioJpaRepository usuarioJpaRepository) {
		this.usuarioJpaRepository = usuarioJpaRepository;
	}

	@Override
	@Transactional
	public Usuario create(Usuario oUsuario) {
		UsuarioEntity usuarioEntity = modelMapper.map(oUsuario, UsuarioEntity.class);
		Usuario usuarioSaved = modelMapper.map(usuarioJpaRepository.save(usuarioEntity), Usuario.class);
		return usuarioSaved;
	}

	@Override
	public Usuario getById(Long id) {
		Optional<UsuarioDtoRes> optionaUsuario = usuarioJpaRepository.getUsuarioById(id);
//		Optional<UsuarioEntity> optionaUsuario = usuarioJpaRepository.findById(id);
		if (optionaUsuario.isEmpty()) {
			throw new ModelException(MsgConstant.MSG_REGISTRO_NO_ENCONTRADO);
		}

		return modelMapper.map(optionaUsuario, Usuario.class);
	}
	
	@Override
	public List<Usuario> getAll() {
		List<Usuario> listUsuario = modelMapper.map(usuarioJpaRepository.findAll(),
						new TypeToken<List<Usuario>>() {}.getType());
		return listUsuario;
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		usuarioJpaRepository.deleteById(id);
	}

	@Override
	public Usuario findByNumeroIdentificacion(String numeroIdentificacion) {
		Optional<UsuarioEntity> usuario = usuarioJpaRepository.findByNumeroIdentificacion(numeroIdentificacion);
		if (usuario.isEmpty()) {
			throw new ModelException(MsgConstant.MSG_REGISTRO_NO_ENCONTRADO);
		}
		return modelMapper.map(usuario, Usuario.class);
	}
}
