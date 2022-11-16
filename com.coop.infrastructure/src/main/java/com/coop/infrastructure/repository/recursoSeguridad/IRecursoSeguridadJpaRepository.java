package com.coop.infrastructure.repository.recursoSeguridad;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coop.infrastructure.entities.RecursoSeguridadEntity;

public interface IRecursoSeguridadJpaRepository extends JpaRepository<RecursoSeguridadEntity, Long>{
	public RecursoSeguridadEntity findByControl(String control);
}
