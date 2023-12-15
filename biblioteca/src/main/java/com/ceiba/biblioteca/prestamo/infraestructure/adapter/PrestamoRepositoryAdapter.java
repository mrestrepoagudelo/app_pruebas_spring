package com.ceiba.biblioteca.prestamo.infraestructure.adapter;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ceiba.biblioteca.prestamo.domain.constant.MsgConstant;
import com.ceiba.biblioteca.prestamo.domain.exception.ModelException;
import com.ceiba.biblioteca.prestamo.domain.model.entity.Prestamo;
import com.ceiba.biblioteca.prestamo.domain.port.IPrestamoRepositoryPort;
import com.ceiba.biblioteca.prestamo.infraestructure.adapter.entity.PrestamoEntity;
import com.ceiba.biblioteca.prestamo.infraestructure.adapter.respository.IPrestamoJpaRepository;

@Repository
public class PrestamoRepositoryAdapter implements IPrestamoRepositoryPort {

	@Autowired
	private ModelMapper modelMapper;

	private final IPrestamoJpaRepository prestamoJpaRepository;
	
	public PrestamoRepositoryAdapter(IPrestamoJpaRepository prestamoJpaRepository) {
		this.prestamoJpaRepository = prestamoJpaRepository;
	}

	@Override
	@Transactional
	public Prestamo create(Prestamo oPrestamo) {
		PrestamoEntity prestamoEntity = modelMapper.map(oPrestamo, PrestamoEntity.class);
		Prestamo prestamoSaved = modelMapper.map(prestamoJpaRepository.save(prestamoEntity), Prestamo.class);
		return prestamoSaved;
	}
	
	@Override
	public Prestamo getById(Long id) {
		Optional<PrestamoEntity> optionaPrestamo = prestamoJpaRepository.findById(id);
		
		if (optionaPrestamo.isEmpty()) {
			throw new ModelException(MsgConstant.MSG_REGISTRO_NO_ENCONTRADO);
		}

		return modelMapper.map(prestamoJpaRepository.save(optionaPrestamo.get()), Prestamo.class);
	}

	@Override
	public List<Prestamo> getAll() {
		List<Prestamo> listPrestamo = modelMapper.map(prestamoJpaRepository.findAll(),
						new TypeToken<List<Prestamo>>() {}.getType());
		return listPrestamo;
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		prestamoJpaRepository.deleteById(id);
	}
}
