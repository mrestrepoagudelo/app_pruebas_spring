package com.ceiba.biblioteca.libro.infraestructure.adapter;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ceiba.biblioteca.libro.domain.constant.MsgConstant;
import com.ceiba.biblioteca.libro.domain.exception.ModelException;
import com.ceiba.biblioteca.libro.domain.model.entity.Libro;
import com.ceiba.biblioteca.libro.domain.port.ILibroRepositoryPort;
import com.ceiba.biblioteca.libro.infraestructure.adapter.entity.LibroEntity;
import com.ceiba.biblioteca.libro.infraestructure.adapter.respository.ILibroJpaRepository;

@Repository
public class LibroRepositoryAdapter implements ILibroRepositoryPort {

	@Autowired
	private ModelMapper modelMapper;

	private final ILibroJpaRepository libroJpaRepository;
	
	public LibroRepositoryAdapter(ILibroJpaRepository libroJpaRepository) {
		this.libroJpaRepository = libroJpaRepository;
	}

	@Override
	@Transactional
	public Libro create(Libro oLibro) {
		LibroEntity libroEntity = modelMapper.map(oLibro, LibroEntity.class);
		Libro libroSaved = modelMapper.map(libroJpaRepository.save(libroEntity), Libro.class);
		return libroSaved;
	}

	@Override
	public Libro getById(Long id) {
		Optional<LibroEntity> optionaLibro = libroJpaRepository.findById(id);
		
		if (optionaLibro.isEmpty()) {
			throw new ModelException(MsgConstant.MSG_REGISTRO_NO_ENCONTRADO);
		}

		return modelMapper.map(libroJpaRepository.save(optionaLibro.get()), Libro.class);
	}

	@Override
	public List<Libro> getAll() {
		List<Libro> listLibro = modelMapper.map(libroJpaRepository.findAll(),
						new TypeToken<List<Libro>>() {}.getType());
		return listLibro;
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		libroJpaRepository.deleteById(id);
	}
}
