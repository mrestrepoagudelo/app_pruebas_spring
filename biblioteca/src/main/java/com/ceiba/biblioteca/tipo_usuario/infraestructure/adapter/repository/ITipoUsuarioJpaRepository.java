package com.ceiba.biblioteca.tipo_usuario.infraestructure.adapter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.biblioteca.tipo_usuario.infraestructure.adapter.entity.TipoUsuarioEntity;

@Repository
public interface ITipoUsuarioJpaRepository extends JpaRepository<TipoUsuarioEntity, Long>{
}
