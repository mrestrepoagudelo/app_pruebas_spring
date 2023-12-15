package com.ceiba.biblioteca.libro.infraestructure.adapter.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.biblioteca.libro.infraestructure.adapter.entity.LibroEntity;

@Repository
public interface ILibroJpaRepository extends JpaRepository<LibroEntity, Long>{
}
