package com.coop.infrastructure.repository.perfilRecursoSeguridad;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coop.infrastructure.entities.PerfilRecursoSeguridadEntity;

public interface IPerfilRecursoSeguridadJpaRepository extends JpaRepository<PerfilRecursoSeguridadEntity, Long>{
	public PerfilRecursoSeguridadEntity findByIdPerfilAndIdRecursoSeguridad(Long idPerfil, Long idRecursoSeguridad); 
}
