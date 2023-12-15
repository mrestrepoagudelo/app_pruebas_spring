package com.ceiba.biblioteca.biblioteca.infraestructure.adapter.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.biblioteca.biblioteca.infraestructure.adapter.entity.BibliotecaEntity;

@Repository
public interface IBibliotecaJpaRepository extends JpaRepository<BibliotecaEntity, Long>{
}
