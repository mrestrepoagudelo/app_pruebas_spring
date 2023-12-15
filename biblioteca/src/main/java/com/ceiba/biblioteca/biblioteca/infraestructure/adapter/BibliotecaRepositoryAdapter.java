package com.ceiba.biblioteca.biblioteca.infraestructure.adapter;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ceiba.biblioteca.biblioteca.domain.constant.MsgConstant;
import com.ceiba.biblioteca.biblioteca.domain.exception.ModelException;
import com.ceiba.biblioteca.biblioteca.domain.model.entity.Biblioteca;
import com.ceiba.biblioteca.biblioteca.domain.port.IBibliotecaRepositoryPort;
import com.ceiba.biblioteca.biblioteca.infraestructure.adapter.entity.BibliotecaEntity;
import com.ceiba.biblioteca.biblioteca.infraestructure.adapter.respository.IBibliotecaJpaRepository;

@Repository
public class BibliotecaRepositoryAdapter implements IBibliotecaRepositoryPort {

	@Autowired
	private ModelMapper modelMapper;

	private final IBibliotecaJpaRepository bibliotecaJpaRepository;
	
	public BibliotecaRepositoryAdapter(IBibliotecaJpaRepository bibliotecaJpaRepository) {
		this.bibliotecaJpaRepository = bibliotecaJpaRepository;
	}

	@Override
	@Transactional
	public Biblioteca create(Biblioteca oBiblioteca) {
		BibliotecaEntity bibliotecaEntity = modelMapper.map(oBiblioteca, BibliotecaEntity.class);
		Biblioteca bibliotecaSaved = modelMapper.map(bibliotecaJpaRepository.save(bibliotecaEntity), Biblioteca.class);
		return bibliotecaSaved;
	}

	@Override
	public Biblioteca getById(Long id) {
		Optional<BibliotecaEntity> optionaBiblioteca = bibliotecaJpaRepository.findById(id);
		
		if (optionaBiblioteca.isEmpty()) {
			throw new ModelException(MsgConstant.MSG_REGISTRO_NO_ENCONTRADO);
		}

		return modelMapper.map(bibliotecaJpaRepository.save(optionaBiblioteca.get()), Biblioteca.class);
	}

	@Override
	public List<Biblioteca> getAll() {
		List<Biblioteca> listBiblioteca = modelMapper.map(bibliotecaJpaRepository.findAll(),
						new TypeToken<List<Biblioteca>>() {}.getType());
		return listBiblioteca;
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		bibliotecaJpaRepository.deleteById(id);
	}
}
