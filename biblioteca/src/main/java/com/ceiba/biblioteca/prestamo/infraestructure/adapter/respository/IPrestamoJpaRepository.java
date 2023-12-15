package com.ceiba.biblioteca.prestamo.infraestructure.adapter.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.biblioteca.prestamo.infraestructure.adapter.entity.PrestamoEntity;

@Repository
public interface IPrestamoJpaRepository extends JpaRepository<PrestamoEntity, Long> {
	
}
