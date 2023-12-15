package com.coop.infrastructure.repository.perfil;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coop.infrastructure.entity.PerfilEntity;

public interface IPerfilJpaRepository extends JpaRepository<PerfilEntity, Long>{
	
}
